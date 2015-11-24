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

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribeOnTick_Effect {
	
	/** 实现Skill331-『治愈之雾』的效果 */
	@SubscribeEvent
	public void Point_CuringFog(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // 随机事件只发生在服务器
			&& RewriteHelper.hasSkill(player, RewriteHelper.CuringFog.id)
			&& new Random().nextInt(2400) == 1200
			) {
			List entities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX-3.0D, player.posY-2.0D, player.posZ-3.0D, player.posX+3.0D, player.posY+2.0D, player.posZ+3.0D));
    		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
    			EntityLivingBase entity = (EntityLivingBase)iterator.next();
    			if (entity.isPotionActive(Potion.blindness)) entity.removePotionEffect(Potion.blindness.id);
    			if (entity.isPotionActive(Potion.confusion)) entity.removePotionEffect(Potion.confusion.id);
    			if (entity.isPotionActive(Potion.digSlowdown)) entity.removePotionEffect(Potion.digSlowdown.id);
    			if (entity.isPotionActive(Potion.hunger)) entity.removePotionEffect(Potion.hunger.id);
    			if (entity.isPotionActive(Potion.poison)) entity.removePotionEffect(Potion.poison.id);
    			if (entity.isPotionActive(Potion.weakness)) entity.removePotionEffect(Potion.weakness.id);
    			if (entity.isPotionActive(Potion.wither)) entity.removePotionEffect(Potion.wither.id);			
    		}
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.cure")));
		}
	}
	
	/** 实现Skill332-『治疗之雾』的效果 */
	@SubscribeEvent
	public void Point_HealingFog(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // 随机事件只发生在服务器
			&& RewriteHelper.hasSkill(player, RewriteHelper.HealingFog.id)
			&& new Random().nextInt(2400) == 1200
			) {
			List entities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX-3.0D, player.posY-2.0D, player.posZ-3.0D, player.posX+3.0D, player.posY+2.0D, player.posZ+3.0D));
    		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
    			EntityLivingBase entity = (EntityLivingBase)iterator.next();
    			entity.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
    		}
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.heal")));
		}
	}
	
	/** 实现Skill333-『伤害之雾』的效果 */
	@SubscribeEvent
	public void Point_HurtingFog(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // 随机事件只发生在服务器
			&& RewriteHelper.hasSkill(player, RewriteHelper.HurtingFog.id)
			&& new Random().nextInt(2400) == 1200
			) {
			List entities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX-3.0D, player.posY-2.0D, player.posZ-3.0D, player.posX+3.0D, player.posY+2.0D, player.posZ+3.0D));
    		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
    			EntityLivingBase entity = (EntityLivingBase)iterator.next();
    			if (!entity.equals(player)) entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10.0F);
    		}
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.hurt")));
		}
	}
	
	/** 给予玩家Skill343-『欧若拉再生』的欧若拉点数 */
	@SubscribeEvent
	public void Point_AuroraAutoRecover(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // 随机事件只发生在服务器
			&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRegeneration.id)
			&& new Random().nextInt(6000) == 3000
			) {
			RewriteHelper.modifyAuroraPoint(player, 1);
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.aurorarecovery")));
		}
	}

}
