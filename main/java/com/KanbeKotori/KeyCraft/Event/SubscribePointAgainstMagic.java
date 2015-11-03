package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribePointAgainstMagic {
	
	private long last_against_arrow = 0;
	private long last_against_magic = 0;
	private long last_mention = 0;
	
	public boolean isCD_against_arrow(EntityPlayer player) {
    	if (System.currentTimeMillis() - last_against_arrow >= 10000) {
    		last_against_arrow = System.currentTimeMillis();
    		RewriteHelper.minusAuroraPoint(player, 1);
    		player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstarrow")));
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_against_magic(EntityPlayer player) {
    	if (System.currentTimeMillis() - last_against_magic >= 10000) {
    		last_against_magic = System.currentTimeMillis();
    		RewriteHelper.minusAuroraPoint(player, 1);
    		player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstmagic")));
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_mention(EntityPlayer player) {
    	if (System.currentTimeMillis() - last_mention >= 30000) {
    		last_mention = System.currentTimeMillis();
    		player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstmagicplus")));
    		return true;
    	}
    	return false;
    }
	
	@SubscribeEvent
	public void PointAgainstMagic(LivingAttackEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = MainHelper.getPlayerSv(MainHelper.getName());
			if (event.source.damageType.equals("arrow") || event.source.damageType.equals("explosion")) {
				if (RewriteHelper.getPoint(player, RewriteHelper.UltimateHardening.id)) {
    				event.setCanceled(true);
    				isCD_mention(player);
    			} else if (RewriteHelper.getPoint(player, RewriteHelper.ExplosionResist.id)) {
    				event.setCanceled(true);
    				isCD_against_arrow(player);
    			}
    		} else if (event.source.damageType.equals("magic") || event.source.damageType.equals("indirectMagic")) {
    			if (RewriteHelper.getPoint(player, RewriteHelper.UltimateHardening.id)) {
    				event.setCanceled(true);
    				isCD_mention(player);
    			} else if (RewriteHelper.getPoint(player, RewriteHelper.MagicResist.id)) {
    				event.setCanceled(true);
    				isCD_against_magic(player);
    			}
    		} 
		}
	}

}
