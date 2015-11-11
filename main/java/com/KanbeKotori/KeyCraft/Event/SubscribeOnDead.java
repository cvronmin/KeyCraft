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
package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper.Skill;
import com.KanbeKotori.KeyCraft.Network.RewriteNetwork;

import net.minecraft.entity.player.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnDead {

	/**
	 * 在玩家死亡时将旧玩家的所有Skill以及欧若拉点数克隆给Respawn以后的新玩家
	 * 在从末地回到主世界时也会调用PlayerEvent.Clone和PlayerRespawnEvent，而不会调用PlayerChangedDimensionEvent
	 */
	@SubscribeEvent
    public void OnDeadClone(PlayerEvent.Clone event) {
		final EntityPlayer _old = event.original;
		final EntityPlayer _new = event.entityPlayer;

		final NBTTagCompound newData = _new.getEntityData();
		// 设置新玩家欧若拉点数，切换世界点数不变，死亡减10
		final int newAuroraPoint = event.wasDeath ? Math.max(RewriteHelper.getAuroraPoint(_old) - 10, 0) : RewriteHelper.getAuroraPoint(_old);
		newData.setInteger("SkillPoint", newAuroraPoint);
		for (Skill i : RewriteHelper.SKILLS) {
			final String name = "Skill" + String.format("%03d", i.id);
			newData.setBoolean(name, RewriteHelper.hasSkill(_old, i.id));
		}
		
		// 复活或切换世界后同步，@RewriteNetwork.SendSyncPacket.onPlayerRespawn
	}

}
