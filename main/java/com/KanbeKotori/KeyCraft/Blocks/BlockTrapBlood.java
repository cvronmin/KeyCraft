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
	
	/** 当方块被放置时调用此方法。 */
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
	
	/** 当实体走过方块时调用此方法。 */
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
	
	/** 当方块被炸烂时 直接造成伤害。 */
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
