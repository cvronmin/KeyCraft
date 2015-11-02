package com.KanbeKotori.KeyCraft.Items;

import java.util.List;

import com.KanbeKotori.KeyCraft.Event.EventOnAuroraBreak;
import com.KanbeKotori.KeyCraft.Helper.ToolMaterialHelper;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class PointAuroraTrident extends ItemSword {

	public PointAuroraTrident() {
		super(ToolMaterialHelper.Aurora1);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (stack.getItemDamage() >= 64) {
			EntityPlayer player = (EntityPlayer)attacker;
			World world = player.getEntityWorld();
			if(!world.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.breaktrident")));	
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
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.breaktrident")));				
				EventOnAuroraBreak EventOnAuroraBreak = new EventOnAuroraBreak(player);
	            MinecraftForge.EVENT_BUS.post(EventOnAuroraBreak);
		    }	
		}
		
		stack.damageItem(1, entity);
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro1_1"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro1_2"));
	}

}
