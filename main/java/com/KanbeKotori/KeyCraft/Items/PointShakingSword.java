package com.KanbeKotori.KeyCraft.Items;

import java.util.List;

import com.KanbeKotori.KeyCraft.Event.*;
import com.KanbeKotori.KeyCraft.Helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class PointShakingSword extends ItemSword {
	
	public PointShakingSword() {
		super(ToolMaterialHelper.ShakingSword);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		EntityPlayer player = (EntityPlayer)attacker;
		EventOnShakingSwordUse EventOnShakingSwordUse = new EventOnShakingSwordUse(player);
		MinecraftForge.EVENT_BUS.post(EventOnShakingSwordUse);	
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, int posX, int posY ,int posZ, EntityLivingBase entity) {
		stack.damageItem(0, entity);
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
    }
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int index, boolean isCurrentItem) {
		if (entity instanceof EntityPlayer && !isCurrentItem) {
			EntityPlayer player = (EntityPlayer)entity;
			if (!player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
			}
			player.inventory.mainInventory[index] = new ItemStack(Items.iron_sword, 1, RewriteHelper.getShakingSwordDamage(player));
		}
	}
	
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		player.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword, 1, RewriteHelper.getShakingSwordDamage(player)));
        return false;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro231_1"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro231_2"));
	}

}
