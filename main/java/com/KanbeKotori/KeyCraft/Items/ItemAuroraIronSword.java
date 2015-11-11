package com.KanbeKotori.KeyCraft.Items;

import com.KanbeKotori.KeyCraft.Helper.MaterialHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemAuroraIronSword extends ItemSword {

	public ItemAuroraIronSword() {
		super(MaterialHelper.AuroraIron);
	}

	/** 物品损坏+1，如果被破坏则给对应铁工具 */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (stack.getItemDamage() >= this.getMaxDamage()) {
			if (attacker instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)attacker;
				player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword, 1));
			}		
		}
		stack.damageItem(1, attacker);
		return true;
	}

	/** 物品损坏+1，如果被破坏则给对应铁工具 */
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, int posX, int posY ,int posZ, EntityLivingBase entity) {
		if (stack.getItemDamage() >= this.getMaxDamage()) {
			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entity;
				player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword, 1));
			}	
		}
		stack.damageItem(2, entity);
		return true;
	}
	
}
