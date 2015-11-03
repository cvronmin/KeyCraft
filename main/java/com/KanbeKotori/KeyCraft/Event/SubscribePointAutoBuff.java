package com.KanbeKotori.KeyCraft.Event;

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
	public long last_Buff_Resistance = 0;
	public long last_Buff_MoreHealth = 0;
	public long last_Buff_Power = 0;
	public long last_Buff_Continuous = 0;
	
	public boolean isCD_Buff_ER() {
    	if (System.currentTimeMillis() - last_Buff_ER >= 300000) {
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
	
	public boolean isCD_Buff_Resistance() {
    	if (System.currentTimeMillis() - last_Buff_Resistance >= 30000) {
    		last_Buff_Resistance = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_Buff_MoreHealth() {
    	if (System.currentTimeMillis() - last_Buff_MoreHealth >= 0x7FFFFFFF) {
    		last_Buff_MoreHealth = System.currentTimeMillis();
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
	public void Point_ER(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.getPoint(player, RewriteHelper.UrgentProtect.id) && player.getHealth() <= 6 && RewriteHelper.getAuroraPoint(player) > 5) {
			if (isCD_Buff_ER()) {
	    		if (player.worldObj.isRemote) {
	    			RewriteHelper.minusAuroraPoint(player, 5);
	    		}
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
		if (RewriteHelper.getPoint(player, RewriteHelper.PhysiqueUp.id) && isCD_Buff_MoreHealth()) {
			player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 0x7FFFFFFF, 4));
		}
	}
	
	@SubscribeEvent
	public void Point_AutoBuffResistance(LivingAttackEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if (event.source.damageType.equals("arrow") || event.source.damageType.equals("mob") || event.source.damageType.equals("player")) {
				if (RewriteHelper.getPoint(player, RewriteHelper.BattleReadiness.id) && isCD_Buff_Resistance()) {
					player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
					if (!player.worldObj.isRemote) {
						player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.resistance")));
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void Point_AutoBuffPower(LivingAttackEvent event) {
		if (event.source.damageType.equals("arrow")) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if (RewriteHelper.getPoint(player, RewriteHelper.BruteForce.id) && isCD_Buff_Power()) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 400, 1));
				if (!player.worldObj.isRemote) {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.power")));
				}
			}
		}
	}
	
	@SubscribeEvent
	public void Point_AutoHeal(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (player.getHealth() < 20) {
			if (RewriteHelper.getPoint(player, RewriteHelper.AuroraSurge.id) && isCD_Buff_Continuous()) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 1));
			} else if (RewriteHelper.getPoint(player, RewriteHelper.AuroraActivation.id) && isCD_Buff_Continuous()) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80));
			}
		}
	}
	
	@SubscribeEvent
	public void Point_Burst(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (RewriteHelper.getPoint(player, RewriteHelper.PhysiqueUp.id)
			&& RewriteHelper.getPoint(player, RewriteHelper.WitherAttach.id)
			&& RewriteHelper.getPoint(player, RewriteHelper.AuroraRob.id)
			&& RewriteHelper.getPoint(player, RewriteHelper.FireResistMax.id) 
			&& RewriteHelper.getPoint(player, RewriteHelper.UltimateHardening.id) 
			&& RewriteHelper.getPoint(player, RewriteHelper.AuroraRegeneration.id) 
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
				if (!RewriteHelper.getPoint(player, RewriteHelper.BruteForce.id) && isCD_Buff_Continuous()) {
					player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 80, 1)); 	
				}
			}
		}
	}

}
