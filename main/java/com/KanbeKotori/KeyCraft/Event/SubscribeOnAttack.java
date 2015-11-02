package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

import com.KanbeKotori.KeyCraft.Helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnAttack {
	
	@SubscribeEvent
	public void AttackWithFire(LivingAttackEvent event) {
		if (event.source.damageType == "player") {
			EntityPlayer player = MainHelper.getPlayerSv(MainHelper.getName());
			if (RewriteHelper.getPoint(player, 221)) {
				event.entityLiving.setFire(8000);
    		}
    	}
	}
	
	@SubscribeEvent
	public void AttackWithPoison(LivingAttackEvent event) {
		if (event.source.damageType == "player") {
			EntityPlayer player = MainHelper.getPlayerSv(MainHelper.getName());
			if (RewriteHelper.getPoint(player, 222)) {
				event.entityLiving.addPotionEffect(new PotionEffect(19, 100, 1));
    		}
    	}
	}
	
	@SubscribeEvent
	public void AttackWithWither(LivingAttackEvent event) {
		if (event.source.damageType == "player") {
			EntityPlayer player = MainHelper.getPlayerSv(MainHelper.getName());
			if (RewriteHelper.getPoint(player, 223)) {
				event.entityLiving.addPotionEffect(new PotionEffect(20, 100));
    		}
    	}
	}
	
	@SubscribeEvent
	public void AttackWithLifeDrawing(LivingAttackEvent event) {
		if (event.source.damageType == "player") {
			EntityPlayer player = MainHelper.getPlayerSv(MainHelper.getName());
			if (RewriteHelper.getPoint(player, 241)) {
				player.setHealth(player.getHealth() + 2);
    		}
    	}
	}
	
}
