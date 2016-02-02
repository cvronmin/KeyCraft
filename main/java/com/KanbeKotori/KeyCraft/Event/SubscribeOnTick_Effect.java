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

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.kanbekotori.keycraft.helper.*;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribeOnTick_Effect {
	
	/** ʵ��Skill331-������֮����Ч���� */
	@SubscribeEvent
	public void Point_CuringFog(PlayerTickEvent event) {
		if (event.phase == Phase.END) {
			return;
		}
		
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // ����¼�ֻ�����ڷ�����
			&& RewriteHelper.hasSkill(player, RewriteHelper.CuringFog.id)
			&& new Random().nextInt(1200) == 600
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
	
	/** ʵ��Skill332-������֮����Ч���� */
	@SubscribeEvent
	public void Point_HealingFog(PlayerTickEvent event) {
		if (event.phase == Phase.END) {
			return;
		}
		
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // ����¼�ֻ�����ڷ�����
			&& RewriteHelper.hasSkill(player, RewriteHelper.HealingFog.id)
			&& new Random().nextInt(2400) == 800
			) {
			List entities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX-3.0D, player.posY-2.0D, player.posZ-3.0D, player.posX+3.0D, player.posY+2.0D, player.posZ+3.0D));
    		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
    			EntityLivingBase entity = (EntityLivingBase)iterator.next();
    			entity.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
    		}
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.heal")));
		}
	}
	
	/** ʵ��Skill333-���˺�֮����Ч���� */
	@SubscribeEvent
	public void Point_HurtingFog(PlayerTickEvent event) {
		if (event.phase == Phase.END) {
			return;
		}
		
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // ����¼�ֻ�����ڷ�����
			&& RewriteHelper.hasSkill(player, RewriteHelper.HurtingFog.id)
			&& new Random().nextInt(2400) == 1600
			) {
			List entities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX-3.0D, player.posY-2.0D, player.posZ-3.0D, player.posX+3.0D, player.posY+2.0D, player.posZ+3.0D));
    		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
    			EntityLivingBase entity = (EntityLivingBase)iterator.next();
    			if (!entity.equals(player)) entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10.0F);
    		}
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.hurt")));
		}
	}
	
	/** �������Skill343-��ŷ������������ŷ�������� */
	@SubscribeEvent
	public void Point_AuroraAutoRecover(PlayerTickEvent event) {
		if (event.phase == Phase.END) {
			return;
		}
		
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote // ����¼�ֻ�����ڷ�����
			&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRegeneration.id)
			&& new Random().nextInt(6000) == 3000
			) {
			RewriteHelper.modifyAuroraPoint(player, 1);
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.aurorarecovery")));
		}
	}

}
