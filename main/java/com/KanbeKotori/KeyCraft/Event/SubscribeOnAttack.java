package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

import com.KanbeKotori.KeyCraft.Helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnAttack {
	
	@SubscribeEvent
	public void AttackWithFire(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.getPoint(player, RewriteHelper.FireAttach.id)) {
				event.entityLiving.setFire(8000);
	    	}
    	}
	}
	
	@SubscribeEvent
	public void AttackWithPoison(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.getPoint(player, RewriteHelper.PoisonAttach.id)) {
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
	    	}
    	}
	}
	
	@SubscribeEvent
	public void AttackWithWither(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.getPoint(player, RewriteHelper.WitherAttach.id)) {
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, 100));
	    	}
    	}
	}
	
	@SubscribeEvent
	public void AttackWithLifeDrawing(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (RewriteHelper.getPoint(player, RewriteHelper.LifeSuck.id)) {
				player.setHealth(player.getHealth() + 2);
	    	}
    	}
	}
	
}
