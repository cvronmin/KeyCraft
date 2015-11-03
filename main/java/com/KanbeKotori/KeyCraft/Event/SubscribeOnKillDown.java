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
		if (!(event.source.getEntity() instanceof EntityPlayer)) {
			return;
		}
		EntityPlayer player = (EntityPlayer)event.source.getEntity();
		if (!player.worldObj.isRemote) {
			return;
		}
		
		if (RewriteHelper.getPoint(player, RewriteHelper.AuroraRob.id)) {
			if (new Random().nextInt(16) == 8) {
				RewriteHelper.addAuroraPoint(player, 1);
			}
		}
	}

}
