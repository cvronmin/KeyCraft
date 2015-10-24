package com.KanbeKotori.KeyCraft.GUI;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIRewrite_Polluting extends GuiScreen {
	
	MainHelper mainhelper = new MainHelper();
	RewriteHelper rwhelper = new RewriteHelper();
	
	public GuiScreen parentScreen;
	
	private GuiButton btnSkill300; //≈∑»Ù¿≠’∆øÿ
	private GuiButton btnSkill311; //≈∑»Ù¿≠÷Æ≤Ê
	private GuiButton btnSkill312; //≈∑»Ù¿≠÷Æ»–
	private GuiButton btnSkill321; //øπª
	private GuiButton btnSkill322; //øπªUP
	private GuiButton btnSkill323; //øπªMAX
	private GuiButton btnSkill331; //øπ±¨’®Õ‚ø«
	private GuiButton btnSkill332; //øπƒß∑®Õ‚ø«
	private GuiButton btnSkill333; //÷’º´”≤ªØÕ‚ø«
	private GuiButton btnSkill341; //≈∑»Ù¿≠º§ªÓ
	private GuiButton btnSkill342; //≈∑»Ù¿≠”ø∂Ø
	private GuiButton btnSkill343; //≈∑»Ù¿≠‘Ÿ…˙
	
	private ResourceLocation bg0 = new ResourceLocation(KeyCraft.MODID, "textures/icons/bg0.png"); 
	private ResourceLocation bg1 = new ResourceLocation(KeyCraft.MODID, "textures/icons/bg1.png"); 
	private ResourceLocation logo = new ResourceLocation(KeyCraft.MODID, "textures/icons/logo.png");
	
	private String playername = mainhelper.getName();
	private EntityPlayer playerSv = mainhelper.getPlayerSv(playername);
	
	public GUIRewrite_Polluting(GuiScreen parent) {
        parentScreen = parent;
	}

	public void initGui() {
		if (rwhelper.getPoint(playerSv, 0)) {
			buttonList.add(btnSkill300 = new GuiButton(300, (int)(width * 0.2 - 16), (int)(height * 0.4), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 300)) {
			buttonList.add(btnSkill311 = new GuiButton(311, (int)(width * 0.2 - 16), (int)(height * 0.55), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 311)) {
			buttonList.add(btnSkill312 = new GuiButton(312, (int)(width * 0.2 - 16), (int)(height * 0.7), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 300)) {
			buttonList.add(btnSkill321 = new GuiButton(321, (int)(width * 0.4 - 16), (int)(height * 0.4), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 321)) {
			buttonList.add(btnSkill322 = new GuiButton(322, (int)(width * 0.4 - 16), (int)(height * 0.55), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 322)) {
			buttonList.add(btnSkill323 = new GuiButton(323, (int)(width * 0.4 - 16), (int)(height * 0.7), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 300)) {
			buttonList.add(btnSkill331 = new GuiButton(331, (int)(width * 0.6 - 16), (int)(height * 0.4), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 331)) {
			buttonList.add(btnSkill332 = new GuiButton(332, (int)(width * 0.6 - 16), (int)(height * 0.55), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 332)) {
			buttonList.add(btnSkill333 = new GuiButton(333, (int)(width * 0.6 - 16), (int)(height * 0.7), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 300)) {
			buttonList.add(btnSkill341 = new GuiButton(341, (int)(width * 0.8 - 16), (int)(height * 0.4), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 341)) {
			buttonList.add(btnSkill342 = new GuiButton(342, (int)(width * 0.8 - 16), (int)(height * 0.55), 32, 32, ""));
		}
		
		if (rwhelper.getPoint(playerSv, 342)) {
			buttonList.add(btnSkill343 = new GuiButton(343, (int)(width * 0.8 - 16), (int)(height * 0.7), 32, 32, ""));
		}
	}

	public void drawScreen(int par1, int par2, float par3) {
   	
		drawDefaultBackground();
        if (rwhelper.getPoint(playerSv, 0)) {
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
        if (rwhelper.getPoint(playerSv, 0)) {
        	point = rwhelper.getAuroraPoint(playerSv) + "";
        } else {
        	point = "???";
        }
   		drawString(fontRendererObj, "Your Aurora Point:" + point, (int)(width*0.5), (int)(height*0.2), 0xFFFFFF);

   		if (rwhelper.getPoint(playerSv, 0)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon300);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 300)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon311);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 311)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon312);
   			func_146110_a((int)(width * 0.2 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (rwhelper.getPoint(playerSv, 300)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon321);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 321)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon322);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 322)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon323);
   			func_146110_a((int)(width * 0.4 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (rwhelper.getPoint(playerSv, 300)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon331);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 331)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon332);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 332)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon333);
   			func_146110_a((int)(width * 0.6 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
   		
   		if (rwhelper.getPoint(playerSv, 300)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon341);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.4), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 341)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon342);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.55), 0, 0, 32, 32, 32, 32);
   		}
   		if (rwhelper.getPoint(playerSv, 342)) {
   			mc.renderEngine.bindTexture(ResourceHelper.icon343);
   			func_146110_a((int)(width * 0.8 - 16), (int)(height * 0.7), 0, 0, 32, 32, 32, 32);
   		}
       
   }
   
   @Override
	protected void actionPerformed(GuiButton button) {
	   
	   if (button == btnSkill300) {
		   if (!rwhelper.getPoint(playerSv, 300)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 300));
		   }
	   } else if (button == btnSkill311) {
		   if (!rwhelper.getPoint(playerSv, 311)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 311));
		   }
	   } else if (button == btnSkill312) {
		   if (!rwhelper.getPoint(playerSv, 312)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 312));
		   }
	   } else if (button == btnSkill321) {
		   if (!rwhelper.getPoint(playerSv, 321)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 321));
		   }
	   } else if (button == btnSkill322) {
		   if (!rwhelper.getPoint(playerSv, 322)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 322));
		   }
	   } else if (button == btnSkill323) {
		   if (!rwhelper.getPoint(playerSv, 323)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 323));
		   }
	   } else if (button == btnSkill331) {
		   if (!rwhelper.getPoint(playerSv, 331)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 331));
		   }
	   } else if (button == btnSkill332) {
		   if (!rwhelper.getPoint(playerSv, 332)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 332));
		   }
	   } else if (button == btnSkill333) {
		   if (!rwhelper.getPoint(playerSv, 333)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 333));
		   }
	   } else if (button == btnSkill341) {
		   if (!rwhelper.getPoint(playerSv, 341)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 341));
		   }
	   } else if (button == btnSkill342) {
		   if (!rwhelper.getPoint(playerSv, 342)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 342));
		   }
	   } else if (button == btnSkill343) {
		   if (!rwhelper.getPoint(playerSv, 343)) {
			   mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 343));
		   }
	   }
	   
	}
		
	public GuiScreen getThisScreen() {
		return mc.currentScreen;
	}

}
