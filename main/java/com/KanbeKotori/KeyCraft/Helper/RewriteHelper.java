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
package com.kanbekotori.keycraft.helper;

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

import com.kanbekotori.keycraft.helper.*;
import com.kanbekotori.keycraft.items.ModItems;
import com.kanbekotori.keycraft.network.RewriteNetwork;

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
	public static final Skill TrapProficient		= new Skill(111, 10);
	public static final Skill BloodTrap				= new Skill(112, 20);
	public static final Skill ViolinAttack			= new Skill(121, 10);
	public static final Skill Shooting				= new Skill(122, 20);
	public static final Skill Cream_KagariCannon	= new Skill(123, 20);
	public static final Skill MissileProficient		= new Skill(131, 10);
	public static final Skill JavelinOfLouis		= new Skill(132, 10);
	public static final Skill DeadlyDictionary		= new Skill(133, 20);
	public static final Skill OtherWorldPerception	= new Skill(141, 15);
	public static final Skill Nightvision			= new Skill(142, 15);
	public static final Skill EnergyPointUsage		= new Skill(143, 20);
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
	public static final Skill CuringFog				= new Skill(331, 15);
	public static final Skill HealingFog			= new Skill(332, 15);
	public static final Skill HurtingFog			= new Skill(333, 15);
	public static final Skill AuroraActivation		= new Skill(341, 20);
	public static final Skill AuroraSurge			= new Skill(342, 20);
	public static final Skill AuroraRegeneration	= new Skill(343, 40);
	
	public static final Skill SKILLS[] = { AuroraCognition,
		HuntingRhythm, 			TrapProficient, 	BloodTrap,
		ViolinAttack,			Shooting,			Cream_KagariCannon,
		MissileProficient, 		JavelinOfLouis,		DeadlyDictionary,
		OtherWorldPerception,	Nightvision,		EnergyPointUsage,
		UrgentProtect, 			BattleReadiness, 	PhysiqueUp,
		FireAttach, 			PoisonAttach, 		WitherAttach,
		SuperVibration, 		BruteForce, 		ParryProficient,
		LifeSuck, 				PowerDown, 			AuroraRob,
		AuroraControl,			AuroraTrident, 		AuroraBlade,
		FireResist, 			FireResistUp, 		FireResistMax,
		CuringFog, 				HealingFog, 		HurtingFog, 
		AuroraActivation, 		AuroraSurge, 		AuroraRegeneration
		};
	
	/** ѧϰŷ������֪�����100ŷ������ */
	public static void initializeSkills(EntityPlayer player) {
		setAuroraPoint(player, 100);
		learnSkill(player, AuroraCognition.id, true);
	}
	
	/** �ж���û��ŷ������֪ */
	public static boolean hasInitialized(EntityPlayer player) {
		return hasSkill(player, AuroraCognition.id);
	}
	
	/** ȡŷ������ */
	public static int getAuroraPoint(EntityPlayer player) {
		return player.getEntityData().getInteger("SkillPoint");
	}
	
	/** ����ŷ�����㣬����ڷ���˻ᷢͬ���� */
	public static void setAuroraPoint(EntityPlayer player, int point) {
		player.getEntityData().setInteger("SkillPoint", point < 0 ? 0 : point);
		if (player instanceof EntityPlayerMP) {
			RewriteNetwork.rewriteChannel.sendTo(RewriteNetwork.createSyncAuroraPointPacket(player), (EntityPlayerMP)player);
		}
	}
	
	/** �ı�ŷ�����㣬����ڷ���˻ᷢͬ���� */
	public static void modifyAuroraPoint(EntityPlayer player, int point) {
		int newPoint = getAuroraPoint(player) + point;
		player.getEntityData().setInteger("SkillPoint", newPoint < 0 ? 0 : newPoint);
		if (player instanceof EntityPlayerMP) {
			RewriteNetwork.rewriteChannel.sendTo(RewriteNetwork.createSyncAuroraPointPacket(player), (EntityPlayerMP)player);
		}
	}
	
	/** ѧϰ\ȡ�����ܣ�����ڷ���˻ᷢͬ���� */
	public static void learnSkill(EntityPlayer player, int skill, boolean PuP) {
		final String name = "Skill" + String.format("%03d", skill);
		player.getEntityData().setBoolean(name, PuP);
		if (player instanceof EntityPlayerMP) {
			RewriteNetwork.rewriteChannel.sendTo(RewriteNetwork.createSyncSkillPacket(player), (EntityPlayerMP)player);
		}
	}

	/** �ж���û�м��� */
	public static boolean hasSkill(EntityPlayer player, int skill) {
		final String name = "Skill" + String.format("%03d", skill);
		return player.getEntityData().getBoolean(name);
	}
	
	/** ȡѧϰ������Ҫ��ŷ������ */
	public static int getAuroraRequired(int skill) {
		for (Skill i : SKILLS) {
			if (i.id == skill) {
				return i.AuroraRequired;
			}
		}
		return 0x7FFFFFFF;
	}
	
	/** ѧϰ���� */
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
	
	/** ʹ�ü��� */
	public static void useSkill(EntityPlayer player) {
		if (player.worldObj.isRemote) {
			RewriteNetwork.rewriteChannel.sendToServer(RewriteNetwork.createUseSkillPacket());
		}
		
		ItemStack held = player.getHeldItem();
		if (held == null) {
			if (hasSkill(player, AuroraBlade.id)
				&& getAuroraPoint(player) > 1
				) {				// ʵ�����Skill312-��ŷ����֮�С���Ч����
    			modifyAuroraPoint(player, -1);
    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraBlade, 1));
    			if (!player.worldObj.isRemote) {
        			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.callblade")));
    			}
    		} else if (hasSkill(player, AuroraTrident.id)
    				   && getAuroraPoint(player) > 1
    				   ) {		// ʵ�����Skill311-��ŷ��������ꪡ���Ч����
    			modifyAuroraPoint(player, -1);
    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraTrident, 1));
    			if (!player.worldObj.isRemote) {
    				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.calltrident")));
    			}
    		}
    	} else {
    		if (held.getItem() == Items.iron_ingot) {	// ʵ�����Skill300-��ŷ�����ƿء���Ч����
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
    		if (held.getItem() == Items.iron_sword) {	// ʵ�����Skill231-�����񶯡���Ч����
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
    		if (held.getItem() == Items.string) {	// ʵ�����Skill123-�����͡������Ĵ��ڡ���Ч����
    			int num = held.stackSize;
    			if (hasSkill(player, AuroraControl.id)
    				&& getAuroraPoint(player) > num
    				) {
    				player.setCurrentItemOrArmor(0, new ItemStack(ModItems.MiracleRibbon, num));
    				modifyAuroraPoint(player, -num);
    				if (!player.worldObj.isRemote) {
    					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.aurorainjection")));
    				}
    			}
    		}
    	}
	}
	
	/** ����ŷ��������ꪻ� */
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
	
	/** ŷ��������ꪻ򽣱��ƻ����debuff */
	public static void breakAurora(EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 6000, 3));
        player.addPotionEffect(new PotionEffect(Potion.confusion.id, 6000));
        player.addPotionEffect(new PotionEffect(Potion.weakness.id, 6000, 3));
    }
	
}
