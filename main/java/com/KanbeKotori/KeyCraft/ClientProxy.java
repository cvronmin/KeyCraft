package com.KanbeKotori.KeyCraft;

import net.minecraftforge.common.MinecraftForge;

import com.KanbeKotori.KeyCraft.Event.*;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.*;

public class ClientProxy extends CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	 
	public void init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new SubscribeKeyListener());
		ClientRegistry.registerKeyBinding(SubscribeKeyListener.key_Rewrite);
		ClientRegistry.registerKeyBinding(SubscribeKeyListener.key_Interact);
	}
	 
	public void postInit(FMLPostInitializationEvent event) {

	}

}
