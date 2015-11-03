package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.*;
import com.KanbeKotori.KeyCraft.Items.ModItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribeAuroraRecycle {
	
	@SubscribeEvent
	public void Aurora_Recycle(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		ItemStack held = player.getHeldItem();
		
		ItemStack itemstack;
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			if ((itemstack = player.inventory.mainInventory[i]) != null) {
				if (itemstack.getItem() == ModItems.AuroraTrident) {
					if (itemstack != held) {
						double pp = (double)itemstack.getItemDamage() / itemstack.getMaxDamage();
						if (!player.worldObj.isRemote) {
							player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.recycletrident")));
						}
						EventOnAuroraRecycle EventOnAuroraRecycle = new EventOnAuroraRecycle(player, pp);
			            MinecraftForge.EVENT_BUS.post(EventOnAuroraRecycle);
			            player.inventory.mainInventory[i] = null;
					}
				} else if (itemstack.getItem() == ModItems.AuroraBlade) {
					if (itemstack != held) {
						double pp = (double)itemstack.getItem().getDamage(itemstack) / itemstack.getMaxDamage();
						if (!player.worldObj.isRemote) {
							player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.recycleblade")));
						}
						EventOnAuroraRecycle EventOnAuroraRecycle = new EventOnAuroraRecycle(player, pp);
			            MinecraftForge.EVENT_BUS.post(EventOnAuroraRecycle);
			            player.inventory.mainInventory[i] = null;
					}
				}	
			}
		}
		
	}
	
	@SubscribeEvent
	public void Aurora_Recycle(EventOnAuroraRecycle event) {
		EntityPlayer player = event.entityPlayer;
		if (event.proportion == 0) {
			if (player.worldObj.isRemote) {
				RewriteHelper.addAuroraPoint(player, 1);
			}
		} else {
			if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.recyclerate") + event.proportion));
			}
			int time = (int)(6000 * event.proportion);
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, time, 1));
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, time, 3));
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, time));
			player.addPotionEffect(new PotionEffect(Potion.weakness.id, time, 3));
		}
	}

}
