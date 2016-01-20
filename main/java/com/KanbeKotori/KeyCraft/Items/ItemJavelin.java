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
package com.KanbeKotori.KeyCraft.Items;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Entities.EntityBaseball;
import com.KanbeKotori.KeyCraft.Entities.EntityJavelin;
import com.KanbeKotori.KeyCraft.Event.EventThrowing;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemJavelin extends ItemBow {

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount) {
		float speed = (float)(this.getMaxItemUseDuration(stack) - itemInUseCount) / 20.0F;
        speed = (speed * speed + speed * 2.0F) / 3.0F;
        if (speed < 0.1F) {
            return;
        }
        if (speed > 1.0F) {
            speed = 1.0F;
        }
        speed *= 3.0F;
		
		if (!world.isRemote) {
			EntityJavelin entityJavelin = new EntityJavelin(world, player, speed);
			world.spawnEntityInWorld(entityJavelin);
			EventThrowing event = new EventThrowing(player, entityJavelin);
			MinecraftForge.EVENT_BUS.post(event);
		}
		if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }
		world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (RewriteHelper.hasSkill(player, RewriteHelper.MissileProficient.id)) {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }

        return stack;
    }
	
	@Override
	public int getItemEnchantability() {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_) {
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString());
    }
    
}
