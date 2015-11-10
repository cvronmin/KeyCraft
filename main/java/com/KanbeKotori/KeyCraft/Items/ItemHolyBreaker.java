package com.KanbeKotori.KeyCraft.Items;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.KanbeKotori.KeyCraft.Helper.*;
import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemHolyBreaker extends ItemTool {
public static final HashSet<String> HARVESTABLE = Sets.newHashSet("axe", "pickaxe", "shovel");
	
	public ItemHolyBreaker() {
		super(4.0f, ToolMaterialHelper.HolyBreaker, new HashSet());
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
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
			 return true;
	 }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro_holybreaker"));
	}
	
	 /** 10%±©»÷ */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (attacker instanceof EntityPlayer && new Random().nextInt(10) == 5) {
			EntityPlayer player = (EntityPlayer)attacker;
			target.attackEntityFrom(DamageSource.causePlayerDamage(player), 0x7FFFFFFF);
			stack.damageItem(10, attacker);
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.holybreak")));
			return true;
		}
		stack.damageItem(2, attacker);
		return true;
	}

}
