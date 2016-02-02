/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori & xfgryujk.
 * ����Ʒ�� Kanbe-Kotori & xfgryujk ����������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.network;

import java.io.IOException;

import com.kanbekotori.keycraft.helper.*;
import com.kanbekotori.keycraft.items.ModItems;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.*;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.FMLNetworkEvent.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.*;

public class RewriteNetwork {
	
	public static final String REWRITE_CHANNEL = "REWRITE_CHANNEL";
	public static FMLEventChannel rewriteChannel;

	public static final int SYNC_AURORA_POINT_CODE = 0;
	public static final int SYNC_SKILL_CODE = 1;
	public static final int LEARN_SKILL_CODE = 2;
	public static final int USE_SKILL_CODE = 3;
	
	public static class SendSyncPacket {
		/** ��ͬ���� */
		protected static void syncSkills(EntityPlayer player) {
			if (player instanceof EntityPlayerMP) {
				rewriteChannel.sendTo(createSyncAuroraPointPacket(player), (EntityPlayerMP)player);
				rewriteChannel.sendTo(createSyncSkillPacket(player), (EntityPlayerMP)player);
			}
		}
		
		/** ��������ҵ�½���� */
		@SubscribeEvent
		public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
			syncSkills(event.player);
		}
		
		/** ��Ҹ���� */
		@SubscribeEvent
		public void onPlayerRespawn(PlayerRespawnEvent event) {
			syncSkills(event.player);
		}
		
		/** ����л����紦�� */
		@SubscribeEvent
		public void onPlayerChangeDimension(PlayerChangedDimensionEvent event) {
			syncSkills(event.player);
		}
	}
	
	/** ������������� */
	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent event) {
		EntityPlayerMP player = ((NetHandlerPlayServer)event.handler).playerEntity;
		
		ByteBufInputStream stream = new ByteBufInputStream(event.packet.payload());
		try {
			switch (stream.readInt()) {
			case LEARN_SKILL_CODE:
	    		RewriteHelper.learnSkill(player, stream.readInt());
				break;
				
			case USE_SKILL_CODE:
				RewriteHelper.useSkill(player);
				break;
			}
			
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** �ͻ��˷������ */
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
	
	////////////////////////////////// ��������õĺ��� //////////////////////////////////
	
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
