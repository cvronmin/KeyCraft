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
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import com.KanbeKotori.KeyCraft.Renderer.BlockTrapRenderer;

import cpw.mods.fml.relauncher.*;

public abstract class BlockTraps extends Block implements ITileEntityProvider {

	protected BlockTraps(EntityLivingBase layer) {
		super(Material.rock);
	}
	
	/** 当方块被放置时调用此方法。 */
	@Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack)
	{
		TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(posX, posY, posZ);
		tile.fakeBlockID = getIdFromBlock(this);
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			tile.ownerName = player.getDisplayName();
		}
	}
	
	/** 当实体走过方块时调用此方法。 */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {}
	
	/** 当方块被右击时调用此方法。 */
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		boolean updated = false;
		
		TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(x, y, z);
		if (tile.ownerName.isEmpty()) {
			tile.ownerName = player.getDisplayName();
			updated = true;
		}
		
		ItemStack held = player.getHeldItem();
		if (player.getDisplayName().equals(tile.ownerName)
			&& held != null
			) {
			Block block = Block.getBlockFromItem(held.getItem());
			if (block != null) {
				tile.fakeBlockID = Block.getIdFromBlock(block);
				world.setBlockMetadataWithNotify(x, y, z, held.getItemDamage(), 2);
				updated = true;
			}
		}
		
		if (updated) {
			world.markBlockForUpdate(x, y, z);
			tile.markDirty();
		}
    	return updated;
    }
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
    
	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }

	@Override
	public int getRenderType() {
        return BlockTrapRenderer.RENDER_ID;
    }
    
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityTrap();
    }

}
