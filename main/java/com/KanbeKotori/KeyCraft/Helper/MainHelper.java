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
package com.kanbekotori.keycraft.helper;

import java.util.ArrayList;
import java.util.ListIterator;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;

public class MainHelper {
	
	/**
	 *ֻ���ڿͻ�����
	 */
	public static EntityPlayer getPlayerCl() {
		return Minecraft.getMinecraft().thePlayer;
	}
	
	public static void addEnchantedRecipe(Item item, Enchantment enchantment, int enchantmentLevel, Object[] ingredientArray) {
		ItemStack result = new ItemStack(item);
		if (enchantment != null) {
			result.addEnchantment(enchantment, enchantmentLevel);
	    }
	    GameRegistry.addRecipe(result, ingredientArray);
	}

}
