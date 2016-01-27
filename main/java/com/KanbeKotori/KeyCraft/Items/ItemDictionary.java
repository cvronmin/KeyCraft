package com.KanbeKotori.KeyCraft.Items;

import com.KanbeKotori.KeyCraft.Entities.*;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemDictionary extends Item {
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!RewriteHelper.hasSkill(player, RewriteHelper.DeadlyDictionary.id)) {
			return stack;
		}
		
        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
        	world.spawnEntityInWorld(new EntityDictionary(world, player));
        }

        return stack;
    }

}
