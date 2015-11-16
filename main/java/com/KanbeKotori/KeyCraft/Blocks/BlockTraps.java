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
package com.KanbeKotori.KeyCraft.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import cpw.mods.fml.relauncher.*;

public abstract class BlockTraps extends Block {
	
	protected EntityLivingBase owner;
	protected IIcon icon;

	protected BlockTraps(EntityLivingBase layer) {
		super(Material.rock);
		this.owner = layer;
	}
	
	/** 当方块被放置时调用此方法。 */
	@Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack) {}
	
	/** 当实体走过方块时调用此方法。 */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {}
	
	/** 当方块被右击时调用此方法。 */
    public boolean onBlockActivated(World world, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
    	ItemStack held = player.getHeldItem();
		if (player.equals(this.owner) && held != null) {
			Block block = Block.getBlockFromItem(held.getItem());
			if (block != null) {
				int metadata = held.getItem().getMetadata(held.getItemDamage());
				this.icon = block.getIcon(1, metadata);
			}
		}
    	return false;
    }
    
    /** 获取方块材质。 */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
    	if (this.icon != null) {
    		return this.icon;
    	}
        return this.blockIcon;
    }

}
