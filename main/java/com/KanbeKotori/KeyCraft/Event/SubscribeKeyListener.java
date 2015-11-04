package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.GUI.*;
import com.KanbeKotori.KeyCraft.Helper.*;
import com.KanbeKotori.KeyCraft.Items.ModItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class SubscribeKeyListener {
	
	public static final KeyBinding key_Rewrite = new KeyBinding("Show Rewrite Skill", Keyboard.KEY_K, "KeyCraft Control");
	public static final KeyBinding key_Interact = new KeyBinding("Interact with Items", Keyboard.KEY_R, "KeyCraft Control");

	@SubscribeEvent
	public void keyListener(KeyInputEvent event) {
	    if (key_Rewrite.isPressed()) {
	    	if (MainHelper.getPlayerSv() == null) {
	    		System.out.println("MainHelper.getPlayerSv() == null");
	    		return;
	    	}
	        Minecraft mc = Minecraft.getMinecraft();
	        mc.displayGuiScreen(new GUIRewrite(mc.currentScreen));
	    } else if (key_Interact.isPressed()) {
	    	EntityPlayer playerSv = MainHelper.getPlayerSv();
	    	if (playerSv == null) {
	    		System.out.println("playerSv == null");
	    		return;
	    	}
    		ItemStack held = playerSv.getHeldItem();
    		if (held == null) {
    			if (RewriteHelper.getPoint(playerSv, RewriteHelper.AuroraBlade.id) && RewriteHelper.getAuroraPoint(playerSv) > 1) {
	    			RewriteHelper.minusAuroraPoint(playerSv, 1);
	    			playerSv.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraBlade, 1));
	    			playerSv.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.callblade")));
	    		} else if (RewriteHelper.getPoint(playerSv, RewriteHelper.AuroraTrident.id) && RewriteHelper.getAuroraPoint(playerSv) > 1) {
	    			RewriteHelper.minusAuroraPoint(playerSv, 1);
	    			playerSv.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraTrident, 1));
	    			playerSv.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.calltrident")));
	    		}
	    	} else if (held.getItem() == Items.iron_sword) {
	    		if (RewriteHelper.getPoint(playerSv, RewriteHelper.SuperVibration.id) && RewriteHelper.getAuroraPoint(playerSv) > 1) {
	    			RewriteHelper.setShakingSwordDamage(playerSv, held.getItemDamage());
	    			playerSv.setCurrentItemOrArmor(0, new ItemStack(ModItems.ShakingSword, 1));
	    			RewriteHelper.minusAuroraPoint(playerSv, 1);
	    			playerSv.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.shakingsword")));
	    		}
	    	}
	    }
	}

}
