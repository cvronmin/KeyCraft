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

import com.kanbekotori.keycraft.helper.RewriteHelper;

import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class ItemDictionaryOfNether extends Item {
	
	@Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!RewriteHelper.hasSkill(player, RewriteHelper.OtherWorldPerception.id))
			return stack;
		if (player.worldObj.provider.isSurfaceWorld())
			player.travelToDimension(-1);
			player.timeUntilPortal = 300;
        return stack;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
    }
}