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
package com.kanbekotori.keycraft.event;

import com.kanbekotori.keycraft.helper.RewriteHelper;
import com.kanbekotori.keycraft.helper.RewriteHelper.Skill;
import com.kanbekotori.keycraft.network.RewriteNetwork;

import net.minecraft.entity.player.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnDead {

	/**
	 * ���������ʱ������ҵ�����Skill�Լ�ŷ����������¡��Respawn�Ժ�������
	 * �ڴ�ĩ�ػص�������ʱҲ�����PlayerEvent.Clone��PlayerRespawnEvent�����������PlayerChangedDimensionEvent
	 */
	@SubscribeEvent
    public void OnDeadClone(PlayerEvent.Clone event) {
		final EntityPlayer _old = event.original;
		final EntityPlayer _new = event.entityPlayer;

		final NBTTagCompound newData = _new.getEntityData();
		// ���������ŷ�����������л�����������䣬������10
		final int newAuroraPoint = event.wasDeath ? Math.max(RewriteHelper.getAuroraPoint(_old) - 10, 0) : RewriteHelper.getAuroraPoint(_old);
		newData.setInteger("SkillPoint", newAuroraPoint);
		for (Skill i : RewriteHelper.SKILLS) {
			final String name = "Skill" + String.format("%03d", i.id);
			newData.setBoolean(name, RewriteHelper.hasSkill(_old, i.id));
		}
		
		// ������л������ͬ����@RewriteNetwork.SendSyncPacket.onPlayerRespawn
	}

}
