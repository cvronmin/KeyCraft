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

import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribePointAgainstMagic {
	
	/** 判断Skill331-『抗爆炸外壳』是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_against_arrow(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_AgArrow") >= 5 * 20) {
    		player.getEntityData().setLong("LastTime_AgArrow", time);
    		if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstexplosion")));
			}
    		return true;
    	}
    	return false;
    }
	
	/** 判断Skill332-『抗魔法外壳』是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_against_magic(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_AgMagic") >= 30 * 20) {
    		player.getEntityData().setLong("LastTime_AgMagic", time);
    		if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstmagic")));
			}
    		return true;
    	}
    	return false;
    }
	
	/** 判断Skill333-『终极硬化外壳』是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_against_magic_plus(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_AgMagicPlus") >= 30 * 20) {
    		player.getEntityData().setLong("LastTime_AgMagicPlus", time);
    		if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstmagicplus")));
			}
    		return true;
    	}
    	return false;
    }
	
	/** 玩家因为Skill331-『抗爆炸外壳』\Skill332-『抗魔法外壳』\Skill333-『终极硬化外壳』而免除某些伤害 */
	@SubscribeEvent
	public void PointAgainstMagic(LivingHurtEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
    		EntityPlayer player = (EntityPlayer)event.entityLiving;
			if (event.source.damageType.equals("arrow")
				|| event.source.damageType.equals("explosion")
				|| event.source.damageType.equals("explosion.player")
				) {
				if (RewriteHelper.hasSkill(player, RewriteHelper.UltimateHardening.id)) {
    				event.setCanceled(true);
    				isCD_against_magic_plus(player);
    			} else if (RewriteHelper.hasSkill(player, RewriteHelper.ExplosionResist.id)) {
    				event.setCanceled(true);
    				if (isCD_against_arrow(player)) {
    					RewriteHelper.modifyAuroraPoint(player, -1);
    				}
    			}
    		} else if (event.source.damageType.equals("magic")
    				   || event.source.damageType.equals("indirectMagic")
    				   ) {
    			if (RewriteHelper.hasSkill(player, RewriteHelper.UltimateHardening.id)) {
    				event.setCanceled(true);
    				isCD_against_magic_plus(player);
    			} else if (RewriteHelper.hasSkill(player, RewriteHelper.MagicResist.id)) {
    				event.setCanceled(true);
    				if (isCD_against_magic(player)) {
    					RewriteHelper.modifyAuroraPoint(player, -1);
    				}
    			}
    		} 
		}
	}

}
