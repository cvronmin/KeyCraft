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

import com.kanbekotori.keycraft.helper.MaterialHelper;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemAuroraIronHoe extends ItemHoe {

	public ItemAuroraIronHoe() {
		super(MaterialHelper.AuroraIron);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int posX, int posY, int posZ, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if (!player.canPlayerEdit(posX, posY, posZ, p_77648_7_, stack)) {
			return false;
		} else {
			UseHoeEvent event = new UseHoeEvent(player, stack, world, posX, posY, posZ);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}
			if (event.getResult() == Result.ALLOW) {
				if (stack.getItemDamage() >= this.getMaxDamage()) {
					player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_hoe, 1, 0));
					return true;
				}
				stack.damageItem(1, player);
				return true;
			}
			Block block = world.getBlock(posX, posY, posZ);
			if (p_77648_7_ != 0 && world.getBlock(posX, posY + 1, posZ).isAir(world, posX, posY + 1, posZ) && (block == Blocks.grass || block == Blocks.dirt)) {
				Block block1 = Blocks.farmland;
				world.playSoundEffect((double)((float)posX + 0.5F), (double)((float)posZ + 0.5F), (double)((float)posZ + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);
				if (world.isRemote) {
					return true;
				} else {
					world.setBlock(posX, posY, posZ, block1);
					if (stack.getItemDamage() >= this.getMaxDamage()) {
						player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_hoe, 1, 0));
						return true;
					}
					stack.damageItem(1, player);
					return true;
				}
			} else {
				return false;
			}
		}
	}

}
