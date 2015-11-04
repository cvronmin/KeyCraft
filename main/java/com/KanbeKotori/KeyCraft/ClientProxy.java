package com.KanbeKotori.KeyCraft;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.common.MinecraftForge;

import com.KanbeKotori.KeyCraft.Entities.EntityBaseball;
import com.KanbeKotori.KeyCraft.Event.*;
import com.KanbeKotori.KeyCraft.Items.ModItems;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	 
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
		// ×¢²á°´¼üÊÂ¼þ
		FMLCommonHandler.instance().bus().register(new SubscribeKeyListener());
		ClientRegistry.registerKeyBinding(SubscribeKeyListener.key_Rewrite);
		ClientRegistry.registerKeyBinding(SubscribeKeyListener.key_Interact);
		
		// ×¢²áäÖÈ¾Æ÷
		RenderingRegistry.registerEntityRenderingHandler(EntityBaseball.class, new RenderSnowball(ModItems.Baseball));
	}
	 
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

}
