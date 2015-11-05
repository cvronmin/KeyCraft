package com.KanbeKotori.KeyCraft.Helper;

import java.util.*;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;

import com.KanbeKotori.KeyCraft.Helper.*;
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
	public static final Skill UrgentProtect			= new Skill(200, 5);
	public static final Skill BattleReadiness		= new Skill(211, 25);
	public static final Skill PhysiqueUp			= new Skill(212, 40);
	public static final Skill FireAttach			= new Skill(221, 10);
	public static final Skill PoisonAttach			= new Skill(222, 10);
	public static final Skill WitherAttach			= new Skill(223, 20);
	public static final Skill SuperVibration		= new Skill(231, 10);
	public static final Skill BruteForce			= new Skill(232, 10);
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
	
	public static final Skill SKILLS[] = { AuroraCognition, HuntingRhythm, UrgentProtect, UrgentProtect, BattleReadiness, PhysiqueUp, FireAttach, PoisonAttach, 
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
	
	public static void setShakingSwordDamage(EntityPlayer player, int damage) {
		final String name = "ShakingSwordDamage";
		player.getEntityData().setInteger(name, damage);
	}
	
	public static int getShakingSwordDamage(EntityPlayer player) {
		final String name = "ShakingSwordDamage";
		return player.getEntityData().getInteger(name);
	}
	
}
