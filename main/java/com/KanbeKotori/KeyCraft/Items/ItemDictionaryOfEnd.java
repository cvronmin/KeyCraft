package com.KanbeKotori.KeyCraft.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.*;

public class ItemDictionaryOfEnd extends Item {
	
	@Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.worldObj.provider.isHellWorld || player.worldObj.provider.isSurfaceWorld())
			player.travelToDimension(1);
			player.timeUntilPortal = 300;
        return stack;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
    }
}