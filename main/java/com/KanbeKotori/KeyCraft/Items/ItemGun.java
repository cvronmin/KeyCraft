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
package com.kanbekotori.keycraft.items;

import com.kanbekotori.keycraft.entities.*;
import com.kanbekotori.keycraft.helper.RewriteHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemGun extends Item {
	
	@Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!RewriteHelper.hasSkill(player, RewriteHelper.Shooting.id)) {
			return stack;
		}

		if (player.inventory.hasItem(ModItems.MiracleRibbon) && RewriteHelper.hasSkill(player, RewriteHelper.Cream_KagariCannon.id)) {
			if (!player.capabilities.isCreativeMode)
				player.inventory.consumeInventoryItem(ModItems.MiracleRibbon);
			
	        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isRemote) {
		    	world.spawnEntityInWorld(new EntityKagariCannon(world, player));
		    }
			
	        return stack;
		}
		
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
        	world.spawnEntityInWorld(new EntityBullet(world, player));
        }

        return stack;
    }
}
