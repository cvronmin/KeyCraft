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
import com.KanbeKotori.KeyCraft.Network.RewriteNetwork;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class SubscribeKeyListener {
	
	public static final KeyBinding key_Rewrite = new KeyBinding("Show Rewrite Skill", Keyboard.KEY_K, "KeyCraft Control");
	public static final KeyBinding key_Interact = new KeyBinding("Interact with Items", Keyboard.KEY_R, "KeyCraft Control");

	@SubscribeEvent
	public void keyListener(KeyInputEvent event) {
		// 玩家打开Rewrite的GUI。
	    if (key_Rewrite.isPressed()) {
	        Minecraft mc = Minecraft.getMinecraft();
	        mc.displayGuiScreen(new GUIRewrite(mc.currentScreen));
	    } else if (key_Interact.isPressed()) {
			RewriteNetwork.rewriteChannel.sendToServer(RewriteNetwork.createUseSkillPacket());
	    	EntityPlayer player = MainHelper.getPlayerCl();
    		ItemStack held = player.getHeldItem();
    		if (held == null) {
    			if (RewriteHelper.hasSkill(player, RewriteHelper.AuroraBlade.id)
    				&& RewriteHelper.getAuroraPoint(player) > 1
    				) {				// 实现玩家Skill312-『欧若拉之刃』的效果。
	    			RewriteHelper.modifyAuroraPoint(player, -1);
	    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraBlade, 1));
	    		} else if (RewriteHelper.hasSkill(player, RewriteHelper.AuroraTrident.id)
	    				   && RewriteHelper.getAuroraPoint(player) > 1
	    				   ) {		// 实现玩家Skill311-『欧若拉三叉戟』的效果。
	    			RewriteHelper.modifyAuroraPoint(player, -1);
	    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.AuroraTrident, 1));
	    		}
	    	} else if (held.getItem() == Items.iron_sword) {	// 实现玩家Skill231-『超振动』的效果。
	    		if (RewriteHelper.hasSkill(player, RewriteHelper.SuperVibration.id)
	    			&& RewriteHelper.getAuroraPoint(player) > 1
	    			) {
	    			RewriteHelper.setShakingSwordDamage(player, held.getItemDamage());
	    			player.setCurrentItemOrArmor(0, new ItemStack(ModItems.ShakingSword, 1));
	    			RewriteHelper.modifyAuroraPoint(player, -1);
	    		}
	    	}
	    }
	}

}
