package com.KanbeKotori.KeyCraft.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemBreadWithJam extends ItemFood {
	public ItemBreadWithJam(int healAmount) {
		super(healAmount, false);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return true;
    }
}
