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

import java.util.*;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.KanbeKotori.KeyCraft.Helper.*;
import com.KanbeKotori.KeyCraft.Items.ModItems;
import com.KanbeKotori.KeyCraft.Network.RewriteNetwork;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribeOnTick_Buff {
	
	/** 判断Skill200-『紧急防护』是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_Buff_ER(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_ER") >= 300 * 20) {
    		player.getEntityData().setLong("LastTime_ER", time);
    		if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.er")));
			}
    		return true;
    	}
    	return false;
    }
	
	/** 给予玩家Skill100-『狩猎律动』的速度Buff */
	@SubscribeEvent
	public void Point_AutoSpeedUp(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.HuntingRhythm.id)
			&& !player.isPotionActive(Potion.moveSpeed)
			) {
			List entities = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX-8.0D, player.posY-2.0D, player.posZ-8.0D, player.posX+8.0D, player.posY+2.0D, player.posZ+8.0D));
			for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
				EntityLiving entity = (EntityLiving)iterator.next();
				if(!entity.equals(player)) {
					player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100));
					return;
				}
			}
		}
	}
	
	/** 给予玩家Skill141-『异次元感知』的夜视Buff */
	@SubscribeEvent
	public void Point_OtherWorldPerception(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.OtherWorldPerception.id)
			&& !player.isPotionActive(Potion.nightVision)
			&& !player.worldObj.provider.isSurfaceWorld()
			) {
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200));
		}
	}
	
	/** 给予玩家Skill142-『夜视』的夜视Buff */
	@SubscribeEvent
	public void Point_Nightvision(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.Nightvision.id)
			&& !player.isPotionActive(Potion.nightVision)
			&& !player.worldObj.provider.isDaytime()
			&& player.worldObj.provider.isSurfaceWorld()
			) {
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 11000));
            player.addChatComponentMessage(new ChatComponentText("The night starts."));
		}
	}
	
	/** 给予玩家Skill200-『紧急防护』的速度Buff */
	@SubscribeEvent
	public void Point_ER(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.UrgentProtect.id)
			&& player.getHealth() <= 6
			&& RewriteHelper.getAuroraPoint(player) > 5
			&& isCD_Buff_ER(player)
			) {
	    	RewriteHelper.modifyAuroraPoint(player, -5);
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 4));
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 1));
		}
	}
	
	/** 给予玩家Skill212-『体质提升』的生命提升Buff */
	@SubscribeEvent
	public void Point_MoreHealth(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.PhysiqueUp.id)
			&& !player.isPotionActive(Potion.field_76434_w)
			) {
			player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 0x7FFFFFFF, 2));
		}
	}
	
	/** 给予玩家Skill341-『欧若拉激活』\Skill342-『欧若拉涌动』的生命回复Buff */
	@SubscribeEvent
	public void Point_AutoHeal(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (player.getHealth() < player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue()
			&& !player.isPotionActive(Potion.regeneration)
			) {
			if (RewriteHelper.hasSkill(player, RewriteHelper.AuroraSurge.id)) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 1));
			} else if (RewriteHelper.hasSkill(player, RewriteHelper.AuroraActivation.id)) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100));
			}
		}
	}
	
	/** 给予玩家Skill过多导致的欧若拉暴走的速度和跳跃提升Buff */
	@SubscribeEvent
	public void Point_Burst(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.PhysiqueUp.id)
			&& RewriteHelper.hasSkill(player, RewriteHelper.WitherAttach.id)
			&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRob.id)
			&& RewriteHelper.hasSkill(player, RewriteHelper.FireResistMax.id) 
			&& RewriteHelper.hasSkill(player, RewriteHelper.HurtingFog.id) 
			&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRegeneration.id) 
			) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 255));
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 100, 99));
		}
	}
	
	/** 给予玩家持有电线杆子时没有Skill232-『蛮力』的缓慢Debuff */
	@SubscribeEvent
	public void Overweight(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (!RewriteHelper.hasSkill(player, RewriteHelper.BruteForce.id)) {
			ItemStack held = player.getHeldItem();
			if (held != null
				&& held.getItem() == ModItems.WirePole
				) {
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1)); 
			}
		}
	}

}
