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

	/** 判断Skill211-『战斗准备』是否已经CD，但是不会同步，死亡或切换世界会重置CD。 */
	public boolean isCD_Buff_Resistance(EntityPlayer player) {
		final long time = player.worldObj.getTotalWorldTime();
    	if (time - player.getEntityData().getLong("LastTime_BattleReadiness") >= 30 * 20) {
    		player.getEntityData().setLong("LastTime_BattleReadiness", time);
			if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.resistance")));
			}
    		return true;
    	}
    	return false;
    }

	/** 玩家因为Skill233-『格挡精通』而免除某些伤害 */
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
    
    /** 玩家因为Skill211-『战斗准备』而加buff */
	@SubscribeEvent
	public void Point_AutoBuffResistance(LivingHurtEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if (event.source.damageType.equals("arrow") || event.source.damageType.equals("mob") || event.source.damageType.equals("player")) {
				if (RewriteHelper.hasSkill(player, RewriteHelper.BattleReadiness.id) && isCD_Buff_Resistance(player)) {
					player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
				}
			}
		}
	}

}
