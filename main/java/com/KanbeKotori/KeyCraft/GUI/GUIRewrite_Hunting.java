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

import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;

import com.kanbekotori.keycraft.KeyCraft;
import com.kanbekotori.keycraft.helper.*;

public class GUIRewrite_Hunting extends GuiScreen {
	
	public GuiScreen parentScreen;
	
	private GuiButton btnSkill100; // �����ɶ�
	private GuiButton btnSkill111; // ���徫ͨ
	private GuiButton btnSkill112; // Ѫ֮����
	private GuiButton btnSkill121; // ��������
	private GuiButton btnSkill122; // �������
	private GuiButton btnSkill123; // ���͡������Ĵ���
	private GuiButton btnSkill131; // Ͷ���ﾫͨ
	private GuiButton btnSkill132; // ·��˹֮ǹ
	private GuiButton btnSkill133; // �����ֵ�
	private GuiButton btnSkill141; // ���Ԫ��֪
	private GuiButton btnSkill142; // ҹ��
	private GuiButton btnSkill143; // ����������
	
	private EntityPlayer playerCl = MainHelper.getPlayerCl();
	
	public GUIRewrite_Hunting(GuiScreen parent) {
        parentScreen = parent;
	}

    @Override
	public void initGui() {
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id))
			buttonList.add(btnSkill100 = new GuiButton(RewriteHelper.HuntingRhythm.id, (int)(width * 0.2 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id))
			buttonList.add(btnSkill111 = new GuiButton(RewriteHelper.TrapProficient.id, (int)(width * 0.2 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.TrapProficient.id))
			buttonList.add(btnSkill112 = new GuiButton(RewriteHelper.BloodTrap.id, (int)(width * 0.2 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id))
			buttonList.add(btnSkill121 = new GuiButton(RewriteHelper.ViolinAttack.id, (int)(width * 0.4 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.ViolinAttack.id))
			buttonList.add(btnSkill122 = new GuiButton(RewriteHelper.Shooting.id, (int)(width * 0.4 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.Shooting.id))
			buttonList.add(btnSkill123 = new GuiButton(RewriteHelper.Cream_KagariCannon.id, (int)(width * 0.4 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id))
			buttonList.add(btnSkill131 = new GuiButton(RewriteHelper.MissileProficient.id, (int)(width * 0.6 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.MissileProficient.id))
			buttonList.add(btnSkill132 = new GuiButton(RewriteHelper.JavelinOfLouis.id, (int)(width * 0.6 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.JavelinOfLouis.id))
			buttonList.add(btnSkill133 = new GuiButton(RewriteHelper.DeadlyDictionary.id, (int)(width * 0.6 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id))
			buttonList.add(btnSkill141 = new GuiButton(RewriteHelper.OtherWorldPerception.id, (int)(width * 0.8 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.OtherWorldPerception.id))
			buttonList.add(btnSkill142 = new GuiButton(RewriteHelper.Nightvision.id, (int)(width * 0.8 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.Nightvision.id))
			buttonList.add(btnSkill143 = new GuiButton(RewriteHelper.EnergyPointUsage.id, (int)(width * 0.8 - 16), (int)(height * 0.7), 32, 32, ""));
	}

    @Override
	public void drawScreen(int par1, int par2, float par3) {
		drawDefaultBackground();
        if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
        	mc.renderEngine.bindTexture(ResourceHelper.bg1);
        	func_146110_a((int)(width*0.05), (int)(height*0.05), 0, 0, (int)(width*0.9), (int)(height*0.8), (int)(width*0.9), (int)(height*0.8));
        } else {
        	mc.renderEngine.bindTexture(ResourceHelper.bg0);
        	func_146110_a((int)(width*0.05), (int)(height*0.05), 0, 0, (int)(width*0.9), (int)(height*0.8), (int)(width*0.9), (int)(height*0.8));
        }
        
        drawRect((int)(width*0.05), (int)(height*0.05), (int)(width*0.95), (int)(height*0.85), 0x80FFFFFF);
        
        mc.renderEngine.bindTexture(ResourceHelper.logo);
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
   			mc.renderEngine.bindTexture(ResourceHelper.icon100);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon111);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.TrapProficient.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon112);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon121);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.ViolinAttack.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon122);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.Shooting.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon123);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon131);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.MissileProficient.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon132);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.JavelinOfLouis.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon133);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon141);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.OtherWorldPerception.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon142);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.Nightvision.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon143);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
       
   }
   
   @Override
	protected void actionPerformed(GuiButton button) {
	   if (button == btnSkill100) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.HuntingRhythm.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.HuntingRhythm.id));
		   }
	   } else if (button == btnSkill111) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.TrapProficient.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.TrapProficient.id));
		   }
	   } else if (button == btnSkill112) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.BloodTrap.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.BloodTrap.id));
		   }
	   } else if (button == btnSkill121) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.ViolinAttack.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.ViolinAttack.id));
		   }
	   } else if (button == btnSkill122) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.Shooting.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.Shooting.id));
		   }
	   } else if (button == btnSkill123) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.Cream_KagariCannon.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.Cream_KagariCannon.id));
		   }
	   } else if (button == btnSkill131) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.MissileProficient.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.MissileProficient.id));
		   }
	   } else if (button == btnSkill132) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.JavelinOfLouis.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.JavelinOfLouis.id));
		   }
	   } else if (button == btnSkill133) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.DeadlyDictionary.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.DeadlyDictionary.id));
		   }
	   } else if (button == btnSkill141) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.OtherWorldPerception.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.OtherWorldPerception.id));
		   }
	   } else if (button == btnSkill142) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.Nightvision.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.Nightvision.id));
		   }
	   } else if (button == btnSkill143) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.EnergyPointUsage.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.EnergyPointUsage.id));
		   }
	   }
	}
		
	public GuiScreen getThisScreen() {
		return mc.currentScreen;
	}

}
