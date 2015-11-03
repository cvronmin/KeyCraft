package com.KanbeKotori.KeyCraft.Event;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.*;

import com.KanbeKotori.KeyCraft.Helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnKillDown {
	
	@SubscribeEvent
    public void Point_AuroraRob(LivingDeathEvent event) {
		
		EntityPlayer player = MainHelper.getPlayerSv(MainHelper.getName());
		
		if (event.source.damageType.equals("player")) {
			if (RewriteHelper.getPoint(player, RewriteHelper.AuroraRob.id)) {
				Random random = new Random();
				int ran = random.nextInt(16);
				if (ran == 8) {
					RewriteHelper.addAuroraPoint(player, 1);
				}
			}
		}
	}

}
