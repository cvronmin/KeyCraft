package com.KanbeKotori.KeyCraft.Event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import com.KanbeKotori.KeyCraft.Helper.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribePointAutoBuff {
	
	private MainHelper mainhelper = new MainHelper();
	private RewriteHelper rwhelper = new RewriteHelper();
	public long last_Buff_ER = 0;
	public long last_Buff_Resistance = 0;
	public long last_Buff_MoreHealth = 0;
	public long last_Buff_Power = 0;
	public long last_Buff_Heal = 0;
	public long last_Buff_Burst = 0;
	
	public boolean isCD_Buff_ER() {
    	if (System.currentTimeMillis() - last_Buff_ER >= 300000) {
    		last_Buff_ER = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_Buff_Power() {
    	if (System.currentTimeMillis() - last_Buff_Power >= 30000) {
    		last_Buff_Power = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_Buff_Resistance() {
    	if (System.currentTimeMillis() - last_Buff_Resistance >= 30000) {
    		last_Buff_Resistance = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_Buff_MoreHealth() {
    	if (System.currentTimeMillis() - last_Buff_MoreHealth >= 2147483647) {
    		last_Buff_MoreHealth = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_Buff_Heal() {
    	if (System.currentTimeMillis() - last_Buff_Heal >= 3000) {
    		last_Buff_Heal = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	public boolean isCD_Buff_Burst() {
    	if (System.currentTimeMillis() - last_Buff_Burst >= 3000) {
    		last_Buff_Burst = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
	
	@SubscribeEvent
	public void Point_ER(PlayerTickEvent event) {
		EntityPlayer player = mainhelper.getPlayerSv(mainhelper.getName());
		
		if (rwhelper.getPoint(player, 200) && player.getHealth() <= 6 && rwhelper.getAuroraPoint(player) > 5) {
			if (isCD_Buff_ER()) {
			rwhelper.minusAuroraPoint(player, 5);
			player.addPotionEffect(new PotionEffect(1, 200, 1));
			player.addPotionEffect(new PotionEffect(10, 200, 4));
			player.addPotionEffect(new PotionEffect(11, 200, 1));
    		player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.er")));
			}
		}
	
	}
	
	@SubscribeEvent
	public void Point_MoreHealth(PlayerTickEvent event) {
		EntityPlayer player = mainhelper.getPlayerSv(mainhelper.getName());
		
		if (rwhelper.getPoint(player, 212) && isCD_Buff_MoreHealth()) {
			player.addPotionEffect(new PotionEffect(21, 2147483647, 4));
		}
	
	}
	
	@SubscribeEvent
	public void Point_AutoBuffResistance(LivingAttackEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = mainhelper.getPlayerSv(mainhelper.getName());
			if (event.source.damageType == "arrow" || event.source.damageType == "mob"|| event.source.damageType == "player") {
				if (rwhelper.getPoint(player, 211) && isCD_Buff_Resistance()) {
					player.addPotionEffect(new PotionEffect(11, 400, 1));
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.resistance")));
				}
			}
		}
	
	}
	
	@SubscribeEvent
	public void Point_AutoBuffPower(LivingAttackEvent event) {
		if (event.source.damageType == "arrow") {
			EntityPlayer player = mainhelper.getPlayerSv(mainhelper.getName());
			if (rwhelper.getPoint(player, 232) && isCD_Buff_Power()) {
				player.addPotionEffect(new PotionEffect(5, 400, 1));
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.power")));
			}
		}
	
	}
	
	@SubscribeEvent
	public void Point_AutoHeal(PlayerTickEvent event) {
		EntityPlayer player = mainhelper.getPlayerSv(mainhelper.getName());
		if (player.getHealth() < 20) {
			if (rwhelper.getPoint(player, 342) && isCD_Buff_Heal()) {
				player.addPotionEffect(new PotionEffect(10, 80, 1));
			} else if (rwhelper.getPoint(player, 341) && isCD_Buff_Heal()) {
				player.addPotionEffect(new PotionEffect(10, 80));
			}
		}
	
	}
	
	@SubscribeEvent
	public void Point_Burst(PlayerTickEvent event) {
		EntityPlayer player = mainhelper.getPlayerSv(mainhelper.getName());
		
		if (rwhelper.getPoint(player, 323) && rwhelper.getPoint(player, 333) && rwhelper.getPoint(player, 343) && isCD_Buff_Burst()) {
			player.addPotionEffect(new PotionEffect(1, 80, 255));
			player.addPotionEffect(new PotionEffect(8, 80, 99));
		}
	
	}

}
