/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * 本作品版权由Nulla开发组所有。
 * Developed by Kanbe-Kotori & xfgryujk.
 * 本作品由 Kanbe-Kotori & xfgryujk 合作开发。
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.event;

import com.kanbekotori.keycraft.helper.*;
import com.kanbekotori.keycraft.helper.RewriteHelper.Skill;
import com.kanbekotori.keycraft.network.RewriteNetwork;

import net.minecraft.entity.player.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraftforge.event.ServerChatEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeCheating {
	
	@SubscribeEvent
    public void GodBless(ServerChatEvent event) {
        if(event.message.toLowerCase().equals("kotori")) {
        	event.setCanceled(true);
            EntityPlayerMP player = event.player;
            if (!player.worldObj.isRemote) {
                RewriteHelper.modifyAuroraPoint(player, 100);
                player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.cheat1")));
            }
        } else if(event.message.toLowerCase().equals("reset")) {
        	event.setCanceled(true);
            EntityPlayerMP player = event.player;
            if (!player.worldObj.isRemote) {
                RewriteHelper.setAuroraPoint(player, 100);
                for (Skill i : RewriteHelper.SKILLS) {
        			final String name = "Skill" + String.format("%03d", i.id);
        			player.getEntityData().setBoolean(name, false);
        		}
                RewriteNetwork.rewriteChannel.sendTo(RewriteNetwork.createSyncSkillPacket(player), player);
                player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.cheat2")));
            }
        } else if(event.message.toLowerCase().equals("sakuya")) {
        	event.setCanceled(true);
            EntityPlayerMP player = event.player;
            if (!player.worldObj.isRemote) {
    			player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 0x7FFFFFFF, 94));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 0x7FFFFFFF, 9));
                player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.cheat3")));
            }
        } else if(event.message.toLowerCase().equals("kagari")) {
        	event.setCanceled(true);
            EntityPlayerMP player = event.player;
            if (!player.worldObj.isRemote) {
                RewriteHelper.setAuroraPoint(player, 100);
                for (Skill i : RewriteHelper.SKILLS) {
        			final String name = "Skill" + String.format("%03d", i.id);
        			player.getEntityData().setBoolean(name, true);
        		}
                RewriteNetwork.rewriteChannel.sendTo(RewriteNetwork.createSyncSkillPacket(player), player);
                player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.cheat4")));
            }
        }
    }

}
