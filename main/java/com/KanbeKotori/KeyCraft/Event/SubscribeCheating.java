package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.ServerChatEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeCheating {
	
	private MainHelper mainhelper = new MainHelper();
	private RewriteHelper rwhelper = new RewriteHelper();
	
	@SubscribeEvent
    public void GodsBless(ServerChatEvent event) {
        if(event.message.equals("Kotori")) {
        	event.setCanceled(true);
            EntityPlayer player = event.player;
            rwhelper.addAuroraPoint(player, 100);
    		player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.cheat1")));
        }
    }

}
