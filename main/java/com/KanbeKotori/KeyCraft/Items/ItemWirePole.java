package com.kanbekotori.keycraft.items;

import java.util.*;

import com.kanbekotori.keycraft.helper.*;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemWirePole extends ItemSword {

	public ItemWirePole() {
		super(MaterialHelper.WirePole);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!RewriteHelper.hasSkill(player, RewriteHelper.BruteForce.id)) {
			return stack;
		}
		
		List entities = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX-3.0D, player.posY-2.0D, player.posZ-3.0D, player.posX+3.0D, player.posY+2.0D, player.posZ+3.0D));
		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
			EntityLiving entity = (EntityLiving)iterator.next();
			if(!entity.equals(player)) {
				entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10.0F);
			}
		}
		stack.damageItem(32, player);
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro_WirePole_1"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro_WirePole_2"));
	}

}
