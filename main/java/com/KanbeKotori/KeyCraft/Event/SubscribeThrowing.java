package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Renderer.EntityFXJavelin;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeThrowing {
	
	@SubscribeEvent
    public void Point_AuroraRob(EventThrowing event) {
		EntityPlayer player = event.entityPlayer;
		EntityThrowable entitythrowing = event.throwing;
	    for(int i = 0; i < 10; i++)
	    {
	        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFXJavelin(entitythrowing.worldObj, entitythrowing.posX, entitythrowing.posY,entitythrowing.posZ,
	        		Vec3.createVectorHelper(entitythrowing.motionX,
	        				entitythrowing.motionY, 
	        				entitythrowing.motionZ).normalize()));
	    }
	}

}
