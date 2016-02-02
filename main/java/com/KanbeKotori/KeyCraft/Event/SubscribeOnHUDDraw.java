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

import com.kanbekotori.keycraft.helper.MainHelper;
import com.kanbekotori.keycraft.helper.RewriteHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SubscribeOnHUDDraw {
	
	@SubscribeEvent
	public void ReDrawHUD(RenderGameOverlayEvent.Pre event) {
		if(event.type == ElementType.HEALTH) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	        int width = event.resolution.getScaledWidth();
	        int height = event.resolution.getScaledHeight();
	        int health = (int) MainHelper.getPlayerCl().getHealth();
	        int maxhealth = (int) MainHelper.getPlayerCl().getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
	        
	        int length = 90 * health / maxhealth;
	        Gui.drawRect(width / 2 - 91, height - 39, width / 2 - 1, height - 30, 0x7F000000);
	        Gui.drawRect(width / 2 - 91, height - 39, width / 2 - 91 + length, height - 30, 0x7F00FF00);
	        
	        String hp = "Health: " + health + " / " + maxhealth;
	        FontRenderer fontRenderer = mc.fontRenderer;
	        int color = 0xFFFFFF;
	        if (health <= maxhealth * 0.25) {color = 0xFF0000;}
	        else if (health <= maxhealth * 0.5) {color = 0xFFFF00;}
	        else if (health > maxhealth) {color = 0x00FF00;}
	        fontRenderer.drawStringWithShadow(hp, width / 2 - 91, height - 39, color);
	        fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//��ʼ��ײ�Ѽ�       
	        mc.renderEngine.bindTexture(Gui.icons);
	    } else if(event.type == ElementType.ARMOR) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight() - 10;
	    	int armor = ForgeHooks.getTotalArmorValue(MainHelper.getPlayerCl());
	    	int maxarmor = 20;
    
	    	if (armor != 0) {   
	    		int length = 90 * armor / maxarmor;
	    		Gui.drawRect(width / 2 - 91, height - 39, width / 2 - 1, height - 30, 0x7F000000);
	    		Gui.drawRect(width / 2 - 91, height - 39, width / 2 - 91 + length, height - 30, 0x7FAFAFAF);

	    		String ap = "Armor: " + armor + " / " + maxarmor;
	    		FontRenderer fontRenderer = mc.fontRenderer;
	    		fontRenderer.drawStringWithShadow(ap, width / 2 - 91, height - 39, 0xFFFFFF);
	    		fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//��ʼ��ײ�Ѽ�       
	    	}
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    } else if(event.type == ElementType.FOOD) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight();
	    	int hunger = MainHelper.getPlayerCl().getFoodStats().getFoodLevel();
	    	int maxhunger = 20;
     
	    	int length = 90 * hunger / maxhunger;
	    	Gui.drawRect(width / 2, height - 39, width / 2 + 90, height - 30, 0x7F000000);
	    	Gui.drawRect(width / 2, height - 39, width / 2 + length, height - 30, 0x7FFF0000);

	    	String hup = "Hunger: " + hunger + " / " + maxhunger;
	    	FontRenderer fontRenderer = mc.fontRenderer;
	    	fontRenderer.drawStringWithShadow(hup, width / 2, height - 39, 0xFFFFFF);
	    	fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//��ʼ��ײ�Ѽ�    
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    } else if(event.type == ElementType.AIR) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight() - 10;
	    	int air = MainHelper.getPlayerCl().getAir();
	    	int maxair = 300;
     
	    	if (air < 300) {
	    		int length = 90 * air / maxair;
	    		Gui.drawRect(width / 2, height - 39, width / 2 + 90, height - 30, 0x7F000000);
	    		Gui.drawRect(width / 2, height - 39, width / 2 + length, height - 30, 0x7F0000FF);

	    		String hup = "Air: " + air + " / " + maxair;
	    		FontRenderer fontRenderer = mc.fontRenderer;
	    		fontRenderer.drawStringWithShadow(hup, width / 2, height - 39, 0xFFFFFF);
	    		fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//��ʼ��ײ�Ѽ�    
	    	}
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    }
	}
	 
	@SubscribeEvent
	public void AuroraInfo(RenderGameOverlayEvent.Text event) {
		EntityPlayer player = MainHelper.getPlayerCl();
		String name = player.getCommandSenderName();
		String info = ", Your Aurora point is ";
		int point = RewriteHelper.getAuroraPoint(player);
	    event.left.add(0, name + info + point + ".");
	}

}
