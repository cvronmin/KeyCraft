/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori & xfgryujk.
 * ����Ʒ�� Kanbe-Kotori & xfgryujk ����������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.items;

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
