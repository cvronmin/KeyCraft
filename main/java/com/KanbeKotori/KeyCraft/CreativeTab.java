package com.KanbeKotori.KeyCraft;

import com.KanbeKotori.KeyCraft.Items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String lable) {
		super(lable);
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.AuroraBlade;
	}
}
