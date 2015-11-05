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

	@SubscribeEvent
    public void OnDeadClone(PlayerEvent.Clone event) {
		final EntityPlayer _old = event.original;
		final EntityPlayer _new = event.entityPlayer;

		final NBTTagCompound newData = _new.getEntityData();
		newData.setInteger("SkillPoint", RewriteHelper.getAuroraPoint(_old));
		for (Skill i : RewriteHelper.SKILLS) {
			final String name = "Skill" + String.format("%03d", i.id);
			newData.setBoolean(name, RewriteHelper.hasSkill(_old, i.id));
		}
		
		// 复活后同步
	}

}
