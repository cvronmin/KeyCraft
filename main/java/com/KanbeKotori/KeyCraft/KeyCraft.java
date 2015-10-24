package com.KanbeKotori.KeyCraft;

import com.KanbeKotori.KeyCraft.Event.*;
import com.KanbeKotori.KeyCraft.Items.*;
import com.KanbeKotori.KeyCraft.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.*;

@Mod(modid = KeyCraft.MODID, version = KeyCraft.VERSION)
public class KeyCraft {
	
	public static final String MODID = "keycraft";
    public static final String VERSION = "Demo-2.3.1";
    
    public static CreativeTabs CreativeTab = new CreativeTab("KeyCraft");
    
    public static Item PointShakingSword;
    public static Item PointAuroraTrident;
    public static Item PointAuroraBlade;
    
    @SidedProxy(clientSide = "com.KanbeKotori.KeyCraft.ClientProxy",
            	serverSide = "com.KanbeKotori.KeyCraft.CommonProxy")
    public static CommonProxy proxy;
 
    @Instance("KeyCraft")
    public static KeyCraft instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    	
    	PointShakingSword = new PointShakingSword();
    	PointShakingSword.setUnlocalizedName("PointShakingSword").setTextureName("keycraft:PointShakingSword").setCreativeTab(null);
    	GameRegistry.registerItem(PointShakingSword, "PointShakingSword");
    	
    	PointAuroraTrident = new PointAuroraTrident();
    	PointAuroraTrident.setUnlocalizedName("PointAuroraTrident").setTextureName("keycraft:PointAuroraTrident").setCreativeTab(null);
    	GameRegistry.registerItem(PointAuroraTrident, "PointAuroraTrident");
    	
    	PointAuroraBlade = new PointAuroraBlade();
		PointAuroraBlade.setUnlocalizedName("PointAuroraBlade").setTextureName("keycraft:PointAuroraBlade").setCreativeTab(null);
    	GameRegistry.registerItem(PointAuroraBlade, "PointAuroraBlade");
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event) {
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
