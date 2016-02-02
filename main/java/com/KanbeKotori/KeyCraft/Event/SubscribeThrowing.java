/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori & xfgryujk.
 * ����Ʒ�� Kanbe-Kotori & xfgryujk ����������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.event;

import com.kanbekotori.keycraft.entities.EntityFXJavelin;
import com.kanbekotori.keycraft.entities.EntityThrowableWithoutGravity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeThrowing {
	
	@SubscribeEvent
    public void onThrowing(EventThrowing event) {
		EntityPlayer player = event.entityPlayer;
		EntityThrowableWithoutGravity entitythrowing = event.throwing;
	    for(int i = 0; i < 8; i++) {
	        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFXJavelin(entitythrowing.worldObj, entitythrowing.posX, entitythrowing.posY,entitythrowing.posZ,
	        		Vec3.createVectorHelper(entitythrowing.motionX,
	        				entitythrowing.motionY, 
	        				entitythrowing.motionZ).normalize()));
	    }
	}

}
