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
package com.kanbekotori.keycraft.gui;

import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;

import com.kanbekotori.keycraft.KeyCraft;
import com.kanbekotori.keycraft.helper.*;

public class GUIRewrite_Logging  extends GuiScreen {
	
	public GuiScreen parentScreen;
	
	private GuiButton btnSkill200; // 紧急防护
	private GuiButton btnSkill211; // 战斗准备
	private GuiButton btnSkill212; // 体质提升
	private GuiButton btnSkill221; // 火焰附加
	private GuiButton btnSkill222; // 剧毒附加
	private GuiButton btnSkill223; // 凋零附加
	private GuiButton btnSkill231; // 超振动
	private GuiButton btnSkill232; // 蛮力
	private GuiButton btnSkill233; // 格挡精通
	private GuiButton btnSkill241; // 生命虹吸
	private GuiButton btnSkill242; // 力量削弱
	private GuiButton btnSkill243; // 欧若拉掠夺
	
	private EntityPlayer playerCl = MainHelper.getPlayerCl();
	
	public GUIRewrite_Logging(GuiScreen parent) {
        parentScreen = parent;
	}

    @Override
	public void initGui() {
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id))
			buttonList.add(btnSkill200 = new GuiButton(RewriteHelper.UrgentProtect.id, (int)(width * 0.2 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id))
			buttonList.add(btnSkill211 = new GuiButton(RewriteHelper.BattleReadiness.id, (int)(width * 0.2 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.BattleReadiness.id))
			buttonList.add(btnSkill212 = new GuiButton(RewriteHelper.PhysiqueUp.id, (int)(width * 0.2 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id))
			buttonList.add(btnSkill221 = new GuiButton(RewriteHelper.FireAttach.id, (int)(width * 0.4 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.FireAttach.id))
			buttonList.add(btnSkill222 = new GuiButton(RewriteHelper.PoisonAttach.id, (int)(width * 0.4 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.PoisonAttach.id))
			buttonList.add(btnSkill223 = new GuiButton(RewriteHelper.WitherAttach.id, (int)(width * 0.4 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id))
			buttonList.add(btnSkill231 = new GuiButton(RewriteHelper.SuperVibration.id, (int)(width * 0.6 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.SuperVibration.id))
			buttonList.add(btnSkill232 = new GuiButton(RewriteHelper.BruteForce.id, (int)(width * 0.6 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.BruteForce.id))
			buttonList.add(btnSkill233 = new GuiButton(RewriteHelper.ParryProficient.id, (int)(width * 0.6 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id))
			buttonList.add(btnSkill241 = new GuiButton(RewriteHelper.LifeSuck.id, (int)(width * 0.8 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.LifeSuck.id))
			buttonList.add(btnSkill242 = new GuiButton(RewriteHelper.PowerDown.id, (int)(width * 0.8 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.PowerDown.id))
			buttonList.add(btnSkill243 = new GuiButton(RewriteHelper.AuroraRob.id, (int)(width * 0.8 - 16), (int)(height * 0.7), 32, 32, ""));
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
   			mc.renderEngine.bindTexture(ResourceHelper.icon200);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon211);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.BattleReadiness.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon212);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon221);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.FireAttach.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon222);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.PoisonAttach.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon223);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon231);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.SuperVibration.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon232);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.BruteForce.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon233);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon241);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.LifeSuck.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon242);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.PowerDown.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon243);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
       
   }
   
   @Override
	protected void actionPerformed(GuiButton button) {
	   if (button == btnSkill200) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.UrgentProtect.id));
		   }
	   } else if (button == btnSkill211) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.BattleReadiness.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.BattleReadiness.id));
		   }
	   } else if (button == btnSkill212) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.PhysiqueUp.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.PhysiqueUp.id));
		   }
	   } else if (button == btnSkill221) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.FireAttach.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.FireAttach.id));
		   }
	   } else if (button == btnSkill222) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.PoisonAttach.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.PoisonAttach.id));
		   }
	   } else if (button == btnSkill223) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.WitherAttach.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.WitherAttach.id));
		   }
	   } else if (button == btnSkill231) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.SuperVibration.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.SuperVibration.id));
		   }
	   } else if (button == btnSkill232) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.BruteForce.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.BruteForce.id));
		   }
	   } else if (button == btnSkill233) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.ParryProficient.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.ParryProficient.id));
		   }
	   } else if (button == btnSkill241) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.LifeSuck.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.LifeSuck.id));
		   }
	   } else if (button == btnSkill242) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.PowerDown.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.PowerDown.id));
		   }
	   } else if (button == btnSkill243) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraRob.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraRob.id));
		   }
	   }
	}
		
	public GuiScreen getThisScreen() {
		return mc.currentScreen;
	}

}
