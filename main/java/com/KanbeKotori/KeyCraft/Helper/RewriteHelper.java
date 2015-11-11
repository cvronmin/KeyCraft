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
package com.KanbeKotori.KeyCraft.Helper;

import java.util.*;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.*;

import com.KanbeKotori.KeyCraft.Helper.*;
import com.KanbeKotori.KeyCraft.Items.ModItems;
import com.KanbeKotori.KeyCraft.Network.RewriteNetwork;

public class RewriteHelper {
	
	public static class Skill {
		public final int id;
		public final int AuroraRequired;
		public Skill(int id, int AuroraRequired) {
			this.id = id;
			this.AuroraRequired = AuroraRequired;
		}
	}
	
	public static final Skill AuroraCognition		= new Skill(000, 0);
	public static final Skill HuntingRhythm			= new Skill(100, 5);
	public static final Skill MissileProficient		= new Skill(131, 15);
	public static final Skill UrgentProtect			= new Skill(200, 5);
	public static final Skill BattleReadiness		= new Skill(211, 25);
	public static final Skill PhysiqueUp			= new Skill(212, 40);
	public static final Skill FireAttach			= new Skill(221, 10);
	public static final Skill PoisonAttach			= new Skill(222, 10);
	public static final Skill WitherAttach			= new Skill(223, 20);
	public static final Skill SuperVibration		= new Skill(231, 10);
	public static final Skill BruteForce			= new Skill(232, 20);
	public static final Skill ParryProficient		= new Skill(233, 20);
	public static final Skill LifeSuck				= new Skill(241, 20);
	public static final Skill PowerDown				= new Skill(242, 20);
	public static final Skill AuroraRob				= new Skill(243, 30);
	public static final Skill AuroraControl			= new Skill(300, 5);
	public static final Skill AuroraTrident			= new Skill(311, 5);
	public static final Skill AuroraBlade			= new Skill(312, 10);
	public static final Skill FireResist			= new Skill(321, 5);
	public static final Skill FireResistUp			= new Skill(322, 5);
	public static final Skill FireResistMax			= new Skill(323, 20);
	public static final Skill ExplosionResist		= new Skill(331, 10);
	public static final Skill MagicResist			= new Skill(332, 10);
	public static final Skill UltimateHardening		= new Skill(333, 30);
	public static final Skill AuroraActivation		= new Skill(341, 20);
	public static final Skill AuroraSurge			= new Skill(342, 20);
	public static final Skill AuroraRegeneration	= new Skill(343, 40);
	
	public static final Skill SKILLS[] = { AuroraCognition, HuntingRhythm, MissileProficient, UrgentProtect, UrgentProtect, BattleReadiness, PhysiqueUp, FireAttach, PoisonAttach, 
			WitherAttach, SuperVibration, BruteForce, ParryProficient, LifeSuck, PowerDown, AuroraRob, AuroraControl, AuroraTrident, 
			AuroraBlade, FireResist, FireResistUp, FireResistMax, FireResistMax, ExplosionResist, MagicResist, UltimateHardening, 
			AuroraActivation, AuroraSurge, AuroraRegeneration };
	
	/** 学习欧若拉认知，获得100欧若拉点 */
	public static void initializeSkills(EntityPlayer player) {
		setAuroraPoint(player, 100);
		learnSkill(player, AuroraCognition.id, true);
	}
	
	/** 判断有没有欧若拉认知 */
	public static boolean hasInitialized(EntityPlayer player) {
		return hasSkill(player, AuroraCognition.id);
	}
	
	/** 取欧若拉点 */
	public static int getAuroraPoint(EntityPlayer player) {
		return player.getEntityData().getInteger("SkillPoint");
	}
	
	/** 设置欧若拉点，如果在服务端会发同步包 */
	public static void setAuroraPoint(EntityPlayer player, int point) {
		player.getEntityData().setInteger("SkillPoint", point < 0 ? 0 : point);
		if (player instanceof EntityPlayerMP) {
			RewriteNetwork.rewriteChannel.sendTo(RewriteNetwork.createSyncAuroraPointPacket(player), (EntityPlayerMP)player);
		}
	}
	
	/** 改变欧若拉点，如果在服务端会发同步包 */
	public static void modifyAuroraPoint(EntityPlayer player, int point) {
		int newPoint = getAuroraPoint(player) + point;
		player.getEntityData().setInteger("SkillPoint", newPoint < 0 ? 0 : newPoint);
		if (player instanceof EntityPlayerMP) {
			RewriteNetwork.rewriteChannel.sendTo(RewriteNetwork.createSyncAuroraPointPacket(player), (EntityPlayerMP)player);
		}
	}
	
	/** 学习\取消技能，如果在服务端会发同步包 */
	public static void learnSkill(EntityPlayer player, int skill, boolean PuP) {
		final String name = "Skill" + String.format("%03d", skill);
		player.getEntityData().setBoolean(name, PuP);
		if (player instanceof EntityPlayerMP) {
			RewriteNetwork.rewriteChannel.sendTo(RewriteNetwork.createSyncSkillPacket(player), (EntityPlayerMP)player);
		}
	}

	/** 判断有没有技能 */
	public static boolean hasSkill(EntityPlayer player, int skill) {
		final String name = "Skill" + String.format("%03d", skill);
		return player.getEntityData().getBoolean(name);
	}
	
	/** 取学习技能需要的欧若拉点 */
	public static int getAuroraRequired(int skill) {
		for (Skill i : SKILLS) {
			if (i.id == skill) {
				return i.AuroraRequired;
			}
		}
		return 0x7FFFFFFF;
	}
	
	/** 学习技能 */
	public static void learnSkill(EntityPlayer player, int skillId) {
		if (player.worldObj.isRemote) {
			RewriteNetwork.rewriteChannel.sendToServer(RewriteNetwork.createLearnSkillPacket(skillId));
		}
		
		if (skillId == AuroraCognition.id) {
    		initializeSkills(player);
    	} else {
    		int point = getAuroraRequired(skillId);
    		if (getAuroraPoint(player) > point) {
    			modifyAuroraPoint(player, -point);
    			learnSkill(player, skillId, true);
    		}
    	}
	}
	
	/** 使用技能 */
	public static void useSkill(EntityPlayer player) {
		if (player.worldObj.isRemote) {
			RewriteNetwork.rewriteChannel.sendToServer(RewriteNetwork.createUseSkillPacket());
		}
		
		ItemStack held = player.getHeldItem();
		if (held == null) {
			if (hasSkill(player, AuroraBlade.id)
				&& getAuroraPoint(player) > 1
				) {				// 实现玩家Skill312-『欧若拉之刃』的效果。
    			modifyAuroraPoint(player, -1);
    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraBlade, 1));
    			if (!player.worldObj.isRemote) {
        			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.callblade")));
    			}
    		} else if (hasSkill(player, AuroraTrident.id)
    				   && getAuroraPoint(player) > 1
    				   ) {		// 实现玩家Skill311-『欧若拉三叉戟』的效果。
    			modifyAuroraPoint(player, -1);
    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraTrident, 1));
    			if (!player.worldObj.isRemote) {
    				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.calltrident")));
    			}
    		}
    	} else {
    		if (held.getItem() == Items.iron_ingot) {	// 实现玩家Skill300-『欧若拉掌控』的效果。
    			int num = held.stackSize;
    			if (hasSkill(player, AuroraControl.id)
    				&& getAuroraPoint(player) > num
    				) {
    				player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraIronIngot, num));
    				modifyAuroraPoint(player, -num);
    				if (!player.worldObj.isRemote) {
    					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.aurorainjection")));
    				}
    			}
    		}
    		if (held.getItem() == Items.iron_sword) {	// 实现玩家Skill231-『超振动』的效果。
    			if (hasSkill(player, SuperVibration.id)
    					&& getAuroraPoint(player) > 1
    					) {
    				player.setCurrentItemOrArmor(0, new ItemStack(ModItems.ShakingSword, 1, held.getItemDamage()));
    				modifyAuroraPoint(player, -1);
    				if (!player.worldObj.isRemote) {
    					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.shakingsword")));
    				}
    			}
    		}
    	}
	}
	
	/** 回收欧若拉三叉戟或剑 */
	public static void recycleAurora(EntityPlayer player, double proportion) {
		if (proportion == 0) {
			RewriteHelper.modifyAuroraPoint(player, 1);
		} else {
			if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.recyclerate") 
									  + String.format("%.3f", proportion)));
			}
			int time = (int)(6000 * proportion);
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, time, 1));
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, time, 3));
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, time));
			player.addPotionEffect(new PotionEffect(Potion.weakness.id, time, 3));
		}
	}
	
	/** 欧若拉三叉戟或剑被破坏后给debuff */
	public static void breakAurora(EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 6000, 3));
        player.addPotionEffect(new PotionEffect(Potion.confusion.id, 6000));
        player.addPotionEffect(new PotionEffect(Potion.weakness.id, 6000, 3));
    }
	
}
