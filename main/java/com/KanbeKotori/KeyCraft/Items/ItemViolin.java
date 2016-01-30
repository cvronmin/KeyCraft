package com.kanbekotori.keycraft.items;

import java.util.Iterator;
import java.util.List;

import com.kanbekotori.keycraft.event.*;
import com.kanbekotori.keycraft.helper.RewriteHelper;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ItemViolin extends Item {
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!RewriteHelper.hasSkill(player, RewriteHelper.ViolinAttack.id)) {
			return stack;
		}
		
		List entities = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX-8.0D, player.posY-2.0D, player.posZ-8.0D, player.posX+8.0D, player.posY+2.0D, player.posZ+8.0D));
		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
			EntityLiving entity = (EntityLiving)iterator.next();
			if(!entity.equals(player)) {
				if (entity.getEquipmentInSlot(1) == null)
					entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 2.0F);
				else
					entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 0.5F);
			}
		}
		
		EventUseViolin event = new EventUseViolin(player);
		MinecraftForge.EVENT_BUS.post(event);
		
		return stack;
	}

}
