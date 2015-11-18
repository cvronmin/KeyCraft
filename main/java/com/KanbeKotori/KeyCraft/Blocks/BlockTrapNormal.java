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

import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

public class BlockTrapNormal extends BlockTraps {

	protected BlockTrapNormal(EntityLivingBase layer) {
		super(layer);
	}
	
	/** 当方块被放置时调用此方法。 */
	@Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			if (!RewriteHelper.hasSkill(player, RewriteHelper.TrapProficient.id)) {
				world.setBlockToAir(posX, posY, posZ);
				stack.stackSize++;
				if (!world.isRemote) {
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
        	world.setBlockToAir(posX, posY, posZ);
        }
    }

}
