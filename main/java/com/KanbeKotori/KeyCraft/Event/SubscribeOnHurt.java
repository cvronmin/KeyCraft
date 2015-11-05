package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.*;

public class SubscribeOnHurt {
	
	public long last_Buff_Resistance = 0;
	
	public boolean isCD_Buff_Resistance() {
    	if (System.currentTimeMillis() - last_Buff_Resistance >= 30000) {
    		last_Buff_Resistance = System.currentTimeMillis();
    		return true;
    	}
    	return false;
    }
    
    @SubscribeEvent
    public void OnHurt(LivingHurtEvent event) {
        if(event.entityLiving instanceof EntityPlayer) {
    		EntityPlayer entityPlayer = (EntityPlayer)event.entityLiving;
    		if (RewriteHelper.hasSkill(entityPlayer, RewriteHelper.ParryProficient.id) && entityPlayer.isUsingItem()) {
    			if (entityPlayer.getItemInUse().getItem() instanceof ItemSword) {
    				int level = entityPlayer.getFoodStats().getFoodLevel();
    				if (level >= 1) {
    					event.setCanceled(true);
    					entityPlayer.getFoodStats().setFoodLevel(level - 1);
    				}
    			}
    		}
    	}
    }
    
	@SubscribeEvent
	public void Point_AutoBuffResistance(LivingHurtEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if (event.source.damageType.equals("arrow") || event.source.damageType.equals("mob") || event.source.damageType.equals("player")) {
				if (RewriteHelper.hasSkill(player, RewriteHelper.BattleReadiness.id) && isCD_Buff_Resistance()) {
					player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
					if (!player.worldObj.isRemote) {
						player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.resistance")));
					}
				}
			}
		}
	}

}
