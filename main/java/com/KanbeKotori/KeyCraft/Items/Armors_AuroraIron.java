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

import com.kanbekotori.keycraft.KeyCraft;
import com.kanbekotori.keycraft.helper.MaterialHelper;

import net.minecraft.entity.Entity;
import net.minecraft.item.*;

public class Armors_AuroraIron extends ItemArmor {
	
	int pos;

	/** position������λ�ã�0Ϊͷ����1Ϊ�ؼף�2Ϊ���ȣ�3Ϊѥ�ӡ� */
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
