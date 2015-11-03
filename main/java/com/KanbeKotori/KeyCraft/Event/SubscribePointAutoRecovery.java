package com.KanbeKotori.KeyCraft.Event;

import java.util.Random;

import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribePointAutoRecovery {
	
	@SubscribeEvent
	public void Point_AuroraAutoRecover(PlayerTickEvent event) {
		
		EntityPlayer player = MainHelper.getPlayerSv(MainHelper.getName());
		
		if (RewriteHelper.getPoint(player, RewriteHelper.AuroraRegeneration.id)) {
			Random random = new Random();
			int ran = random.nextInt(4800);
			if (ran == 2400) {
				RewriteHelper.addAuroraPoint(player, 1);
			}
		}
		
	}

}
