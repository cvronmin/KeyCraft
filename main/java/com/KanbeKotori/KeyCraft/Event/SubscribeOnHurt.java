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
import com.kanbekotori.keycraft.items.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;

public class SubscribeOnHurt {

	/** �ж�Skill211-��ս��׼�����Ƿ��Ѿ�CD�����ǲ���ͬ�����������л����������CD�� */
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

	/** �ж�Skill321-�������Ƿ��Ѿ�CD�����ǲ���ͬ�����������л����������CD�� */
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
	
	/** �ж�Skill322-������UP���Ƿ��Ѿ�CD�����ǲ���ͬ�����������л����������CD�� */
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
	
	/** �ж�Skill322-������UP��\Skill323-������MAX�����µ�����������˺��Ƿ��Ѿ�CD�����ǲ���ͬ�����������л����������CD�� */
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
	
	/** �����ΪSkill141-�����Ԫ��֪�������outOfWorld�˺� */
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
	
	/** �����ΪSkill233-���񵲾�ͨ�������ĳЩ�˺� */
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
    
    /** �����ΪSkill211-��ս��׼��������buff */
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
		
	/** �����ΪSkill321-������\Skill322-������UP��\Skill323-������MAX�������ĳЩ�˺� */
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
