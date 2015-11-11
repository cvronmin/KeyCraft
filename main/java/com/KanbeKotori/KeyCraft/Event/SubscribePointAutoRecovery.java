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

import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribePointAutoRecovery {
	
	/** 给予玩家Skill343-『欧若拉再生』的欧若拉点数 */
	@SubscribeEvent
	public void Point_AuroraAutoRecover(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // 随机事件只发生在服务器
			&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRegeneration.id)
			&& new Random().nextInt(2400) == 1200
			) {
			RewriteHelper.modifyAuroraPoint(player, 1);
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.aurorarecovery")));
		}
	}

}
