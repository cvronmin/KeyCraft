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

import java.util.List;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import com.KanbeKotori.KeyCraft.Helper.MaterialHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class ItemAuroraTrident extends ItemSword {

	public ItemAuroraTrident() {
		super(MaterialHelper.Aurora1);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro311_1"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro311_2"));
	}
	
	/** 物品损坏+1，如果被破坏则给debuff */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (stack.getItemDamage() >= this.getMaxDamage()) {
			EntityPlayer player = (EntityPlayer)attacker;
			RewriteHelper.breakAurora(player);
			if(!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.breakblade")));
		    }	
		}
		
		stack.damageItem(1, attacker);
		return true;
	}

	 /** 物品损坏+1，如果被破坏则给debuff */
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, int posX, int posY ,int posZ, EntityLivingBase entity) {
		if (stack.getItemDamage() >= this.getMaxDamage()) {
			EntityPlayer player = (EntityPlayer)entity;
			RewriteHelper.breakAurora(player);
			if(!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.breakblade")));
		    }	
		}
		
		stack.damageItem(1, entity);
		return true;
	}
	
	/** 切换当前物品后回收欧若拉 */
	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int index, boolean isCurrentItem) {
		if (player instanceof EntityPlayer && !isCurrentItem) {
			((EntityPlayer)player).inventory.mainInventory[index] = null;
			recycle(stack, (EntityPlayer)player);
		}
	}
	
	/** 丢弃后回收欧若拉 */
	@SubscribeEvent
	public void onDropped(ItemTossEvent event) {
		if (event.entityItem.getEntityItem().getItem() instanceof ItemAuroraTrident) {
			event.setCanceled(true);
			recycle(event.entityItem.getEntityItem(), event.player);
		}
    }
	
	public void recycle(ItemStack stack, EntityPlayer player) {
		if (!player.worldObj.isRemote) {
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.recycletrident")));
		}
		RewriteHelper.recycleAurora(player, (double)stack.getItemDamage() / (double)stack.getMaxDamage());
	}

}
