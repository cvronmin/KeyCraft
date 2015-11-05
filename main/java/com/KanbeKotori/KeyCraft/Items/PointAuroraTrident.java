package com.KanbeKotori.KeyCraft.Items;

import java.util.List;

import com.KanbeKotori.KeyCraft.Event.EventOnAuroraBreak;
import com.KanbeKotori.KeyCraft.Event.EventOnAuroraRecycle;
import com.KanbeKotori.KeyCraft.Helper.ToolMaterialHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class PointAuroraTrident extends ItemSword {

	public PointAuroraTrident() {
		super(ToolMaterialHelper.Aurora1);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (stack.getItemDamage() >= this.getMaxDamage()) {
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
		
		if (stack.getItemDamage() >= this.getMaxDamage()) {
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
	public void onUpdate(ItemStack stack, World world, Entity player, int index, boolean isCurrentItem) {
		if (player instanceof EntityPlayer && !isCurrentItem) {
			((EntityPlayer)player).inventory.mainInventory[index] = null;
			recycle(stack, (EntityPlayer)player);
		}
	}
	
	@SubscribeEvent
	public void onDropped(ItemTossEvent event) {
		if (event.entityItem.getEntityItem().getItem() instanceof PointAuroraTrident) {
			event.setCanceled(true);
			recycle(event.entityItem.getEntityItem(), event.player);
		}
    }
	
	public void recycle(ItemStack stack, EntityPlayer player) {
		double pp = (double)stack.getItemDamage() / stack.getMaxDamage();
		if (!player.worldObj.isRemote) {
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.recycletrident")));
		}
		EventOnAuroraRecycle EventOnAuroraRecycle = new EventOnAuroraRecycle(player, pp);
        MinecraftForge.EVENT_BUS.post(EventOnAuroraRecycle);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List information, boolean p_77624_4_) {
		information.add(StatCollector.translateToLocal("keycraft.item.intro311_1"));
		information.add(StatCollector.translateToLocal("keycraft.item.intro311_2"));
	}

}
