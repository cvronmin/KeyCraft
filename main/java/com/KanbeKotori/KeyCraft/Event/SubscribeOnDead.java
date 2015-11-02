package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnDead {

	@SubscribeEvent
    public void OnDeadClone(PlayerEvent.Clone event) {
		EntityPlayer _old = event.original;
		EntityPlayer _new = event.entityPlayer;
		RewriteHelper.CLONE(_old, _new);
	}

}
