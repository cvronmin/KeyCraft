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
package com.kanbekotori.keycraft.items;

import com.kanbekotori.keycraft.KeyCraft;
import com.kanbekotori.keycraft.helper.MaterialHelper;

import net.minecraft.entity.Entity;
import net.minecraft.item.*;

public class Armors_AuroraIron extends ItemArmor {
	
	int pos;

	/** position代表护甲位置，0为头盔，1为胸甲，2为护腿，3为靴子。 */
	public Armors_AuroraIron(int position) {
		super(MaterialHelper.AuroraIronArmor, 0, position);
		this.pos = position;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (pos == 2)	return KeyCraft.MODID + ":textures/models/armor/AuroraIron_layer_2.png";	
		return KeyCraft.MODID + ":textures/models/armor/AuroraIron_layer_1.png";	
	}
}
