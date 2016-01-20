package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import cpw.mods.fml.common.eventhandler.Event;

public class EventThrowing extends Event {
	
public final EntityPlayer entityPlayer;
public final EntityThrowable throwing;
	
	public EventThrowing(EntityPlayer entity, EntityThrowable entitythrowing) {
		super();
		entityPlayer = entity;
		throwing = entitythrowing;
	}

}
