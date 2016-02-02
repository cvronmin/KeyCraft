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

import java.util.Iterator;
import java.util.List;

import com.kanbekotori.keycraft.helper.RewriteHelper;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTrapBlood extends BlockTraps {

	protected BlockTrapBlood(EntityLivingBase layer) {
		super(layer);
	}
	
	/** �����鱻����ʱ���ô˷����� */
	@Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack) {
		super.onBlockPlacedBy(world, posX, posY, posZ, entity, stack);
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			if (!RewriteHelper.hasSkill(player, RewriteHelper.BloodTrap.id)) {
				world.setBlockToAir(posX, posY, posZ);
				stack.stackSize++;
				if (world.isRemote)	{
					player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.notrapskill")));
				}
			}
		}
	}
	
	/** ��ʵ���߹�����ʱ���ô˷����� */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {
        super.onEntityWalking(world, posX, posY, posZ, entity);
        TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(posX, posY, posZ);
        if (entity instanceof EntityPlayer && ((EntityPlayer)entity).getDisplayName().equals(tile.ownerName)) {
        	if (!world.isRemote) {
        		((EntityPlayer)entity).addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.yourtrap")));
        	}
        } else {
			entity.attackEntityFrom(DamageSource.magic, 40.0F);
        	world.removeTileEntity(posX, posY, posZ);
        	world.setBlockToAir(posX, posY, posZ);
        }
    }
	
	/** �����鱻ը��ʱ ֱ������˺��� */
    public void onBlockDestroyedByExplosion(World world, int posX, int posY, int posZ, Explosion exp) {
        if (!world.isRemote) {
            TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(posX, posY, posZ);
        	List entities = world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(posX - 8.0D, posY - 8.0D, posZ - 8.0D, posX + 8.0D, posY + 8.0D, posZ + 8.0D));
    		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
    			EntityLivingBase entity = (EntityLivingBase)iterator.next();
    			entity.attackEntityFrom(DamageSource.magic, 40.0F);
    		}
        	world.removeTileEntity(posX, posY, posZ);
        }
    }

}
