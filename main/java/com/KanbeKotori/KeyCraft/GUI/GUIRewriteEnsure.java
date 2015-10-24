package com.KanbeKotori.KeyCraft.GUI;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.*;

import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GUIRewriteEnsure extends GuiScreen {
	MainHelper mainhelper = new MainHelper();
	RewriteHelper rwhelper = new RewriteHelper();
	
	private GuiScreen parentScreen;
	private int pointNum;

	private GuiButton btnYes;
	private GuiButton btnCancel;
	
	private String playername = mainhelper.getName();
	private EntityPlayer playerSv = mainhelper.getPlayerSv(playername);
	 
    public GUIRewriteEnsure(GuiScreen parent, int num) {
    	parentScreen = parent;
        pointNum = num;
    }
    
    public void initGui() {
    	buttonList.add(btnYes = new GuiButton(0, (int)(width*0.3) - 40, (int)(height*0.7), 80, 20, "ȷ��"));
    	buttonList.add(btnCancel = new GuiButton(1, (int)(width*0.7) - 40, (int)(height*0.7), 80, 20, "ȡ��"));
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
    	
        switch (pointNum) {
        	case 000:
        		mc.renderEngine.bindTexture(ResourceHelper.icon000);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title000"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro000_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro000_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 200:
        		mc.renderEngine.bindTexture(ResourceHelper.icon200);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title200"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro200_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro200_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 211:
        		mc.renderEngine.bindTexture(ResourceHelper.icon211);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title211"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro211"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 212:
        		mc.renderEngine.bindTexture(ResourceHelper.icon212);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title212"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro212_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro212_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 221:
        		mc.renderEngine.bindTexture(ResourceHelper.icon221);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title221"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro221"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 222:
        		mc.renderEngine.bindTexture(ResourceHelper.icon222);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title222"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro222"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 223:
        		mc.renderEngine.bindTexture(ResourceHelper.icon223);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title223"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro223"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 231:
        		mc.renderEngine.bindTexture(ResourceHelper.icon231);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title231"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro231_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro231_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 232:
        		mc.renderEngine.bindTexture(ResourceHelper.icon232);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title232"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro232"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 233:
        		mc.renderEngine.bindTexture(ResourceHelper.icon233);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title233"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro233_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro233_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 241:
        		mc.renderEngine.bindTexture(ResourceHelper.icon241);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title241"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro241"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 242:
        		mc.renderEngine.bindTexture(ResourceHelper.icon242);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title242"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro242"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 243:
        		mc.renderEngine.bindTexture(ResourceHelper.icon243);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title243"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro243_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro243_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 300:
        		mc.renderEngine.bindTexture(ResourceHelper.icon300);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title300"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro300_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro300_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 311:
        		mc.renderEngine.bindTexture(ResourceHelper.icon311);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title311"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro311"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 312:
        		mc.renderEngine.bindTexture(ResourceHelper.icon312);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title312"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro312_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro312_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 321:
        		mc.renderEngine.bindTexture(ResourceHelper.icon321);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title321"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro321"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 322:
        		mc.renderEngine.bindTexture(ResourceHelper.icon322);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title322"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro322_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro322_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 323:
        		mc.renderEngine.bindTexture(ResourceHelper.icon323);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title323"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro323_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro323_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 331:
        		mc.renderEngine.bindTexture(ResourceHelper.icon331);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title331"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro331"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 332:
        		mc.renderEngine.bindTexture(ResourceHelper.icon332);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title332"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro332"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 333:
        		mc.renderEngine.bindTexture(ResourceHelper.icon333);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title333"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro333_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro333_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	case 341:
        		mc.renderEngine.bindTexture(ResourceHelper.icon341);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title341"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro341"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 342:
        		mc.renderEngine.bindTexture(ResourceHelper.icon342);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title342"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro342"), width/2, (int)(height*0.45), 0xFFFFFF);
        		break;
        	case 343:
        		mc.renderEngine.bindTexture(ResourceHelper.icon343);
        		func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title343"), width/2, (int)(height*0.3), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro343_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        		drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro343_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        		break;
        	default:
        		break;
        }
        super.drawScreen(par1,par2,par3);
    }
    
    @Override
	protected void actionPerformed(GuiButton button) {
		if (button == btnCancel) {
	        mc.displayGuiScreen(parentScreen);
	    } else if (button == btnYes) {
	    	if (pointNum == 000) {
	    		rwhelper.setPoint_First(playerSv);
	    	} else {
	    		if (rwhelper.getAuroraPoint(playerSv) > rwhelper.getAuroraRequired(pointNum)) {
	    			rwhelper.minusAuroraPoint(playerSv, rwhelper.getAuroraRequired(pointNum));
	    			rwhelper.setPoint(playerSv, pointNum, true);
	    		}
	    	}
	        mc.displayGuiScreen(parentScreen);
    	}
	}

}