package com.KanbeKotori.KeyCraft.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.*;


public class GUIRewrite extends GuiScreen {
	
	MainHelper mainhelper = new MainHelper();
	RewriteHelper rwhelper = new RewriteHelper();
	
	public GuiScreen parentScreen;

	private GuiButton btnSkill000;
	private GuiButton btnSkillHunting;
	private GuiButton btnSkillLogging;
	private GuiButton btnSkillPolluting;
	
	private String playername = mainhelper.getName();
	private EntityPlayer playerSv = mainhelper.getPlayerSv(playername);
	 
    public GUIRewrite(GuiScreen parent) {
         parentScreen = parent;
    }
 
    public void initGui() {
    	if (!rwhelper.getPoint(playerSv, 0)) {
    		buttonList.add(btnSkill000 = new GuiButton(0, (int)(width * 0.5 - 32), (int)(height*0.4), 64, 64, ""));
    	}
    	if (rwhelper.getPoint(playerSv, 0)) {
    		buttonList.add(btnSkillHunting = new GuiButton(1, (int)(width * 0.25 - 32), (int)(height*0.4), 64, 64, ""));
    		buttonList.add(btnSkillLogging = new GuiButton(2, (int)(width * 0.5 - 32), (int)(height*0.4), 64, 64, ""));    	
    		buttonList.add(btnSkillPolluting = new GuiButton(3, (int)(width * 0.75 - 32), (int)(height*0.4), 64, 64, ""));    	
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

        if (!rwhelper.getPoint(playerSv, 0)) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon000);
    		func_146110_a((int)(width * 0.5 - 32), (int)(height * 0.4), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.category.title0"), (int)(width * 0.5), (int)(height * 0.7), 0xFFFFFF);
        }
        if (rwhelper.getPoint(playerSv, 0)) {
        	mc.renderEngine.bindTexture(ResourceHelper.category1);
        	func_146110_a((int)(width * 0.25 - 32), (int)(height * 0.4), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.category.title1"), (int)(width * 0.25), (int)(height * 0.7), 0xFFFFFF);
        }
        if (rwhelper.getPoint(playerSv, 0)) {
        	mc.renderEngine.bindTexture(ResourceHelper.category2);
        	func_146110_a((int)(width * 0.5 - 32), (int)(height * 0.4), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.category.title2"), (int)(width * 0.5), (int)(height * 0.7), 0xFFFFFF);
        }
        if (rwhelper.getPoint(playerSv, 0)) {
        	mc.renderEngine.bindTexture(ResourceHelper.category3);
        	func_146110_a((int)(width * 0.75 - 32), (int)(height * 0.4), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.category.title3"), (int)(width * 0.75), (int)(height * 0.7), 0xFFFFFF);
        }
        
    }
    
    @Override
	protected void actionPerformed(GuiButton button) {
		if (button == btnSkill000) {
	    	if (!rwhelper.hasFirstSet(playerSv)) {
	    		mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), 000));
	    	}
    	} else if (button == btnSkillHunting) {
    		
	    } else if (button == btnSkillLogging) {
	    	mc.displayGuiScreen(new GUIRewrite_Logging(getThisScreen()));
	    } else if (button == btnSkillPolluting) {
	    	mc.displayGuiScreen(new GUIRewrite_Polluting(getThisScreen()));
	    }
	}
    
    protected void Refresh() {
        mc.displayGuiScreen(new GUIRewrite(this.parentScreen));
    }
    
    public GuiScreen getParentScreen() {
    	return this.parentScreen;
    }
    
    public GUIRewrite getThisScreen() {
    	return (GUIRewrite) mc.currentScreen;
    }
    

}