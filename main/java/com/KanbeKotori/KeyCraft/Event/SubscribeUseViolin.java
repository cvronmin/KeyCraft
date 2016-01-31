package com.kanbekotori.keycraft.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

import com.kanbekotori.keycraft.entities.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeUseViolin {
	
	@SubscribeEvent
    public void onUsingViolin(EventUseViolin event) {
		EntityPlayer player = event.entityPlayer;
	    for(int i = 0; i < 16; i++) {
	        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFXViolin(player.worldObj, player.posX, player.posY-player.getEyeHeight(),player.posZ));
	    }
	}

}
