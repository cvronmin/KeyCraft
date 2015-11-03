package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

import com.KanbeKotori.KeyCraft.Helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribePointAgainstFire {
	
	private long last_against_fire = 0;
	private long last_against_lava = 0;
	private long last_buff_fire = 0;
	private long last_mention = 0;
	
	public boolean isCD_against_fire(EntityPlayer player) {
    	if (System.currentTimeMillis() - last_against_fire >= 60000) {
    		last_against_fire = System.currentTimeMillis();
    		if (!player.worldObj.isRemote) {
        		RewriteHelper.minusAuroraPoint(player, 1);
        		player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstfire")));
    		}
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_against_lava(EntityPlayer player) {
    	if (System.currentTimeMillis() - last_against_lava >= 30000) {
    		last_against_lava = System.currentTimeMillis();
    		//last_against_fire = last_against_lava;
    		if (!player.worldObj.isRemote) {
    			RewriteHelper.minusAuroraPoint(player, 1);
        		player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstlava")));
    		}
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_mention(EntityPlayer player) {
    	if (System.currentTimeMillis() - last_mention >= 30000) {
    		last_mention = System.currentTimeMillis();
    		if (!player.worldObj.isRemote) {
    			player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstfireplus")));
    		}
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_buff_fire(EntityPlayer player) {
    	if (System.currentTimeMillis() - last_buff_fire >= 60000) {
    		last_buff_fire = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	@SubscribeEvent
	public void PointAgainstFireAndLava(LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			if (event.source.damageType.equals("lava")) {
				if (RewriteHelper.getPoint(player, RewriteHelper.FireResistMax.id)) {
    				event.setCanceled(true); 
    				isCD_mention(player);
    				if (isCD_buff_fire(player)) {
    					player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1200));
    				}
    			} else if (RewriteHelper.getPoint(player, RewriteHelper.FireResistUp.id)) {
    				event.setCanceled(true);
    				isCD_against_lava(player);
    			}
    		} else if (event.source.damageType.equals("inFire") || event.source.damageType.equals("onFire")) {
    			if (RewriteHelper.getPoint(player, RewriteHelper.FireResistMax.id)) {
    				event.setCanceled(true); 
    				isCD_mention(player);
    				if (isCD_buff_fire(player)) {
    					player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1200));
    				}
    			} else if (RewriteHelper.getPoint(player, RewriteHelper.FireResistUp.id)) {
    				event.setCanceled(true);
    				isCD_mention(player);
    			} else if (RewriteHelper.getPoint(player, RewriteHelper.FireResist.id)) {
    				event.setCanceled(true);
    				isCD_against_fire(player);
    			}
    		} 
		}
	}

}
