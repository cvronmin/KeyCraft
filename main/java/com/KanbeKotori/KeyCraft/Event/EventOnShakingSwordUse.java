package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.*;

@Cancelable
public class EventOnShakingSwordUse extends Event {
	
	public final EntityPlayer entityPlayer;
	
	public EventOnShakingSwordUse(EntityPlayer entity) {
		super();
		entityPlayer = entity;
	}

}
