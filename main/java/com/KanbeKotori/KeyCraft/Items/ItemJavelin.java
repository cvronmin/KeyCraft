package com.KanbeKotori.KeyCraft.Items;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Entities.EntityBaseball;
import com.KanbeKotori.KeyCraft.Entities.EntityJavelin;
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
	        if (RewriteHelper.hasSkill(player, RewriteHelper.JavelinOfLouis.id)) {
	        	world.spawnEntityInWorld(new EntityJavelin(world, player, speed, true));
	        } else {
	        	world.spawnEntityInWorld(new EntityJavelin(world, player, speed, false));
	        }
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
