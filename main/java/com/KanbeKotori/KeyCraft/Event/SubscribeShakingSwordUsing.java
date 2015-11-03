package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import com.KanbeKotori.KeyCraft.Items.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribeShakingSwordUsing {
	
	@SubscribeEvent
	public void ShakingSword_Recycle(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		ItemStack held = null;
		if (player != null) {
			held = player.getHeldItem();
		}
		
		ItemStack itemstack;
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			if ((itemstack = player.inventory.mainInventory[i]) != null) {
				if (itemstack.getItem() == ModItems.ShakingSword) {
					if (itemstack != held) {
						if (!player.worldObj.isRemote) {
							player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
						}
			            player.inventory.mainInventory[i] = new ItemStack(Items.iron_sword, RewriteHelper.getShakingSwordDamage(player));
					}
				}	
			}
		}
	}
	
	@SubscribeEvent
    public void usedShakingSword(EventOnShakingSwordUse event) {
		EntityPlayer player = event.entityPlayer;
		ItemStack itemstack;
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			if ((itemstack = player.inventory.mainInventory[i]) != null) {
				if (itemstack.getItem() == ModItems.ShakingSword) {
					if (!player.worldObj.isRemote) {
						player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
					}
			        player.inventory.mainInventory[i] = new ItemStack(Items.iron_sword, 1, RewriteHelper.getShakingSwordDamage(player));
				}	
			}
		}
    }

}
