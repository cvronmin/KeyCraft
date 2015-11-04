package com.KanbeKotori.KeyCraft.Helper;

import java.util.ArrayList;
import java.util.ListIterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;

public class MainHelper {
	
	/**
	 *只能在客户端用
	 */
	public static EntityPlayer getPlayerCl() {
		return Minecraft.getMinecraft().thePlayer;
	}

}
