package com.kanbekotori.keycraft.items;

import java.util.Iterator;
import java.util.List;

import com.kanbekotori.keycraft.helper.RewriteHelper;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemViolin extends Item {
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!RewriteHelper.hasSkill(player, RewriteHelper.BruteForce.id)) {
			return stack;
		}
		
		List entities = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX-8.0D, player.posY-2.0D, player.posZ-8.0D, player.posX+8.0D, player.posY+2.0D, player.posZ+8.0D));
		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
			EntityLiving entity = (EntityLiving)iterator.next();
			if(!entity.equals(player)) {
				entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 2.0F);
			}
		}
		return stack;
	}

}
