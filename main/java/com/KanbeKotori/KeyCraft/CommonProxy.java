package com.KanbeKotori.KeyCraft;

import com.KanbeKotori.KeyCraft.*;
import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Items.*;
import com.KanbeKotori.KeyCraft.Network.RewriteNetwork;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		
	}
	 
	public void init(FMLInitializationEvent event) {
		// ×¢²áÍøÂçÊÂ¼þ
		FMLCommonHandler.instance().bus().register(new RewriteNetwork.SubscribePlayerLoggedIn());
		RewriteNetwork.rewriteChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(RewriteNetwork.REWRITE_CHANNEL);
		RewriteNetwork.rewriteChannel.register(new RewriteNetwork());
	}
	 
	public void postInit(FMLPostInitializationEvent event) {

	}
	
}
