package com.KanbeKotori.KeyCraft.Helper;

import java.util.*;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;

import com.KanbeKotori.KeyCraft.Helper.*;

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
	public static final Skill AuroraRob				= new Skill(243, 20);
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
	
	public static final Skill SKILLS[] = { AuroraCognition, UrgentProtect, UrgentProtect, BattleReadiness, PhysiqueUp, FireAttach, PoisonAttach, 
			WitherAttach, SuperVibration, BruteForce, ParryProficient, LifeSuck, PowerDown, AuroraRob, AuroraControl, AuroraTrident, 
			AuroraBlade, FireResist, FireResistUp, FireResistMax, FireResistMax, ExplosionResist, MagicResist, UltimateHardening, 
			AuroraActivation, AuroraSurge, AuroraRegeneration };
	
	
	public static void setPoint_First(EntityPlayer player) {
		setAuroraPoint(player, 100);
		setPoint(player, AuroraCognition.id, true);
	}
	
	public static boolean hasFirstSet(EntityPlayer player) {
		return getPoint(player, AuroraCognition.id);
	}
	
	public static void setAuroraPoint(EntityPlayer player, int point) {
		if (point >= 0) {
			player.getEntityData().setInteger("SkillPoint", point);
		}	
	}
		
	public static int getAuroraPoint(EntityPlayer player) {
		return player.getEntityData().getInteger("SkillPoint");
	}
	
	public static void minusAuroraPoint(EntityPlayer player, int point) {
		if (point >= 0) {
			player.getEntityData().setInteger("SkillPoint", getAuroraPoint(player) - point);
		}	
	}
	
	public static void addAuroraPoint(EntityPlayer player, int point) {
		if (point >= 0) {
			player.getEntityData().setInteger("SkillPoint", getAuroraPoint(player) + point);
		}	
	}
	
	public static void setPoint(EntityPlayer player, int skill, boolean PuP) {
		final String name = "Skill" + String.format("%03d", skill);
		player.getEntityData().setBoolean(name, PuP);
	}
	
	public static boolean getPoint(EntityPlayer player, int skill) {
		final String name = "Skill" + String.format("%03d", skill);
		return player.getEntityData().getBoolean(name) ;
	}
	
	public static int getAuroraRequired(int skill) {
		for (Skill i : SKILLS) {
			if (i.id == skill) {
				return i.AuroraRequired;
			}
		}
		return 0x7FFFFFFF;
	}
	
	public static void CLONE(EntityPlayer _old, EntityPlayer _new) {
		setAuroraPoint(_new, getAuroraPoint(_old));
		for (Skill i : SKILLS) {
			setPoint(_new, i.id, getPoint(_old, i.id));
		}
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
