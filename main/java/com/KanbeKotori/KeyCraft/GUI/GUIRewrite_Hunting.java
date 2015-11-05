package com.KanbeKotori.KeyCraft.GUI;

import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.*;

public class GUIRewrite_Hunting extends GuiScreen {
	
	public GuiScreen parentScreen;
	
	private GuiButton btnSkill100; // 
	private GuiButton btnSkill111; // 
	private GuiButton btnSkill112; // 
	private GuiButton btnSkill121; // 
	private GuiButton btnSkill122; // 
	private GuiButton btnSkill123; // 
	private GuiButton btnSkill131; //
	private GuiButton btnSkill132; // 
	private GuiButton btnSkill133; // 
	private GuiButton btnSkill141; // 
	private GuiButton btnSkill142; // 
	private GuiButton btnSkill143; // 
	
	private EntityPlayer playerCl = MainHelper.getPlayerCl();
	
	public GUIRewrite_Hunting(GuiScreen parent) {
        parentScreen = parent;
	}

    @Override
	public void initGui() {
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id))
			buttonList.add(btnSkill100 = new GuiButton(RewriteHelper.UrgentProtect.id, (int)(width * 0.2 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id))
			buttonList.add(btnSkill111 = new GuiButton(RewriteHelper.BattleReadiness.id, (int)(width * 0.2 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.BattleReadiness.id))
			buttonList.add(btnSkill112 = new GuiButton(RewriteHelper.PhysiqueUp.id, (int)(width * 0.2 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id))
			buttonList.add(btnSkill121 = new GuiButton(RewriteHelper.FireAttach.id, (int)(width * 0.4 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.FireAttach.id))
			buttonList.add(btnSkill122 = new GuiButton(RewriteHelper.PoisonAttach.id, (int)(width * 0.4 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.PoisonAttach.id))
			buttonList.add(btnSkill123 = new GuiButton(RewriteHelper.WitherAttach.id, (int)(width * 0.4 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id))
			buttonList.add(btnSkill131 = new GuiButton(RewriteHelper.SuperVibration.id, (int)(width * 0.6 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.SuperVibration.id))
			buttonList.add(btnSkill132 = new GuiButton(RewriteHelper.BruteForce.id, (int)(width * 0.6 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.BruteForce.id))
			buttonList.add(btnSkill133 = new GuiButton(RewriteHelper.ParryProficient.id, (int)(width * 0.6 - 16), (int)(height * 0.7), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id))
			buttonList.add(btnSkill141 = new GuiButton(RewriteHelper.LifeSuck.id, (int)(width * 0.8 - 16), (int)(height * 0.4), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.LifeSuck.id))
			buttonList.add(btnSkill142 = new GuiButton(RewriteHelper.PowerDown.id, (int)(width * 0.8 - 16), (int)(height * 0.55), 32, 32, ""));
		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.PowerDown.id))
			buttonList.add(btnSkill143 = new GuiButton(RewriteHelper.AuroraRob.id, (int)(width * 0.8 - 16), (int)(height * 0.7), 32, 32, ""));
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
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon111);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.BattleReadiness.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon112);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon121);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.FireAttach.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon122);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.PoisonAttach.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon123);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon131);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.SuperVibration.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon132);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.BruteForce.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon133);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon141);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.LifeSuck.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon142);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (RewriteHelper.hasSkill(playerCl, RewriteHelper.PowerDown.id)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon143);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
       
   }
   
   @Override
	protected void actionPerformed(GuiButton button) {
	   if (button == btnSkill100) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.UrgentProtect.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.UrgentProtect.id));
		   }
	   } else if (button == btnSkill111) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.BattleReadiness.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.BattleReadiness.id));
		   }
	   } else if (button == btnSkill112) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.PhysiqueUp.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.PhysiqueUp.id));
		   }
	   } else if (button == btnSkill121) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.FireAttach.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.FireAttach.id));
		   }
	   } else if (button == btnSkill122) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.PoisonAttach.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.PoisonAttach.id));
		   }
	   } else if (button == btnSkill123) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.WitherAttach.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.WitherAttach.id));
		   }
	   } else if (button == btnSkill131) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.SuperVibration.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.SuperVibration.id));
		   }
	   } else if (button == btnSkill132) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.BruteForce.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.BruteForce.id));
		   }
	   } else if (button == btnSkill133) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.ParryProficient.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.ParryProficient.id));
		   }
	   } else if (button == btnSkill141) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.LifeSuck.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.LifeSuck.id));
		   }
	   } else if (button == btnSkill142) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.PowerDown.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.PowerDown.id));
		   }
	   } else if (button == btnSkill143) {
		   if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraRob.id)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraRob.id));
		   }
	   }
	}
		
	public GuiScreen getThisScreen() {
		return mc.currentScreen;
	}

}
