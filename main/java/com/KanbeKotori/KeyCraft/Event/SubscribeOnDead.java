package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper.Skill;
import com.KanbeKotori.KeyCraft.Network.RewriteNetwork;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnDead {
	
	/** 
	 * 计算合适的新玩家的欧若拉点数。
	 * 如果玩家因转换世界而发动克隆，点数不变；
	 * 否则扣除10点欧若拉（如果足够的话）。
	 */
	private int getPointAppropriate(EntityPlayer _old) {
		int point_old = RewriteHelper.getAuroraPoint(_old);
		if (_old.isDead)
			return Math.max(point_old - 10, 0);
		return point_old;
	}

	/**
	 * 在玩家死亡时将旧玩家的所有Skill以及欧若拉点数克隆给Respawn以后的新玩家
	 * 在切换世界时也会调用
	 */
	@SubscribeEvent
    public void OnDeadClone(PlayerEvent.Clone event) {
		final EntityPlayer _old = event.original;
		final EntityPlayer _new = event.entityPlayer;

		final NBTTagCompound newData = _new.getEntityData();
		// 设置新玩家欧若拉点数
		newData.setInteger("SkillPoint", getPointAppropriate(_old));
		for (Skill i : RewriteHelper.SKILLS) {
			final String name = "Skill" + String.format("%03d", i.id);
			newData.setBoolean(name, RewriteHelper.hasSkill(_old, i.id));
		}
				
		// 复活后同步，@RewriteNetwork.SendSyncPacket.onPlayerRespawn
	}

}
