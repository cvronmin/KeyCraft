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
package com.kanbekotori.keycraft.blocks;

import com.kanbekotori.keycraft.KeyCraft;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModBlocks {
	
	public static Block EnergyPoint;
	
    public static Block NormalTrap;
    public static Block LavaTrap;
    public static Block CactusTrap;
    public static Block TNTTrap;
    public static Block BlowUpTrap;
    public static Block BloodTrap;

    public static void InitBlocks() {
    	EnergyPoint = new BlockEnergyPoint()
    		.setBlockName("EnergyPoint")
    		.setBlockTextureName("keycraft:EnergyPoint")
    		.setHardness(1.5F)
			.setResistance(10.0F)
			.setLightLevel(1.0F)
			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerBlock(EnergyPoint, "EnergyPoint");
    	
    	NormalTrap = new BlockTrapNormal(null)
    		.setBlockName("NormalTrap")
    		.setBlockTextureName("keycraft:NormalTrap")
    		.setHardness(1.5F)
    		.setResistance(10.0F)
    		.setLightLevel(0.1F)
    		.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerBlock(NormalTrap, "NormalTrap");
    	GameRegistry.addRecipe(new ItemStack(NormalTrap), new Object[] { " A ", "BCB", " B ", 'A', Blocks.wooden_pressure_plate, 'B', Items.iron_ingot, 'C', Blocks.glass });
    	GameRegistry.addRecipe(new ItemStack(NormalTrap), new Object[] { " A ", "BCB", " B ", 'A', Blocks.stone_pressure_plate, 'B', Items.iron_ingot, 'C', Blocks.glass });

    	LavaTrap = new BlockTrapLava(null)
    		.setBlockName("LavaTrap")
    		.setBlockTextureName("keycraft:LavaTrap")
    		.setHardness(1.5F)
    		.setResistance(10.0F)
    		.setLightLevel(0.1F)
    		.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerBlock(LavaTrap, "LavaTrap");
    	GameRegistry.addShapelessRecipe(new ItemStack(LavaTrap), new Object[] { ModBlocks.NormalTrap, Items.lava_bucket });
    	
    	CactusTrap = new BlockTrapCactus(null)
				.setBlockName("CactusTrap")
				.setBlockTextureName("keycraft:CactusTrap")
				.setHardness(1.5F)
				.setResistance(10.0F)
				.setLightLevel(0.1F)
				.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerBlock(CactusTrap, "CactusTrap");
    	GameRegistry.addShapelessRecipe(new ItemStack(CactusTrap), new Object[] { ModBlocks.NormalTrap, Blocks.cactus });
	
    	TNTTrap = new BlockTrapTNT(null)
		.setBlockName("TNTTrap")
		.setBlockTextureName("keycraft:TNTTrap")
		.setHardness(1.5F)
		.setResistance(10.0F)
		.setLightLevel(0.1F)
		.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerBlock(TNTTrap, "TNTTrap");
    	GameRegistry.addShapelessRecipe(new ItemStack(TNTTrap), new Object[] { ModBlocks.NormalTrap, Blocks.tnt });
    	
    	BlowUpTrap = new BlockTrapBlowUp(null)
		.setBlockName("BlowUpTrap")
		.setBlockTextureName("keycraft:BlowUpTrap")
		.setHardness(1.5F)
		.setResistance(10.0F)
		.setLightLevel(0.1F)
		.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerBlock(BlowUpTrap, "BlowUpTrap");
    	GameRegistry.addShapelessRecipe(new ItemStack(BlowUpTrap), new Object[] { ModBlocks.NormalTrap, Blocks.piston, Items.gunpowder });

    	BloodTrap = new BlockTrapBlood(null)
    		.setBlockName("BloodTrap")
    		.setBlockTextureName("keycraft:BloodTrap")
    		.setHardness(1.5F)
    		.setResistance(10.0F)
    		.setLightLevel(0.1F)
    		.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerBlock(BloodTrap, "BloodTrap");
    		
    	// 注册TileEntity
    	
    	GameRegistry.registerTileEntity(TileEntityTrap.class, "TileEntityTrap");
    }
}
