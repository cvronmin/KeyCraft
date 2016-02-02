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
package com.kanbekotori.keycraft.event;

import java.util.*;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.kanbekotori.keycraft.helper.*;
import com.kanbekotori.keycraft.items.ModItems;
import com.kanbekotori.keycraft.network.RewriteNetwork;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribeOnTick_Buff {
	
	/** �ж�Skill200-�������������Ƿ��Ѿ�CD�����ǲ���ͬ�����������л����������CD�� */
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
	
	/** �������Skill100-�������ɶ������ٶ�Buff */
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
	
	/** �������Skill141-�����Ԫ��֪����ҹ��Buff */
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
	
	/** �������Skill142-��ҹ�ӡ���ҹ��Buff */
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
	
	/** �������Skill200-���������������ٶ�Buff */
	@SubscribeEvent
	public void Point_ER(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.UrgentProtect.id)
			&& player.getHealth() > 0
			&& player.getHealth() <= player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue() * 0.25
			&& RewriteHelper.getAuroraPoint(player) > 5
			&& isCD_Buff_ER(player)
			) {
	    	RewriteHelper.modifyAuroraPoint(player, -5);
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 4));
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 1));
		}
	}
	
	/** �������Skill212-����������������������Buff */
	@SubscribeEvent
	public void Point_MoreHealth(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.PhysiqueUp.id)
			&& !player.isPotionActive(Potion.field_76434_w)
			) {
			player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 0x7FFFFFFF, 2));
		}
	}
	
	/** �������Skill341-��ŷ�������\Skill342-��ŷ����ӿ�����������ظ�Buff */
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
	
	/** �������Skill���ർ�µ�ŷ�������ߵ��ٶȺ���Ծ����Buff */
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
	
	/** ������ҳ��е��߸���ʱû��Skill232-���������Ļ���Debuff */
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
