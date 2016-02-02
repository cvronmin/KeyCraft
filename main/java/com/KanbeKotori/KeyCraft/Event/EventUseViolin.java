package com.kanbekotori.keycraft.event;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.eventhandler.Event;

public class EventUseViolin extends Event {
	
	public final EntityPlayer entityPlayer;
	
	public EventUseViolin(EntityPlayer entity) {
		super();
		entityPlayer = entity;
	}

}
