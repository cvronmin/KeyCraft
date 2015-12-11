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
import com.KanbeKotori.KeyCraft.Items.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

public class SubscribeOnHurt {

	/** 判断Skill211-『战斗准备』是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_Buff_Resistance(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_BattleReadiness") >= 30 * 20) {
    		player.getEntityData().setLong("LastTime_BattleReadiness", time);
			if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.resistance")));
			}
    		return true;
    	}
    	return false;
    }

	/** 判断Skill321-『抗火』是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_against_fire(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_AgFire") >= 60 * 20) {
    		player.getEntityData().setLong("LastTime_AgFire", time);
    		if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstfire")));
			}
    		return true;
    	}
    	return false;
    }
	
	/** 判断Skill322-『抗火UP』是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_against_lava(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_AgLava") >= 30 * 20) {
    		player.getEntityData().setLong("LastTime_AgLava", time);
    		if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstfireplus")));
			}
    		return true;
    	}
    	return false;
    }
	
	/** 判断Skill322-『抗火UP』\Skill323-『抗火MAX』导致的无损耗无视伤害是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_mention(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_IgnoreFire") >= 30 * 20) {
    		player.getEntityData().setLong("LastTime_IgnoreFire", time);
    		if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.againstfiremax")));
			}
    		return true;
    	}
    	return false;
    }
	
	/** 玩家因为Skill141-『异次元感知』而免除outOfWorld伤害 */
    @SubscribeEvent
    public void Point_OtherWorldPerception(LivingHurtEvent event) {
        if(event.entityLiving instanceof EntityPlayer) {
    		EntityPlayer player = (EntityPlayer)event.entityLiving;
    		if (RewriteHelper.hasSkill(player, RewriteHelper.OtherWorldPerception.id)
    			&& event.source.damageType.equals("outOfWorld")
    			) {
				event.setCanceled(true);
    		}
    	}
    }
	
	/** 玩家因为Skill233-『格挡精通』而免除某些伤害 */
    @SubscribeEvent
    public void Point_Block(LivingHurtEvent event) {
        if(event.entityLiving instanceof EntityPlayer) {
    		EntityPlayer player = (EntityPlayer)event.entityLiving;
    		if (RewriteHelper.hasSkill(player, RewriteHelper.ParryProficient.id)
    			&& player.isUsingItem()
    			&& (player.getItemInUse().getItem() instanceof ItemSword
    			|| player.getItemInUse().getItem() instanceof ItemAuroraBlade)
    			) {
				int level = player.getFoodStats().getFoodLevel();
				if (level >= 1) {
					event.setCanceled(true);
					player.getFoodStats().setFoodLevel(level - 1);
				}
    		}
    	}
    }
    
    /** 玩家因为Skill211-『战斗准备』而加buff */
	@SubscribeEvent
	public void Point_AutoBuffResistance(LivingHurtEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if ((event.source.damageType.equals("arrow")
				|| event.source.damageType.equals("mob")
				|| event.source.damageType.equals("player"))
				&& RewriteHelper.hasSkill(player, RewriteHelper.BattleReadiness.id)
				&& isCD_Buff_Resistance(player)
				) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
			}
		}
	}
		
	/** 玩家因为Skill321-『抗火』\Skill322-『抗火UP』\Skill323-『抗火MAX』而免除某些伤害 */
	@SubscribeEvent
	public void PointAgainstFireAndLava(LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			if (event.source.damageType.equals("lava")) {
				if (RewriteHelper.hasSkill(player, RewriteHelper.FireResistMax.id)) {
    				event.setCanceled(true); 
    				isCD_mention(player);
    			} else if (RewriteHelper.hasSkill(player, RewriteHelper.FireResistUp.id)) {
    				event.setCanceled(true);
    				if (isCD_against_lava(player)) {
    					RewriteHelper.modifyAuroraPoint(player, -1);
    				}
    			}
    		} else if (event.source.damageType.equals("inFire")
    				   || event.source.damageType.equals("onFire")
    				   ) {
    			if (RewriteHelper.hasSkill(player, RewriteHelper.FireResistUp.id)) {
    				event.setCanceled(true); 
    				isCD_mention(player);
    			} else if (RewriteHelper.hasSkill(player, RewriteHelper.FireResist.id)) {
    				event.setCanceled(true);
    				if (isCD_against_fire(player)) {
    					RewriteHelper.modifyAuroraPoint(player, -1);
    				}
    			}
    		} 
		}
	}

}
