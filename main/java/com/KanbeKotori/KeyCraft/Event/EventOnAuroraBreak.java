package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

@Cancelable
public class EventOnAuroraBreak extends Event {
	
	public final EntityPlayer entityPlayer;
	
	public EventOnAuroraBreak(EntityPlayer entity) {
		super();
		entityPlayer = entity;
	}
}
