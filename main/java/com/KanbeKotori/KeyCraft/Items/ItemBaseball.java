package com.KanbeKotori.KeyCraft.Items;

import com.KanbeKotori.KeyCraft.Entities.EntityBaseball;
import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBaseball extends Item {
	
	MainHelper mainhelper = new MainHelper();
	RewriteHelper rwhelper = new RewriteHelper();
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
    	/*if (No skill) {
    		return stack;
    	}*/
		
        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
        	if (rwhelper.getPoint(player, 232)) {
        		world.spawnEntityInWorld(new EntityBaseball(world, player, 10.0F));
        	} else {
        		world.spawnEntityInWorld(new EntityBaseball(world, player));
        	}
        }

        return stack;
    }

}
