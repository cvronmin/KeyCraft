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
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote) {
			return;
		}
		
		if (RewriteHelper.getPoint(player, RewriteHelper.AuroraRegeneration.id)) {
			if (new Random().nextInt(4800) == 2400) {
				RewriteHelper.addAuroraPoint(player, 1);
			}
		}
	}

}
