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

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class SubscribeKeyListener {
	
	public static final KeyBinding key_Rewrite = new KeyBinding("Show Rewrite Skill", Keyboard.KEY_K, "KeyCraft Control");
	public static final KeyBinding key_Interact = new KeyBinding("Interact with Items", Keyboard.KEY_R, "KeyCraft Control");
	
	private MainHelper mainhelper = new MainHelper();
	private RewriteHelper rwhelper = new RewriteHelper();

	@SubscribeEvent
	public void keyListener(KeyInputEvent event) {
	    if (key_Rewrite.isPressed()) {
	        Minecraft mc = Minecraft.getMinecraft();
	        mc.displayGuiScreen(new GUIRewrite(mc.currentScreen));
	    } else if (key_Interact.isPressed()) {
	    	EntityPlayer playerSv = mainhelper.getPlayerSv(mainhelper.getName());
    		ItemStack held = playerSv.getHeldItem();
    		if (held == null) {
    			if (rwhelper.getPoint(playerSv, 312) && rwhelper.getAuroraPoint(playerSv) > 1) {
	    			rwhelper.minusAuroraPoint(playerSv, 1);
	    			playerSv.setCurrentItemOrArmor(0, new ItemStack(KeyCraft.PointAuroraBlade, 1));
	    			playerSv.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.callblade")));
	    		} else if (rwhelper.getPoint(playerSv, 311) && rwhelper.getAuroraPoint(playerSv) > 1) {
	    			rwhelper.minusAuroraPoint(playerSv, 1);
	    			playerSv.setCurrentItemOrArmor(0, new ItemStack(KeyCraft.PointAuroraTrident, 1));
	    			playerSv.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.calltrident")));
	    		}
	    	} else if (held.getItem() == Items.iron_sword) {
	    		if (rwhelper.getPoint(playerSv, 231) && rwhelper.getAuroraPoint(playerSv) > 1) {
	    			rwhelper.setShakingSwordDamage(playerSv, held.getItemDamage());
	    			playerSv.setCurrentItemOrArmor(0, new ItemStack(KeyCraft.PointShakingSword, 1));
	    			rwhelper.minusAuroraPoint(playerSv, 1);
	    			playerSv.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.shakingsword")));
	    		}
	    	}
	    }
	}

}
