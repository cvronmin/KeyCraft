package com.KanbeKotori.KeyCraft.Event;

import java.util.Random;

import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribePointAutoRecovery {
	
	private MainHelper mainhelper = new MainHelper();
	private RewriteHelper rwhelper = new RewriteHelper();
	
	@SubscribeEvent
	public void Point_AutoRecover(PlayerTickEvent event) {
		
		EntityPlayer player = mainhelper.getPlayerSv(mainhelper.getName());
		
		if (rwhelper.getPoint(player, 343)) {
			Random random = new Random();
			int ran = random.nextInt(2400);
			if (ran == 1200) {
				rwhelper.addAuroraPoint(player, 1);
			}
		}
		
	}

}
