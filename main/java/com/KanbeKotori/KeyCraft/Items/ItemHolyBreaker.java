/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * 本作品版权由Nulla开发组所有。
 * Developed by Kanbe-Kotori & xfgryujk.
 * 本作品由 Kanbe-Kotori & xfgryujk 合作开发。
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.items;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Sets;
import com.kanbekotori.keycraft.helper.*;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemHolyBreaker extends ItemTool {
public static final HashSet<String> HARVESTABLE = Sets.newHashSet("axe", "pickaxe", "shovel");
	
	public ItemHolyBreaker() {
		super(4.0f, MaterialHelper.HolyBreaker, new HashSet());
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
	
	 /** 10%暴击 */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!attacker.worldObj.isRemote
			&& attacker instanceof EntityPlayer
			&& new Random().nextInt(10) == 5
			){
			EntityPlayer player = (EntityPlayer)attacker;
			target.attackEntityFrom(DamageSource.causePlayerDamage(player), 0x6FFFFFFF);
			stack.damageItem(10, attacker);
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.holybreak")));
			return true;
		}
		stack.damageItem(2, attacker);
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!RewriteHelper.hasSkill(player, RewriteHelper.BruteForce.id)) {
			return stack;
		}
		
		List entities = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX-8.0D, player.posY-8.0D, player.posZ-8.0D, player.posX+8.0D, player.posY+8.0D, player.posZ+8.0D));
		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
			EntityLiving entity = (EntityLiving)iterator.next();
			if(!entity.equals(player)) {
				entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10.0F);
			}
		}
		stack.damageItem(32, player);
		return stack;
	}

}
