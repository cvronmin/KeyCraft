package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.living.*;

public class SubscribeOnBlock {
    
    @SubscribeEvent
    public void Block_HandSonic(LivingHurtEvent event) {
        if(event.entityLiving instanceof EntityPlayer) {
    		EntityPlayer entityPlayer = (EntityPlayer)event.entityLiving;
    		if (RewriteHelper.getPoint(entityPlayer, 233) && entityPlayer.isUsingItem()) {
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

}
