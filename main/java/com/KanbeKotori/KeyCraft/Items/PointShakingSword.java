package com.KanbeKotori.KeyCraft.Items;

import java.util.List;

import com.KanbeKotori.KeyCraft.Event.*;
import com.KanbeKotori.KeyCraft.Helper.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

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
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
		p_77624_3_.add(StatCollector.translateToLocal("keycraft.item.intro231_1"));
		p_77624_3_.add(StatCollector.translateToLocal("keycraft.item.intro231_2"));
	}

}
