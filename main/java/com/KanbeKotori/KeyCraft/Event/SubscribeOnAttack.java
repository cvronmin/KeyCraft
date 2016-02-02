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

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

import com.kanbekotori.keycraft.helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnAttack {
	
	/** ʵ�����Skill221-�����渽�ӡ���Ч���� */
	@SubscribeEvent
	public void AttackWithFire(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.hasSkill(player, RewriteHelper.FireAttach.id)) {
				event.entityLiving.setFire(8000);
	    	}
    	}
	}
	
	/** ʵ�����Skill222-���綾���ӡ���Ч���� */
	@SubscribeEvent
	public void AttackWithPoison(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.hasSkill(player, RewriteHelper.PoisonAttach.id)) {
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
	    	}
    	}
	}
	
	/** ʵ�����Skill223-�����㸽�ӡ���Ч���� */
	@SubscribeEvent
	public void AttackWithWither(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.hasSkill(player, RewriteHelper.WitherAttach.id)) {
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, 100));
	    	}
    	}
	}
	
	/** �������Skill232-��������������Buff */
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
	
	/** ʵ�����Skill241-��������������Ч���� */
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
