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
	
	/** 玩家在使用Skill231-『超振动』后将铁剑返还给玩家 */
	@SubscribeEvent
    public void usedShakingSword(EventOnShakingSwordUse event) {
		EntityPlayer player = event.entityPlayer;
		if (!player.worldObj.isRemote) {
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
		}
		player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword, 1, RewriteHelper.getShakingSwordDamage(player)));
    }

}
