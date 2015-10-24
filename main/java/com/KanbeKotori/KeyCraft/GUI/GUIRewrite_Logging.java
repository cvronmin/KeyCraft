package com.KanbeKotori.KeyCraft.GUI;

import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.*;

public class GUIRewrite_Logging  extends GuiScreen {
	
	MainHelper mainhelper = new MainHelper();
	RewriteHelper rwhelper = new RewriteHelper();
	
	public GuiScreen parentScreen;
	
	private GuiButton btnSkill200; //紧急防护
	private GuiButton btnSkill211; //战斗准备
	private GuiButton btnSkill212; //体质提升
	private GuiButton btnSkill221; //火焰附加
	private GuiButton btnSkill222; //剧毒附加
	private GuiButton btnSkill223; //凋零附加
	private GuiButton btnSkill231; //超振动
	private GuiButton btnSkill232; //蛮力
	private GuiButton btnSkill233; //武器精通
	private GuiButton btnSkill241; //生命虹吸
	private GuiButton btnSkill242; //力量衰弱
	private GuiButton btnSkill243; //欧若拉掠夺
	
	private String playername = mainhelper.getName();
	private EntityPlayer playerSv = mainhelper.getPlayerSv(playername);
	
	public GUIRewrite_Logging(GuiScreen parent) {
        parentScreen = parent;
	}

	public void initGui() {
		if (rwhelper.getPoint(playerSv, 0)) {
			buttonList.add(btnSkill200 = new GuiButton(200, (int)(width * 0.2 - 16), (int)(height * 0.4), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 200)) {
			buttonList.add(btnSkill211 = new GuiButton(211, (int)(width * 0.2 - 16), (int)(height * 0.55), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 211)) {
			buttonList.add(btnSkill212 = new GuiButton(212, (int)(width * 0.2 - 16), (int)(height * 0.7), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 200)) {
			buttonList.add(btnSkill221 = new GuiButton(221, (int)(width * 0.4 - 16), (int)(height * 0.4), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 221)) {
			buttonList.add(btnSkill222 = new GuiButton(222, (int)(width * 0.4 - 16), (int)(height * 0.55), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 222)) {
			buttonList.add(btnSkill223 = new GuiButton(223, (int)(width * 0.4 - 16), (int)(height * 0.7), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 200)) {
			buttonList.add(btnSkill231 = new GuiButton(231, (int)(width * 0.6 - 16), (int)(height * 0.4), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 231)) {
			buttonList.add(btnSkill232 = new GuiButton(232, (int)(width * 0.6 - 16), (int)(height * 0.55), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 232)) {
			buttonList.add(btnSkill233 = new GuiButton(233, (int)(width * 0.6 - 16), (int)(height * 0.7), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 200)) {
			buttonList.add(btnSkill241 = new GuiButton(241, (int)(width * 0.8 - 16), (int)(height * 0.4), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 241)) {
			buttonList.add(btnSkill242 = new GuiButton(242, (int)(width * 0.8 - 16), (int)(height * 0.55), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 242)) {
			buttonList.add(btnSkill243 = new GuiButton(243, (int)(width * 0.8 - 16), (int)(height * 0.7), 32, 32, ""));
		}
	}

	public void drawScreen(int par1, int par2, float par3) {
   	
		drawDefaultBackground();
        if (rwhelper.getPoint(playerSv, 0)) {
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
        if (rwhelper.getPoint(playerSv, 0)) {
        	point = rwhelper.getAuroraPoint(playerSv) + "";
        } else {
        	point = "???";
        }
   		drawString(fontRendererObj, "Your Aurora Point:" + point, (int)(width*0.5), (int)(height*0.2), 0xFFFFFF);

   		if (rwhelper.getPoint(playerSv, 0)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon200);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 200)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon211);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 211)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon212);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (rwhelper.getPoint(playerSv, 200)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon221);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 221)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon222);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 222)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon223);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (rwhelper.getPoint(playerSv, 200)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon231);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 231)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon232);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 232)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon233);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (rwhelper.getPoint(playerSv, 200)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon241);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 241)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon242);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 242)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon243);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
       
   }
   
   @Override
	protected void actionPerformed(GuiButton button) {
	   
	   if (button == btnSkill200) {
		   if (!rwhelper.getPoint(playerSv, 200)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 200));
		   }
	   } else if (button == btnSkill211) {
		   if (!rwhelper.getPoint(playerSv, 211)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 211));
		   }
	   } else if (button == btnSkill212) {
		   if (!rwhelper.getPoint(playerSv, 212)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 212));
		   }
	   } else if (button == btnSkill221) {
		   if (!rwhelper.getPoint(playerSv, 221)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 221));
		   }
	   } else if (button == btnSkill222) {
		   if (!rwhelper.getPoint(playerSv, 222)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 222));
		   }
	   } else if (button == btnSkill223) {
		   if (!rwhelper.getPoint(playerSv, 223)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 223));
		   }
	   } else if (button == btnSkill231) {
		   if (!rwhelper.getPoint(playerSv, 231)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 231));
		   }
	   } else if (button == btnSkill232) {
		   if (!rwhelper.getPoint(playerSv, 232)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 232));
		   }
	   } else if (button == btnSkill233) {
		   if (!rwhelper.getPoint(playerSv, 233)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 233));
		   }
	   } else if (button == btnSkill241) {
		   if (!rwhelper.getPoint(playerSv, 241)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 241));
		   }
	   } else if (button == btnSkill242) {
		   if (!rwhelper.getPoint(playerSv, 242)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 242));
		   }
	   } else if (button == btnSkill243) {
		   if (!rwhelper.getPoint(playerSv, 243)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 243));
		   }
	   }
	   
	}
		
	public GuiScreen getThisScreen() {
		return mc.currentScreen;
	}

}
