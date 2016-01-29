/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * 本作品版权由Nulla开发组所有。
 * Developed by Kanbe-Kotori & xfgryujk.
 * 本作品由 Kanbe-Kotori & xfgryujk 合作开发。
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.event;

import com.kanbekotori.keycraft.entities.EntityThrowableWithoutGravity;
import com.kanbekotori.keycraft.renderer.EntityFXJavelin;

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
		EntityThrowableWithoutGravity entitythrowing = event.throwing;
	    for(int i = 0; i < 10; i++)
	    {
	        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFXJavelin(entitythrowing.worldObj, entitythrowing.posX, entitythrowing.posY,entitythrowing.posZ,
	        		Vec3.createVectorHelper(entitythrowing.motionX,
	        				entitythrowing.motionY, 
	        				entitythrowing.motionZ).normalize()));
	    }
	}

}
