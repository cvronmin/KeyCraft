package com.KanbeKotori.KeyCraft.Network;

import java.io.IOException;

import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import com.KanbeKotori.KeyCraft.Items.ModItems;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;

public class RewriteNetwork {
	
	public static final String REWRITE_CHANNEL = "REWRITE_CHANNEL";
	public static FMLEventChannel rewriteChannel;

	public static final int SYNC_AURORA_POINT_CODE = 0;
	public static final int SYNC_SKILL_CODE = 1;
	public static final int LEARN_SKILL_CODE = 2;
	public static final int USE_SKILL_CODE = 3;
	
	public static class SendSyncPacket {
		/** 服务器玩家登陆处理 */
		@SubscribeEvent
		public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
			EntityPlayer player = event.player;
			
			// 同步技能数据
			rewriteChannel.sendTo(createSyncAuroraPointPacket(player), (EntityPlayerMP)player);
			rewriteChannel.sendTo(createSyncSkillPacket(player), (EntityPlayerMP)player);
		}
		
		/** 玩家复活处理 */
		@SubscribeEvent
		public void onPlayerLoggedIn(PlayerRespawnEvent event) {
			EntityPlayer player = event.player;
			if (player instanceof EntityPlayerMP) {
				// 同步技能数据
				rewriteChannel.sendTo(createSyncAuroraPointPacket(player), (EntityPlayerMP)player);
				rewriteChannel.sendTo(createSyncSkillPacket(player), (EntityPlayerMP)player);
			}
		}
	}
	
	/** 服务器封包处理 */
	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent event) {
		EntityPlayerMP player = ((NetHandlerPlayServer)event.handler).playerEntity;
		
		ByteBufInputStream stream = new ByteBufInputStream(event.packet.payload());
		try {
			switch (stream.readInt()) {
			case LEARN_SKILL_CODE:
				int id = stream.readInt();
				if (id == RewriteHelper.AuroraCognition.id) {
		    		RewriteHelper.initializeSkills(player);
		    	} else {
		    		if (RewriteHelper.getAuroraPoint(player) > RewriteHelper.getAuroraRequired(id)) {
		    			RewriteHelper.modifyAuroraPoint(player, -RewriteHelper.getAuroraRequired(id));
		    			RewriteHelper.learnSkill(player, id, true);
		    		}
		    	}
				break;
				
			case USE_SKILL_CODE:
	    		ItemStack held = player.getHeldItem();
	    		if (held == null) {
	    			if (RewriteHelper.hasSkill(player, RewriteHelper.AuroraBlade.id) && RewriteHelper.getAuroraPoint(player) > 1) {
		    			RewriteHelper.modifyAuroraPoint(player, -1);
		    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraBlade, 1));
		    			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.callblade")));
		    		} else if (RewriteHelper.hasSkill(player, RewriteHelper.AuroraTrident.id) && RewriteHelper.getAuroraPoint(player) > 1) {
		    			RewriteHelper.modifyAuroraPoint(player, -1);
		    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraTrident, 1));
		    			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.calltrident")));
		    		}
		    	} else if (held.getItem() == Items.iron_sword) {
		    		if (RewriteHelper.hasSkill(player, RewriteHelper.SuperVibration.id) && RewriteHelper.getAuroraPoint(player) > 1) {
		    			RewriteHelper.setShakingSwordDamage(player, held.getItemDamage());
		    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.ShakingSword, 1));
		    			RewriteHelper.modifyAuroraPoint(player, -1);
		    			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.shakingsword")));
		    		}
		    	}
				break;
			}
			
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 客户端封包处理 */
	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent event) {
		EntityPlayer player = MainHelper.getPlayerCl();
		
		ByteBufInputStream stream = new ByteBufInputStream(event.packet.payload());
		try {
			switch (stream.readInt()) {
			case SYNC_AURORA_POINT_CODE:
				RewriteHelper.setAuroraPoint(player, stream.readInt());
				break;
				
			case SYNC_SKILL_CODE:
				for (int i = 0; i < RewriteHelper.SKILLS.length; i++) {
					RewriteHelper.learnSkill(player, RewriteHelper.SKILLS[i].id, stream.readBoolean());
				}
				break;
			}
			
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	////////////////////////////////// 创建封包用的函数 //////////////////////////////////
	
	public static FMLProxyPacket createSyncAuroraPointPacket(EntityPlayer player) {
		ByteBufOutputStream stream = new ByteBufOutputStream(Unpooled.buffer());
		FMLProxyPacket packet = null;
		try {
			stream.writeInt(SYNC_AURORA_POINT_CODE);
			stream.writeInt(RewriteHelper.getAuroraPoint(player));
			
			packet = new FMLProxyPacket(stream.buffer(), REWRITE_CHANNEL);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return packet;
	}
	
	public static FMLProxyPacket createSyncSkillPacket(EntityPlayer player) {
		ByteBufOutputStream stream = new ByteBufOutputStream(Unpooled.buffer());
		FMLProxyPacket packet = null;
		try {
			stream.writeInt(SYNC_SKILL_CODE);
			for (RewriteHelper.Skill i : RewriteHelper.SKILLS) {
				stream.writeBoolean(RewriteHelper.hasSkill(player, i.id));
			}
			
			packet = new FMLProxyPacket(stream.buffer(), REWRITE_CHANNEL);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return packet;
	}
	
	public static FMLProxyPacket createLearnSkillPacket(int skillId) {
		ByteBufOutputStream stream = new ByteBufOutputStream(Unpooled.buffer());
		FMLProxyPacket packet = null;
		try {
			stream.writeInt(LEARN_SKILL_CODE);
			stream.writeInt(skillId);
			
			packet = new FMLProxyPacket(stream.buffer(), REWRITE_CHANNEL);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return packet;
	}
	
	public static FMLProxyPacket createUseSkillPacket() {
		ByteBufOutputStream stream = new ByteBufOutputStream(Unpooled.buffer());
		FMLProxyPacket packet = null;
		try {
			stream.writeInt(USE_SKILL_CODE);
			
			packet = new FMLProxyPacket(stream.buffer(), REWRITE_CHANNEL);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return packet;
	}

}
