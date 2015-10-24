package com.KanbeKotori.KeyCraft.Helper;

import java.util.ArrayList;
import java.util.ListIterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;

public class MainHelper {
	
	public EntityPlayer getPlayerCl() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		return player;
	}
	
	public EntityPlayer getPlayerSv(String name) {

	    ServerConfigurationManager server = MinecraftServer.getServer().getConfigurationManager();
	    ArrayList pl = (ArrayList) server.playerEntityList;
	    ListIterator list = pl.listIterator();

	    while (list.hasNext()){
	        EntityPlayer p = (EntityPlayer) list.next();
	        if(p.getGameProfile().getName().equals(name)){
	            return p;
	        }
	    }
	    return null;

	}
	
	public String getName() {
		EntityPlayer player = this.getPlayerCl();
		return player.getDisplayName();
	}

}
