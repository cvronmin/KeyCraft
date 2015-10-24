package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.*;

@Cancelable
public class EventOnAuroraRecycle extends Event {
	
	public final EntityPlayer entityPlayer;
	public final double proportion;
	
	public EventOnAuroraRecycle(EntityPlayer entity, double pp) {
		super();
		entityPlayer = entity;
		proportion = pp;
	}
}
