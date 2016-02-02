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

import com.kanbekotori.keycraft.*;
import com.kanbekotori.keycraft.blocks.*;
import com.kanbekotori.keycraft.entities.*;
import com.kanbekotori.keycraft.event.*;
import com.kanbekotori.keycraft.items.*;

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
    public static final String VERSION = "Pre-1.0";
    
    @SidedProxy(clientSide = "com.kanbekotori.keycraft.ClientProxy",
            	serverSide = "com.kanbekotori.keycraft.CommonProxy")
    public static CommonProxy proxy;
 
    @Instance("KeyCraft")
    public static KeyCraft instance;
    
    public static CreativeTabs CreativeTab = new CreativeTab("KeyCraft");
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    	
    	// ע����Ʒ
    	ModItems.InitItems();
    	
    	// ע�᷽��
    	ModBlocks.InitBlocks();
    	
    	// ע��ʵ��
    	int modID = 1;
    	EntityRegistry.registerModEntity(EntityBaseball.class, "EntityBaseball", modID++, this, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityJavelin.class, "EntityJavelin", modID++, this, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityDictionary.class, "EntityDictionary", modID++, this, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityBullet.class, "EntityBullet", modID++, this, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityKagariCannon.class, "EntityKagariCannon", modID++, this, 128, 1, true);
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event) {
    	proxy.init(event);
    	
    	// ע���¼�
    	MinecraftForge.EVENT_BUS.register(new SubscribeCheating());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnAttack());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnKillDown());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnDead());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnHurt());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnHUDDraw());
    	MinecraftForge.EVENT_BUS.register(new ItemAuroraBlade());
    	MinecraftForge.EVENT_BUS.register(new ItemAuroraTrident());
    	MinecraftForge.EVENT_BUS.register(new ItemShakingSword());
    	MinecraftForge.EVENT_BUS.register(new SubscribeThrowing());
    	MinecraftForge.EVENT_BUS.register(new SubscribeUseViolin());

    	FMLCommonHandler.instance().bus().register(new SubscribeOnTick_Buff());
    	FMLCommonHandler.instance().bus().register(new SubscribeOnTick_Effect());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }

}
