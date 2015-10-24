package com.KanbeKotori.KeyCraft.Helper;

import java.util.*;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;

import com.KanbeKotori.KeyCraft.Helper.*;

public class RewriteHelper {
	
	public void setPoint_First(EntityPlayer player) {
		RewriteHelper rwhelper = new RewriteHelper();
		rwhelper.setAuroraPoint(player, 100);
		rwhelper.setPoint(player, 000, true);
	}
	
	public boolean hasFirstSet(EntityPlayer player) {
		RewriteHelper rwhelper = new RewriteHelper();
		return rwhelper.getPoint(player, 000);
	}
	
	public void setAuroraPoint(EntityPlayer player, int point) {
		if (point >= 0) {
			player.getEntityData().setInteger("SkillPoint", point);
		}	
	}
		
	public int getAuroraPoint(EntityPlayer player) {
		return player.getEntityData().getInteger("SkillPoint");
	}
	
	public void minusAuroraPoint(EntityPlayer player, int point) {
		if (point >= 0) {
			player.getEntityData().setInteger("SkillPoint", getAuroraPoint(player) - point);
		}	
	}
	
	public void addAuroraPoint(EntityPlayer player, int point) {
		if (point >= 0) {
			player.getEntityData().setInteger("SkillPoint", getAuroraPoint(player) + point);
		}	
	}
	
	public void setPoint(EntityPlayer player, int num, boolean PuP) {
		String name = "Skill" + num;
		player.getEntityData().setBoolean(name, PuP);
	}
	
	public boolean getPoint(EntityPlayer player, int num) {
		String name = "Skill" + num;
		return player.getEntityData().getBoolean(name) ;
	}
	
	public int getAuroraRequired(int pointNum) {
		switch (pointNum) {
			case 200:	return 5;
			case 211:	return 25;
			case 212:	return 40;
			case 221:	return 10;
			case 222:	return 10;
			case 223:	return 20;
			case 231:	return 10;
			case 232:	return 10;
			case 233:	return 30;
			case 241:	return 20;
			case 242:	return 20;
			case 243:	return 20;
			case 300:	return 5;
			case 311:	return 5;
			case 312:	return 10;
			case 321:	return 5;
			case 322:	return 5;
			case 323:	return 20;
			case 331:	return 10;
			case 332:	return 10;
			case 333:	return 30;
			case 341:	return 20;
			case 342:	return 20;
			case 343:	return 40;
			default:	return 2147483647;	
		}
	}
	
	public void CLONE(EntityPlayer _old, EntityPlayer _new) {
		setAuroraPoint(_new, getAuroraPoint(_old));
		int a[] = {000, 200, 211, 212, 221, 222, 223, 231, 232, 233, 241, 242, 243, 300, 311, 312, 321, 322, 323, 331, 332, 333, 341, 342, 343};
		for (int i = 0; i < 25; i++) {
			setPoint(_new, a[i], getPoint(_old, a[i]));
		}
	}
	
	public void setShakingSwordDamage(EntityPlayer player, int damage) {
		String name = "ShakingSwordDamage";
		player.getEntityData().setInteger(name, damage);
	}
	
	public int getShakingSwordDamage(EntityPlayer player) {
		String name = "ShakingSwordDamage";
		return player.getEntityData().getInteger(name);
	}
	
}
