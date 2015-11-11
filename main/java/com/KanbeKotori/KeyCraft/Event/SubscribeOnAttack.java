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

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

import com.KanbeKotori.KeyCraft.Helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnAttack {
	
	/** 实现玩家Skill221-『火焰附加』的效果。 */
	@SubscribeEvent
	public void AttackWithFire(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.hasSkill(player, RewriteHelper.FireAttach.id)) {
				event.entityLiving.setFire(8000);
	    	}
    	}
	}
	
	/** 实现玩家Skill222-『剧毒附加』的效果。 */
	@SubscribeEvent
	public void AttackWithPoison(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.hasSkill(player, RewriteHelper.PoisonAttach.id)) {
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
	    	}
    	}
	}
	
	/** 实现玩家Skill223-『凋零附加』的效果。 */
	@SubscribeEvent
	public void AttackWithWither(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.hasSkill(player, RewriteHelper.WitherAttach.id)) {
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, 100));
	    	}
    	}
	}
	
	/** 给予玩家Skill232-『蛮力』的力量Buff */
	@SubscribeEvent
	public void Point_AutoBuffPower(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.hasSkill(player, RewriteHelper.BruteForce.id)
				&& !player.isPotionActive(Potion.damageBoost)
				) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 1));
				if (!player.worldObj.isRemote) {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.power")));
				}
			}
		}
	}
	
	/** 实现玩家Skill241-『生命虹吸』的效果。 */
	@SubscribeEvent
	public void AttackWithLifeDrawing(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.hasSkill(player, RewriteHelper.LifeSuck.id)) {
				player.setHealth(player.getHealth() + 2);
	    	}
    	}
	}
	
}
