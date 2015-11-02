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
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
		p_77624_3_.add(StatCollector.translateToLocal("keycraft.item.intro_baseball_1"));
		p_77624_3_.add(StatCollector.translateToLocal("keycraft.item.intro_baseball_2"));
		p_77624_3_.add(StatCollector.translateToLocal("keycraft.item.intro_baseball_3"));
	}

}
