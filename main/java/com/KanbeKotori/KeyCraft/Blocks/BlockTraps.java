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
package com.kanbekotori.keycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import com.kanbekotori.keycraft.helper.RewriteHelper;
import com.kanbekotori.keycraft.renderer.BlockTrapRenderer;

import cpw.mods.fml.relauncher.*;

public abstract class BlockTraps extends Block implements ITileEntityProvider {

	protected BlockTraps(EntityLivingBase layer) {
		super(Material.rock);
	}
	
	// ���߼� //////////////////////////////////////////////////////////////////
    
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityTrap();
    }
	
	/** �����鱻����ʱ���ô˷����� */
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
	
	/** ��ʵ���߹�����ʱ���ô˷����� */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {}
	
	/** �����鱻�һ�ʱ���ô˷����� */
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
			// �ͻ����ڽ��յ�ͬ��������·���
			if (!world.isRemote) {
				world.markBlockForUpdate(x, y, z);
			}
			tile.markDirty();
		}
    	return updated;
    }
	
	/** �����ƻ���� */
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return null;
    }

	// ��ײ�� //////////////////////////////////////////////////////////////////
	
	/** ���÷������ */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(x, y, z);
		Block fakeBlock = tile.getFakeBlock();
		if (fakeBlock == this) {
			super.setBlockBoundsBasedOnState(world, x, y, z);
		} else {
			fakeBlock.setBlockBoundsBasedOnState(world, x, y, z);
		}
	}
	
	/** ���÷�����ײ�� */
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity) {
		TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(x, y, z);
		Block fakeBlock = tile.getFakeBlock();
		if (fakeBlock == this) {
			super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
		} else {
			fakeBlock.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
		}
    }
	
	/** ȡ������ײ�� */
	@Override
	 public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(x, y, z);
		if (tile == null) {
			return super.getCollisionBoundingBoxFromPool(world, x, y, z);
		}
		Block fakeBlock = tile.getFakeBlock();
		if (fakeBlock == this) {
			return super.getCollisionBoundingBoxFromPool(world, x, y, z);
		} else {
			return fakeBlock.getCollisionBoundingBoxFromPool(world, x, y, z);
		}
	 }
	
	/** ȡѡ����ײ�� */
	@SideOnly(Side.CLIENT)
	@Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
		TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(x, y, z);
		Block fakeBlock = tile.getFakeBlock();
		if (fakeBlock == this) {
			return super.getSelectedBoundingBoxFromPool(world, x, y, z);
		} else {
			return fakeBlock.getSelectedBoundingBoxFromPool(world, x, y, z);
		}
    }
	
	// ��Ⱦ //////////////////////////////////////////////////////////////////

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

}
