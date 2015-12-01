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
package com.KanbeKotori.KeyCraft.GUI;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.*;
import com.KanbeKotori.KeyCraft.Network.RewriteNetwork;

import net.minecraft.client.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;

public class GUIRewriteEnsure extends GuiScreen {
	
	private GuiScreen parentScreen;
	private int skillNum;

	private GuiButton btnYes;
	private GuiButton btnCancel;
	
	private EntityPlayer playerCl = MainHelper.getPlayerCl();
	 
    public GUIRewriteEnsure(GuiScreen parent, int num) {
    	parentScreen = parent;
        skillNum = num;
    }

    @Override
    public void initGui() {
    	buttonList.add(btnYes = new GuiButton(0, (int)(width*0.3) - 40, (int)(height*0.7), 80, 20, StatCollector.translateToLocal("keycraft.gui.button.yes")+RewriteHelper.getAuroraRequired(skillNum)));
    	buttonList.add(btnCancel = new GuiButton(1, (int)(width*0.7) - 40, (int)(height*0.7), 80, 20, StatCollector.translateToLocal("keycraft.gui.button.cancel")));
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
    	
    	/**
    	 * 根据技能序号显示对应说明。
    	 * 有的说明是一行，有的是两行。
    	 */
    	if (skillNum == RewriteHelper.AuroraCognition.id) {			// Skill000-欧若拉认知
        	mc.renderEngine.bindTexture(ResourceHelper.icon000);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title000"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro000_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro000_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.HuntingRhythm.id) {	// Skill100-狩猎律动
        	mc.renderEngine.bindTexture(ResourceHelper.icon100);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title100"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro100"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.TrapProficient.id) {	// Skill111-陷阱精通
        	mc.renderEngine.bindTexture(ResourceHelper.icon111);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title111"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro111"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.BloodTrap.id) {	// Skill112-血之陷阱
        	mc.renderEngine.bindTexture(ResourceHelper.icon112);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title112"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro112_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro112_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.MissileProficient.id) {	// Skill131-投掷物精通
        	mc.renderEngine.bindTexture(ResourceHelper.icon131);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title131"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro131"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.JavelinOfLouis.id) {	// Skill132-路易斯之枪
        	mc.renderEngine.bindTexture(ResourceHelper.icon132);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title132"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro132"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.UrgentProtect.id) {	// Skill200-紧急防护
        	mc.renderEngine.bindTexture(ResourceHelper.icon200);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title200"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro200_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro200_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.BattleReadiness.id) {	// Skill211-战斗准备
        	mc.renderEngine.bindTexture(ResourceHelper.icon211);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title211"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro211"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.PhysiqueUp.id) {		// Skill212-体质提升
        	mc.renderEngine.bindTexture(ResourceHelper.icon212);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title212"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro212_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro212_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.FireAttach.id) {		// Skill221-火焰附加
        	mc.renderEngine.bindTexture(ResourceHelper.icon221);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title221"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro221"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.PoisonAttach.id) {		// Skill222-剧毒附加
        	mc.renderEngine.bindTexture(ResourceHelper.icon222);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title222"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro222"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.WitherAttach.id) {		// Skill223-凋零附加
        	mc.renderEngine.bindTexture(ResourceHelper.icon223);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title223"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro223"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.SuperVibration.id) {	// Skill231-超振动
        	mc.renderEngine.bindTexture(ResourceHelper.icon231);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title231"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro231_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro231_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.BruteForce.id) {		// Skill232-蛮力
        	mc.renderEngine.bindTexture(ResourceHelper.icon232);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title232"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro232_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro232_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.ParryProficient.id) {	// Skill233-格挡精通
        	mc.renderEngine.bindTexture(ResourceHelper.icon233);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title233"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro233_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro233_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.LifeSuck.id) {			// Skill241-生命虹吸
        	mc.renderEngine.bindTexture(ResourceHelper.icon241);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title241"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro241"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.PowerDown.id) {		// Skill242-力量削弱
        	mc.renderEngine.bindTexture(ResourceHelper.icon242);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title242"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro242"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.AuroraRob.id) {		// Skill243-欧若拉掠夺
        	mc.renderEngine.bindTexture(ResourceHelper.icon243);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title243"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro243_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro243_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.AuroraControl.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon300);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title300"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro300_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro300_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.AuroraTrident.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon311);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title311"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro311"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.AuroraBlade.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon312);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title312"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro312_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro312_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.FireResist.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon321);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title321"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro321"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.FireResistUp.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon322);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title322"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro322_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro322_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.FireResistMax.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon323);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title323"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro323_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro323_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.CuringFog.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon331);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title331"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro331"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.HealingFog.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon332);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title332"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro332_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro332_2"), width/2, (int)(height*0.6), 0xFFFFFF);    	} else if (skillNum == RewriteHelper.HurtingFog.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon333);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title333"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro333_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro333_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.AuroraActivation.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon341);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title341"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro341"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.AuroraSurge.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon342);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title342"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro342"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.AuroraRegeneration.id) {
        	mc.renderEngine.bindTexture(ResourceHelper.icon343);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title343"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro343_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro343_2"), width/2, (int)(height*0.6), 0xFFFFFF);
        }
        super.drawScreen(par1, par2, par3);
    }
    
    @Override
	protected void actionPerformed(GuiButton button) {
		if (button == btnCancel) {
	        mc.displayGuiScreen(parentScreen);
	    } else if (button == btnYes) {
    		RewriteHelper.learnSkill(playerCl, skillNum);
	        mc.displayGuiScreen(parentScreen);
    	}
	}

}
