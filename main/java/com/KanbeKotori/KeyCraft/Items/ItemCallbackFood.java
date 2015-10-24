package com.KanbeKotori.KeyCraft.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCallbackFood extends ItemFood {
	public interface ICallback {
		void onFoodEaten(ItemStack stack, World world, EntityPlayer player);
	}
	
	protected ICallback Callback = null;

	public ItemCallbackFood(int healAmount) {
		super(healAmount, false);
	}
	
	public ItemCallbackFood setCallback(ICallback callback) {
		Callback = callback;
		return this;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
		if (Callback != null) {
			Callback.onFoodEaten(stack, world, player);
		}
    }
}
