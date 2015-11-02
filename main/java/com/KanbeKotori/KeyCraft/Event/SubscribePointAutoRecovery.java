package com.KanbeKotori.KeyCraft.Event;

import java.util.Random;

import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribePointAutoRecovery {
	
	@SubscribeEvent
	public void Point_AutoRecover(PlayerTickEvent event) {
		
		EntityPlayer player = MainHelper.getPlayerSv(MainHelper.getName());
		
		if (RewriteHelper.getPoint(player, 343)) {
			Random random = new Random();
			int ran = random.nextInt(2400);
			if (ran == 1200) {
				RewriteHelper.addAuroraPoint(player, 1);
			}
		}
		
	}

}
