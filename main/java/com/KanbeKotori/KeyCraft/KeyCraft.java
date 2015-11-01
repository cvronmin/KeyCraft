package com.KanbeKotori.KeyCraft;

import com.KanbeKotori.KeyCraft.Event.*;
import com.KanbeKotori.KeyCraft.Items.*;
import com.KanbeKotori.KeyCraft.*;
import com.KanbeKotori.KeyCraft.Entities.EntityBaseball;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
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
    public static final String VERSION = "Demo-2.3.1";
    
    @SidedProxy(clientSide = "com.KanbeKotori.KeyCraft.ClientProxy",
            	serverSide = "com.KanbeKotori.KeyCraft.CommonProxy")
    public static CommonProxy proxy;
 
    @Instance("KeyCraft")
    public static KeyCraft instance;
    
    public static CreativeTabs CreativeTab = new CreativeTab("KeyCraft");
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    	
    	ModItems.InitItems();
    	
    	// 
    	// Init entities
    	//

    	int modID = 1;
    	EntityRegistry.registerModEntity(EntityBaseball.class, "EntityBaseball", modID++, this, 128, 1, true);
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event) {
    	//
    	// Init events
    	//
    	
    	MinecraftForge.EVENT_BUS.register(new SubscribeCheating());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnAttack());
    	MinecraftForge.EVENT_BUS.register(new SubscribePointAgainstFire());
    	MinecraftForge.EVENT_BUS.register(new SubscribePointAgainstMagic());
    	MinecraftForge.EVENT_BUS.register(new SubscribePointAutoBuff());
    	MinecraftForge.EVENT_BUS.register(new SubscribeOnDead());
    	MinecraftForge.EVENT_BUS.register(new SubscribeShakingSwordUsing());
    	MinecraftForge.EVENT_BUS.register(new PointAuroraBlade());
    	MinecraftForge.EVENT_BUS.register(new SubscribeAuroraRecycle());

    	FMLCommonHandler.instance().bus().register(new SubscribeShakingSwordUsing());
    	FMLCommonHandler.instance().bus().register(new SubscribePointAutoBuff());
    	FMLCommonHandler.instance().bus().register(new SubscribePointAutoRecovery());
    	FMLCommonHandler.instance().bus().register(new SubscribeAuroraRecycle());
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }

}
