package com.KanbeKotori.KeyCraft.Items;

import java.util.List;

import com.KanbeKotori.KeyCraft.Entities.EntityBaseball;
import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.*;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemBaseball extends Item {
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!RewriteHelper.hasSkill(player, RewriteHelper.MissileProficient.id)) {
			return stack;
		}
		
        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
        	world.spawnEntityInWorld(new EntityBaseball(world, player));
        }

        return stack;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro_baseball_1"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro_baseball_2"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro_baseball_3"));
	}

}
