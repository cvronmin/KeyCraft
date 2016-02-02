/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori & xfgryujk.
 * ����Ʒ�� Kanbe-Kotori & xfgryujk ����������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.common.MinecraftForge;

import com.kanbekotori.keycraft.entities.*;
import com.kanbekotori.keycraft.event.*;
import com.kanbekotori.keycraft.items.ModItems;
import com.kanbekotori.keycraft.renderer.*;

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
		
		// ע�ᰴ���¼�
		FMLCommonHandler.instance().bus().register(new SubscribeKeyListener());
		ClientRegistry.registerKeyBinding(SubscribeKeyListener.key_Rewrite);
		ClientRegistry.registerKeyBinding(SubscribeKeyListener.key_Interact);
		
		// ע����Ⱦ��
		RenderingRegistry.registerEntityRenderingHandler(EntityBaseball.class, new RenderSnowball(ModItems.Baseball));
		RenderingRegistry.registerEntityRenderingHandler(EntityDictionary.class, new RenderSnowball(ModItems.Dictionary));
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		RenderingRegistry.registerEntityRenderingHandler(EntityJavelin.class, new RenderJavelin());
		RenderingRegistry.registerEntityRenderingHandler(EntityKagariCannon.class, new RenderKagariCannon());
		RenderingRegistry.registerBlockHandler(new BlockTrapRenderer());
	}
	 
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

}
