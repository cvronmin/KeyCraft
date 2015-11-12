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
package com.KanbeKotori.KeyCraft.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.World;

import com.KanbeKotori.KeyCraft.Helper.MaterialHelper;

public class ItemAuroraIronPickaxe extends ItemPickaxe {
	
	public ItemAuroraIronPickaxe() {
		super(MaterialHelper.AuroraIron);
	}

	/** 物品损坏+2，如果被破坏则给对应铁工具 */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (stack.getItemDamage() >= this.getMaxDamage() - 1) {
			if (attacker instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)attacker;
				player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_pickaxe, 1, 0));
				return true;
			}		
		}
		stack.damageItem(2, attacker);
		return true;
	}

	/** 物品损坏+1，如果被破坏则给对应铁工具 */
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, int posX, int posY ,int posZ, EntityLivingBase entity) {
		if (stack.getItemDamage() >= this.getMaxDamage()) {
			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entity;
				player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_pickaxe, 1, 0));
				return true;
			}	
		}
		stack.damageItem(1, entity);
		return true;
	}

}
