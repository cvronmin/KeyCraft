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
package com.kanbekotori.keycraft.gui;

import com.kanbekotori.keycraft.KeyCraft;
import com.kanbekotori.keycraft.helper.*;

import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIRewrite_Polluting extends GuiScreen {
	
	public GuiScreen parentScreen;
	
	private GuiButton btnSkill300; // ŷ�����ƿ�
	private GuiButton btnSkill311; // ŷ����֮��
	private GuiButton btnSkill312; // ŷ����֮��
	private GuiButton btnSkill321; // ����
	private GuiButton btnSkill322; // ����UP
	private GuiButton btnSkill323; // ����MAX
	private GuiButton btnSkill331; // ����֮��
	private GuiButton btnSkill332; // ����֮��
	private GuiButton btnSkill333; // ����֮��
	private GuiButton btnSkill341; // ŷ��������
	private GuiButton btnSkill342; // ŷ����ӿ��
	private GuiButton btnSkill343; // ŷ��������
	
	private ResourceLocation bg0 = new ResourceLocation(KeyCraft.MODID, "textures/icons/bg0.png"); 
	private ResourceLocation bg1 = new ResourceLocation(KeyCraft.MODID, "textures/icons/bg1.png"); 
	private ResourceLocation logo = new ResourceLocation(KeyCraft.MODID, "textures/icons/logo.png");
	
	private EntityPlayer playerCl = MainHelper.getPlayerCl();
	
	public GUIRewrite_Polluting(GuiScreen parent) {
        parentScreen = parent;
	}

    @Override
	public void initGui() {
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id))
			buttonList.add(btnSkill300 = new GuiButton(RewriteHelper.AuroraControl.id, (int)(width * 0.2 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id))
			buttonList.add(btnSkill311 = new GuiButton(RewriteHelper.AuroraTrident.id, (int)(width * 0.2 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraTrident.id))
			buttonList.add(btnSkill312 = new GuiButton(RewriteHelper.AuroraBlade.id, (int)(width * 0.2 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id))
			buttonList.add(btnSkill321 = new GuiButton(RewriteHelper.FireResist.id, (int)(width * 0.4 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.FireResist.id))
			buttonList.add(btnSkill322 = new GuiButton(RewriteHelper.FireResistUp.id, (int)(width * 0.4 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.FireResistUp.id))
			buttonList.add(btnSkill323 = new GuiButton(RewriteHelper.FireResistMax.id, (int)(width * 0.4 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id))
			buttonList.add(btnSkill331 = new GuiButton(RewriteHelper.CuringFog.id, (int)(width * 0.6 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.CuringFog.id))
			buttonList.add(btnSkill332 = new GuiButton(RewriteHelper.HealingFog.id, (int)(width * 0.6 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HealingFog.id))
			buttonList.add(btnSkill333 = new GuiButton(RewriteHelper.HurtingFog.id, (int)(width * 0.6 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id))
			buttonList.add(btnSkill341 = new GuiButton(RewriteHelper.AuroraActivation.id, (int)(width * 0.8 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraActivation.id))
			buttonList.add(btnSkill342 = new GuiButton(RewriteHelper.AuroraSurge.id, (int)(width * 0.8 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraSurge.id))
			buttonList.add(btnSkill343 = new GuiButton(RewriteHelper.AuroraRegeneration.id, (int)(width * 0.8 - 16), (int)(height * 0.7), 32, 32, ""));
	}

    @Override
	public void drawScreen(int par1, int par2, float par3) {
		drawDefaultBackground();
        if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
        	mc.renderEngine.bindTexture(bg1);
        	func_146110_a((int)(width*0.05), (int)(height*0.05), 0, 0, (int)(width*0.9), (int)(height*0.8), (int)(width*0.9), (int)(height*0.8));
        } else {
        	mc.renderEngine.bindTexture(bg0);
        	func_146110_a((int)(width*0.05), (int)(height*0.05), 0, 0, (int)(width*0.9), (int)(height*0.8), (int)(width*0.9), (int)(height*0.8));
        }
        
        drawRect((int)(width*0.05), (int)(height*0.05), (int)(width*0.95), (int)(height*0.85), 0x80FFFFFF);
        
        mc.renderEngine.bindTexture(logo);
    	func_146110_a((int)(width*0.1), (int)(height*0.1), 0, 0, 128, 57, 128, 57);
       
   		super.drawScreen(par1,par2,par3);
   		String point;
        if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
        	point = RewriteHelper.getAuroraPoint(playerCl) + "";
        } else {
        	point = "???";
        }
   		drawString(fontRendererObj, "Your Aurora Point:" + point, (int)(width*0.5), (int)(height*0.2), 0xFFFFFF);

   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon300);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon311);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraTrident.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon312);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon321);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.FireResist.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon322);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.FireResistUp.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon323);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon331);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.CuringFog.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon332);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HealingFog.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon333);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon341);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraActivation.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon342);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraSurge.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon343);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
       
   }
   
   @Override
	protected void actionPerformed(GuiButton button) {
	   if (button == btnSkill300) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraControl.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraControl.id));
		   }
	   } else if (button == btnSkill311) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraTrident.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraTrident.id));
		   }
	   } else if (button == btnSkill312) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraBlade.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraBlade.id));
		   }
	   } else if (button == btnSkill321) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.FireResist.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.FireResist.id));
		   }
	   } else if (button == btnSkill322) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.FireResistUp.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.FireResistUp.id));
		   }
	   } else if (button == btnSkill323) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.FireResistMax.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.FireResistMax.id));
		   }
	   } else if (button == btnSkill331) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.CuringFog.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.CuringFog.id));
		   }
	   } else if (button == btnSkill332) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.HealingFog.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.HealingFog.id));
		   }
	   } else if (button == btnSkill333) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.HurtingFog.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.HurtingFog.id));
		   }
	   } else if (button == btnSkill341) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraActivation.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraActivation.id));
		   }
	   } else if (button == btnSkill342) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraSurge.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraSurge.id));
		   }
	   } else if (button == btnSkill343) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraRegeneration.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraRegeneration.id));
		   }
	   }
	}
		
	public GuiScreen getThisScreen() {
		return mc.currentScreen;
	}

}
