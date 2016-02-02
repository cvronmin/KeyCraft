/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori & xfgryujk.
 * ����Ʒ�� Kanbe-Kotori & xfgryujk ����������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.items;

import com.kanbekotori.keycraft.KeyCraft;
import com.kanbekotori.keycraft.entities.EntityBaseball;
import com.kanbekotori.keycraft.entities.EntityJavelin;
import com.kanbekotori.keycraft.event.EventThrowing;
import com.kanbekotori.keycraft.helper.RewriteHelper;

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
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
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
