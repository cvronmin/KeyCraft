package com.KanbeKotori.KeyCraft.Event;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.KanbeKotori.KeyCraft.Helper.*;
import com.KanbeKotori.KeyCraft.Items.ModItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribePointAutoBuff {

	public long last_Buff_ER = 0;
	public long last_Buff_Power = 0;
	public long last_Buff_Continuous = 0;
	
	public boolean isCD_Buff_ER() {
    	if (System.currentTimeMillis() - last_Buff_ER >= 600000) {
    		last_Buff_ER = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_Buff_Power() {
    	if (System.currentTimeMillis() - last_Buff_Power >= 30000) {
    		last_Buff_Power = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_Buff_Continuous() {
    	if (System.currentTimeMillis() - last_Buff_Continuous >= 3000) {
    		last_Buff_Continuous = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	@SubscribeEvent
	public void Point_AutoSpeedUp(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		List entities = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX-8.0D, player.posY-2.0D, player.posZ-8.0D, player.posX+8.0D, player.posY+2.0D, player.posZ+8.0D));
		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
			EntityLiving entity = (EntityLiving)iterator.next();
			if(!entity.equals(player)) {
				if (RewriteHelper.hasSkill(player, RewriteHelper.HuntingRhythm.id)) {
					player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100));
				}
				return ;
			}
		}
	}
	
	@SubscribeEvent
	public void Point_ER(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.UrgentProtect.id) && player.getHealth() <= 6 && RewriteHelper.getAuroraPoint(player) > 5) {
			if (isCD_Buff_ER()) {
	    		RewriteHelper.modifyAuroraPoint(player, -5);
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 4));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 1));
				if (!player.worldObj.isRemote) {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.er")));
				}
			}
		}
	}
	
	@SubscribeEvent
	public void Point_MoreHealth(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.PhysiqueUp.id)) {
			if (player.isPotionActive(Potion.field_76434_w)) return;
			player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 0x7FFFFFFF, 4));
		}
	}
	
	@SubscribeEvent
	public void Point_AutoBuffPower(LivingAttackEvent event) {
		if (event.source.damageType.equals("player")) {
			EntityPlayer player = MainHelper.getPlayerCl();
			if (RewriteHelper.hasSkill(player, RewriteHelper.BruteForce.id) && isCD_Buff_Power()) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 1));
				if (player.worldObj.isRemote) {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.power")));
				}
			}
		}
	}
	
	@SubscribeEvent
	public void Point_AutoHeal(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (player.getHealth() < 20) {
			if (RewriteHelper.hasSkill(player, RewriteHelper.AuroraSurge.id) && isCD_Buff_Continuous()) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 1));
			} else if (RewriteHelper.hasSkill(player, RewriteHelper.AuroraActivation.id) && isCD_Buff_Continuous()) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80));
			}
		}
	}
	
	@SubscribeEvent
	public void Point_Burst(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.hasSkill(player, RewriteHelper.PhysiqueUp.id)
			&& RewriteHelper.hasSkill(player, RewriteHelper.WitherAttach.id)
			&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRob.id)
			&& RewriteHelper.hasSkill(player, RewriteHelper.FireResistMax.id) 
			&& RewriteHelper.hasSkill(player, RewriteHelper.UltimateHardening.id) 
			&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRegeneration.id) 
			&& isCD_Buff_Continuous()) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 80, 255));
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 80, 99));
		}
	}
	
	@SubscribeEvent
	public void Overweight(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		ItemStack held = player.getHeldItem();
		if (held != null) {
			if (held.getItem() == ModItems.WirePole) {
				if (!RewriteHelper.hasSkill(player, RewriteHelper.BruteForce.id) && isCD_Buff_Continuous()) {
					player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 80, 1)); 	
				}
			}
		}
	}

}
