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
import com.kanbekotori.keycraft.network.RewriteNetwork;

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
    	 * ���ݼ��������ʾ��Ӧ˵����
    	 * �е�˵����һ�У��е������С�
    	 */
    	if (skillNum == RewriteHelper.AuroraCognition.id) {			// Skill000-ŷ������֪
        	mc.renderEngine.bindTexture(ResourceHelper.icon000);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title000"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro000_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro000_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.HuntingRhythm.id) {	// Skill100-�����ɶ�
        	mc.renderEngine.bindTexture(ResourceHelper.icon100);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title100"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro100"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.TrapProficient.id) {	// Skill111-���徫ͨ
        	mc.renderEngine.bindTexture(ResourceHelper.icon111);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title111"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro111"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.BloodTrap.id) {	// Skill112-Ѫ֮����
        	mc.renderEngine.bindTexture(ResourceHelper.icon112);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title112"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro112_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro112_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.ViolinAttack.id) {	// Skill121-С���ٹ���
        	mc.renderEngine.bindTexture(ResourceHelper.icon121);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title121"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro121"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.Shooting.id) {	// Skill122-�������
        	mc.renderEngine.bindTexture(ResourceHelper.icon122);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title122"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro122"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.Cream_KagariCannon.id) {	// Skill123-���͡������Ĵ���
        	mc.renderEngine.bindTexture(ResourceHelper.icon123);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title123"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro123"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.MissileProficient.id) {	// Skill131-Ͷ���ﾫͨ
        	mc.renderEngine.bindTexture(ResourceHelper.icon131);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title131"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro131"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.JavelinOfLouis.id) {	// Skill132-·��˹֮ǹ
        	mc.renderEngine.bindTexture(ResourceHelper.icon132);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title132"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro132"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.DeadlyDictionary.id) {	// Skill133-�����ֵ�
        	mc.renderEngine.bindTexture(ResourceHelper.icon133);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title133"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro133"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.OtherWorldPerception.id) {	// Skill141-�������֪
        	mc.renderEngine.bindTexture(ResourceHelper.icon141);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title141"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro141_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro141_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.Nightvision.id) {	// Skill142-ҹ��
        	mc.renderEngine.bindTexture(ResourceHelper.icon142);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title142"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro142"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.EnergyPointUsage.id) {	// Skill143-����������
        	mc.renderEngine.bindTexture(ResourceHelper.icon143);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title143"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro143"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.UrgentProtect.id) {	// Skill200-��������
        	mc.renderEngine.bindTexture(ResourceHelper.icon200);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title200"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro200_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro200_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.BattleReadiness.id) {	// Skill211-ս��׼��
        	mc.renderEngine.bindTexture(ResourceHelper.icon211);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title211"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro211"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.PhysiqueUp.id) {		// Skill212-��������
        	mc.renderEngine.bindTexture(ResourceHelper.icon212);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title212"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro212_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro212_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.FireAttach.id) {		// Skill221-���渽��
        	mc.renderEngine.bindTexture(ResourceHelper.icon221);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title221"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro221"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.PoisonAttach.id) {		// Skill222-�綾����
        	mc.renderEngine.bindTexture(ResourceHelper.icon222);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title222"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro222"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.WitherAttach.id) {		// Skill223-���㸽��
        	mc.renderEngine.bindTexture(ResourceHelper.icon223);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title223"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro223"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.SuperVibration.id) {	// Skill231-����
        	mc.renderEngine.bindTexture(ResourceHelper.icon231);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title231"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro231_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro231_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.BruteForce.id) {		// Skill232-����
        	mc.renderEngine.bindTexture(ResourceHelper.icon232);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title232"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro232_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro232_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.ParryProficient.id) {	// Skill233-�񵲾�ͨ
        	mc.renderEngine.bindTexture(ResourceHelper.icon233);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title233"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro233_1"), width/2, (int)(height*0.45), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro233_2"), width/2, (int)(height*0.6), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.LifeSuck.id) {			// Skill241-��������
        	mc.renderEngine.bindTexture(ResourceHelper.icon241);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title241"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro241"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.PowerDown.id) {		// Skill242-��������
        	mc.renderEngine.bindTexture(ResourceHelper.icon242);
        	func_146110_a((int)(width * 0.7 - 32), (int)(height * 0.1), 0, 0, 64, 64, 64, 64);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.title242"), width/2, (int)(height*0.3), 0xFFFFFF);
        	drawCenteredString(fontRendererObj, StatCollector.translateToLocal("keycraft.gui.ensure.intro242"), width/2, (int)(height*0.45), 0xFFFFFF);
    	} else if (skillNum == RewriteHelper.AuroraRob.id) {		// Skill243-ŷ�����Ӷ�
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
