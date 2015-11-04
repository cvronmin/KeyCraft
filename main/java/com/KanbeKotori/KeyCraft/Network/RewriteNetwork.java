package com.KanbeKotori.KeyCraft.Network;

import java.io.IOException;

import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;

public class RewriteNetwork {
	
	public static final String REWRITE_CHANNEL = "REWRITE_CHANNEL";
	public static FMLEventChannel rewriteChannel;

	public static final int SYNC_SKILL_CODE = 1;
	public static final int LEARN_SKILL_CODE = 2;
	
	/** 服务器封包处理 */
	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent event) {
		ByteBufInputStream stream = new ByteBufInputStream(event.packet.payload());
		try {
			int code = stream.readInt();
			
			switch (code) {
			case LEARN_SKILL_CODE:
				int id = stream.readInt();
				EntityPlayer player = ((NetHandlerPlayServer)event.handler).playerEntity;
				if (id == RewriteHelper.AuroraCognition.id) {
		    		RewriteHelper.setPoint_First(player);
		    	} else {
		    		if (RewriteHelper.getAuroraPoint(player) > RewriteHelper.getAuroraRequired(id)) {
		    			RewriteHelper.minusAuroraPoint(player, RewriteHelper.getAuroraRequired(id));
		    			RewriteHelper.setPoint(player, id, true);
		    		}
		    	}
				rewriteChannel.sendTo(createSyncSkillPacket(player), (EntityPlayerMP)player);
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
		ByteBufInputStream stream = new ByteBufInputStream(event.packet.payload());
		try {
			int code = stream.readInt();
			
			switch (code) {
			case SYNC_SKILL_CODE:
				EntityPlayer player = MainHelper.getPlayerCl();
				RewriteHelper.setAuroraPoint(player, stream.readInt());
				for (int i = 0; i < RewriteHelper.SKILLS.length; i++) {
					RewriteHelper.setPoint(player, RewriteHelper.SKILLS[i].id, stream.readBoolean());
				}
				break;
			}
			
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	////////////////////////////////// 创建封包用的函数 //////////////////////////////////
	
	public static FMLProxyPacket createSyncSkillPacket(EntityPlayer player) {
		ByteBufOutputStream stream = new ByteBufOutputStream(Unpooled.buffer());
		FMLProxyPacket packet = null;
		try {
			stream.writeInt(SYNC_SKILL_CODE);
			stream.writeInt(RewriteHelper.getAuroraPoint(player));
			for (RewriteHelper.Skill i : RewriteHelper.SKILLS) {
				stream.writeBoolean(RewriteHelper.getPoint(player, i.id));
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

}
