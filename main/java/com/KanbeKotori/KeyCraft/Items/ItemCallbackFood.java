/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * 本作品版权由Nulla开发组所有。
 * Developed by Kanbe-Kotori & xfgryujk.
 * 本作品由 Kanbe-Kotori & xfgryujk 合作开发。
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package com.KanbeKotori.KeyCraft.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
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
