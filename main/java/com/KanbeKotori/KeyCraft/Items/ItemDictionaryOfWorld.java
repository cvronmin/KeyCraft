package com.KanbeKotori.KeyCraft.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.*;

public class ItemDictionaryOfWorld extends Item {
	
	@Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.worldObj.provider.isHellWorld)
			player.travelToDimension(0);
			player.timeUntilPortal = 300;
        return stack;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
    }
}