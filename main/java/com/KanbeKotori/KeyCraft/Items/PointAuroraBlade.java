package com.KanbeKotori.KeyCraft.Items;

import java.util.HashSet;
import java.util.List;

import com.KanbeKotori.KeyCraft.Event.*;
import com.KanbeKotori.KeyCraft.Helper.*;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class PointAuroraBlade extends ItemTool {
	
	public static final HashSet<String> HARVESTABLE = Sets.newHashSet("axe", "pickaxe", "shovel");
	
	public PointAuroraBlade() {
		super(4.0f, ToolMaterialHelper.Aurora2, new HashSet());
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		 if (HARVESTABLE.contains(block.getHarvestTool(meta))) {
			 return efficiencyOnProperMaterial;
		 } else {
			 return super.getDigSpeed(stack, block, meta);
		 }
		 
	 }
	 
	 @Override
	 public boolean canHarvestBlock(Block block, ItemStack itemStack) {
		 if (HARVESTABLE.contains(block.getHarvestTool(0))) {
			 return true;
		 } else {
			 return super.canHarvestBlock(block, itemStack);
		 }
	 }
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (stack.getItemDamage() >= 64) {
			EntityPlayer player = (EntityPlayer)attacker;
			World world = player.getEntityWorld();
			if(!world.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.breakblade")));
				EventOnAuroraBreak EventOnAuroraBreak = new EventOnAuroraBreak(player);
	            MinecraftForge.EVENT_BUS.post(EventOnAuroraBreak);
		    }	
		}
		
		stack.damageItem(1, attacker);
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, int posX, int posY ,int posZ, EntityLivingBase entity) {
		if(worldIn.isRemote) {
	        return true;
	    }
		
		if (stack.getItemDamage() >= 64) {
			EntityPlayer player = (EntityPlayer)entity;
			World world = player.getEntityWorld();
			if(!world.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.breakblade")));
				EventOnAuroraBreak EventOnAuroraBreak = new EventOnAuroraBreak(player);
	            MinecraftForge.EVENT_BUS.post(EventOnAuroraBreak);
		    }	
		}
		
		stack.damageItem(1, entity);
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        player.setItemInUse(stack, 72000);
        return stack;
    }
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.block;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro2_1"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro2_2"));
	}
	
	@SubscribeEvent
    public void brokenAurora(EventOnAuroraBreak event) {
		EntityPlayer attacker = event.entityPlayer;
        attacker.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 6000, 1));
        attacker.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 6000, 3));
        attacker.addPotionEffect(new PotionEffect(Potion.confusion.id, 6000));
        attacker.addPotionEffect(new PotionEffect(Potion.weakness.id, 6000, 3));
    }

}
