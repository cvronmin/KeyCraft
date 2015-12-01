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

import com.KanbeKotori.KeyCraft.Blocks.*;
import com.KanbeKotori.KeyCraft.Event.*;
import com.KanbeKotori.KeyCraft.Items.*;
import com.KanbeKotori.KeyCraft.*;
import com.KanbeKotori.KeyCraft.Entities.*;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.*;

@Mod(modid = KeyCraft.MODID, name = KeyCraft.MODNAME, version = KeyCraft.VERSION)
public class KeyCraft {
	
	public static final String MODID = "keycraft";
	public static final String MODNAME = "KeyCraft";
    public static final String VERSION = "Demo-3.1.3-γ";
    
    @SidedProxy(clientSide = "com.KanbeKotori.KeyCraft.ClientProxy",
            	serverSide = "com.KanbeKotori.KeyCraft.CommonProxy")
    public static CommonProxy proxy;
 
    @Instance("KeyCraft")
    public static KeyCraft instance;
    
    public static CreativeTabs CreativeTab = new CreativeTab("KeyCraft");
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    	
    	// 注册物品
    	ModItems.InitItems();
    	
    	// 注册方块
    	ModBlocks.InitBlocks();
    	
    	// 注册实体
    	int modID = 1;
    	EntityRegistry.registerModEntity(EntityBaseball.class, "EntityBaseball", modID++, this, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityJavelin.class, "EntityJavelin", modID++, this, 128, 1, true);
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event) {
    	proxy.init(event);
    	
    	// 注册事件
    	MinecraftForge.EVENT_BUS.register(new SubscribeCheating());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnAttack());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnKillDown());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnDead());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnHurt());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnHUDDraw());
    	MinecraftForge.EVENT_BUS.register(new ItemAuroraBlade());
    	MinecraftForge.EVENT_BUS.register(new ItemAuroraTrident());
    	MinecraftForge.EVENT_BUS.register(new ItemShakingSword());

    	FMLCommonHandler.instance().bus().register(new SubscribeOnTick_Buff());
    	FMLCommonHandler.instance().bus().register(new SubscribeOnTick_Effect());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }

}
