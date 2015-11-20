/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * 本作品版权由Nulla开发组所有。
 * Developed by Kanbe-Kotori & xfgryujk.
 * 本作品由 Kanbe-Kotori & xfgryujk 合作开发。
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package com.KanbeKotori.KeyCraft;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.common.MinecraftForge;

import com.KanbeKotori.KeyCraft.Entities.EntityBaseball;
import com.KanbeKotori.KeyCraft.Event.*;
import com.KanbeKotori.KeyCraft.Items.ModItems;
import com.KanbeKotori.KeyCraft.Renderer.BlockTrapRenderer;

import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	 
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
		// 注册按键事件
		FMLCommonHandler.instance().bus().register(new SubscribeKeyListener());
		ClientRegistry.registerKeyBinding(SubscribeKeyListener.key_Rewrite);
		ClientRegistry.registerKeyBinding(SubscribeKeyListener.key_Interact);
		
		// 注册渲染器
		RenderingRegistry.registerEntityRenderingHandler(EntityBaseball.class, new RenderSnowball(ModItems.Baseball));
		RenderingRegistry.registerBlockHandler(new BlockTrapRenderer());
	}
	 
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

}
