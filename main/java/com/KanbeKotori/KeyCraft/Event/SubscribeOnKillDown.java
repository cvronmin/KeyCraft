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

import java.util.Random;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

import com.kanbekotori.keycraft.helper.*;
import com.kanbekotori.keycraft.network.RewriteNetwork;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnKillDown {
	
	/** �������Skill243-��ŷ�����Ӷ᡻��ŷ�������� */
	@SubscribeEvent
    public void Point_AuroraRob(LivingDeathEvent event) {
		if ((event.source.getEntity() instanceof EntityPlayer)) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			if (!player.worldObj.isRemote // ����¼�ֻ�����ڷ�����
				&& RewriteHelper.hasSkill(player, RewriteHelper.AuroraRob.id)
				) {
				if (new Random().nextInt(32) == 16) {
					RewriteHelper.modifyAuroraPoint(player, 1);
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.aurorarob")));
				} else {
					//������
					//player.addChatMessage(new ChatComponentText("false"));
				}
			}
		}
	}

}
