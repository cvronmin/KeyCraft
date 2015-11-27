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
package com.KanbeKotori.KeyCraft.Event;

import java.util.Random;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

import com.KanbeKotori.KeyCraft.Helper.*;
import com.KanbeKotori.KeyCraft.Network.RewriteNetwork;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnKillDown {
	
	/** 给予玩家Skill243-『欧若拉掠夺』的欧若拉点数 */
	@SubscribeEvent
    public void Point_AuroraRob(LivingDeathEvent event) {
		if ((event.source.getEntity() instanceof EntityPlayer)) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (!player.worldObj.isRemote // 随机事件只发生在服务器
				&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRob.id)
				) {
				if (new Random().nextInt(32) == 16) {
					RewriteHelper.modifyAuroraPoint(player, 1);
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.aurorarob")));
				} else {
					//测试用
					//player.addChatMessage(new ChatComponentText("false"));
				}
			}
		}
	}

}
