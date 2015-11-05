package com.KanbeKotori.KeyCraft.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.*;


public class GUIRewrite extends GuiScreen {
	
	public GuiScreen parentScreen;

	private GuiButton btnSkill000;
	private GuiButton btnSkillHunting;
	private GuiButton btnSkillLogging;
	private GuiButton btnSkillPolluting;
	
	private EntityPlayer playerCl = MainHelper.getPlayerCl();
	 
    public GUIRewrite(GuiScreen parent) {
         parentScreen = parent;
    }

    @Override
    public void initGui() {
    	if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
    		buttonList.add(btnSkill000 = new GuiButton(0, (int)(width * 0.5 - 32), (int)(height*0.4), 64, 64, ""));
    	} else {
    		buttonList.add(btnSkillHunting = new GuiButton(1, (int)(width * 0.25 - 32), (int)(height*0.4), 64, 64, ""));
    		buttonList.add(btnSkillLogging = new GuiButton(2, (int)(width * 0.5 - 32), (int)(height*0.4), 64, 64, ""));    	
    		buttonList.add(btnSkillPolluting = new GuiButton(3, (int)(width * 0.75 - 32), (int)(height*0.4), 64, 64, ""));    	
    	}
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

        if (!RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon000);
    		func_146110_a((int)(width * 0.5 - 32), (int)(height * 0.4), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.category.title0"), (int)(width * 0.5), (int)(height * 0.7), 0xFFFFFF);
        }
        if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
        	mc.renderEngine.bindTexture(ResourceHelper.category1);
        	func_146110_a((int)(width * 0.25 - 32), (int)(height * 0.4), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.category.title1"), (int)(width * 0.25), (int)(height * 0.7), 0xFFFFFF);
        }
        if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
        	mc.renderEngine.bindTexture(ResourceHelper.category2);
        	func_146110_a((int)(width * 0.5 - 32), (int)(height * 0.4), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.category.title2"), (int)(width * 0.5), (int)(height * 0.7), 0xFFFFFF);
        }
        if (RewriteHelper.hasSkill(playerCl, RewriteHelper.AuroraCognition.id)) {
        	mc.renderEngine.bindTexture(ResourceHelper.category3);
        	func_146110_a((int)(width * 0.75 - 32), (int)(height * 0.4), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.category.title3"), (int)(width * 0.75), (int)(height * 0.7), 0xFFFFFF);
        }
        
    }
    
    @Override
	protected void actionPerformed(GuiButton button) {
		if (button == btnSkill000) {
	    	if (!RewriteHelper.hasInitialized(playerCl)) {
	    		mc.displayGuiScreen(new GUIRewriteEnsure(getThisScreen(), RewriteHelper.AuroraCognition.id));
	    	}
    	} else if (button == btnSkillHunting) {
    		mc.displayGuiScreen(new GUIRewrite_Hunting(getThisScreen()));
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
