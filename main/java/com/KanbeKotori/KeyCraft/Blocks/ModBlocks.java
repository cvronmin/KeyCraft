package com.KanbeKotori.KeyCraft.Blocks;

import com.KanbeKotori.KeyCraft.KeyCraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
	
    public static Block BloodTrap;

    public static void InitBlocks() {
    	BloodTrap = new BlockBloodTrap(null)
    		.setBlockName("BloodTrap")
    		.setBlockTextureName("keycraft:BloodTrap")
    		.setHardness(1.5F)
    		.setResistance(10.0F)
    		.setLightLevel(1)
    		.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerBlock(BloodTrap, "BloodTrap");
    		
    }
}
