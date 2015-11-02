package com.KanbeKotori.KeyCraft.Items;

import java.util.*;

import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import com.KanbeKotori.KeyCraft.Helper.ToolMaterialHelper;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemWirePole extends ItemSword {
	
	MainHelper mainhelper = new MainHelper();
	RewriteHelper rwhelper = new RewriteHelper();

	public ItemWirePole() {
		super(ToolMaterialHelper.WirePole);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!rwhelper.getPoint(player, 232)) {
			return stack;
		}
		
		List list = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(player.posX-3.0D, player.posY-2.0D, player.posZ-3.0D, player.posX+3.0D, player.posY+2.0D, player.posZ+3.0D));
		for(Iterator iterator = list.iterator();iterator.hasNext();) {
			EntityLiving entity = (EntityLiving)iterator.next();
			if(entity.equals(player)) {
				continue;
			}
			entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10.0F);
		}
		stack.damageItem(32, player);
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
		p_77624_3_.add(StatCollector.translateToLocal("keycraft.item.intro_WirePole_1"));
		p_77624_3_.add(StatCollector.translateToLocal("keycraft.item.intro_WirePole_2"));
	}

}
