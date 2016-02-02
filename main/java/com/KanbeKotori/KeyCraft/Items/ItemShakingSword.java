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

import java.util.List;

import com.kanbekotori.keycraft.event.*;
import com.kanbekotori.keycraft.helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class ItemShakingSword extends ItemSword {
	
	public ItemShakingSword() {
		super(MaterialHelper.ShakingSword);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, int posX, int posY ,int posZ, EntityLivingBase entity) {
		stack.damageItem(0, entity);
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro231_1"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro231_2"));
	}
	
	/** �����ʹ��Skill231-�����񶯡���������������� */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		EntityPlayer player = (EntityPlayer)attacker;
		if (!player.worldObj.isRemote) {
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
		}
		player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword, 1, stack.getItemDamage()));
		return true;
	}
	
	/** �л���ǰ��Ʒ��������������� */
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int index, boolean isCurrentItem) {
		if (entity instanceof EntityPlayer && !isCurrentItem) {
			EntityPlayer player = (EntityPlayer)entity;
			if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
			}
			player.inventory.mainInventory[index] = new ItemStack(Items.iron_sword, 1, stack.getItemDamage());
		}
	}
	
	/** ������������������� */
	@SubscribeEvent
	public void onDropped(ItemTossEvent event) {
		if (event.entityItem.getEntityItem().getItem() instanceof ItemShakingSword) {
			EntityPlayer player = event.player;
			if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
			}
			ItemStack stack = new ItemStack(Items.iron_sword, 1, event.entityItem.getEntityItem().getItemDamage());
			if (player.inventory.addItemStackToInventory(stack)) {
				event.setCanceled(true);
			} else {
				event.entityItem.setEntityItemStack(stack);
			}
		}
    }

}
