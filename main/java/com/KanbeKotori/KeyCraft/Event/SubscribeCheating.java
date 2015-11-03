package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.ServerChatEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeCheating {
	
	@SubscribeEvent
    public void GodsBless(ServerChatEvent event) {
        if(event.message.equals("Kotori")) {
        	event.setCanceled(true);
            EntityPlayer player = event.player;
            RewriteHelper.addAuroraPoint(player, 100);
            if (!player.worldObj.isRemote) {
                player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.cheat1")));
            }
        }
    }

}
