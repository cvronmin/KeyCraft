package com.KanbeKotori.KeyCraft.Blocks;

import java.util.Random;

import com.KanbeKotori.KeyCraft.Helper.*;
import com.KanbeKotori.KeyCraft.Renderer.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockEnergyPoint extends Block {

	public BlockEnergyPoint() {
		super(Material.rock);
	}
	
	/** …Ë÷√∆∆ªµ≤˙ŒÔ°£ */
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return null;
    }
	
	@Override
    public void onBlockHarvested(World world, int posX, int posY, int posZ, int meta, EntityPlayer player) {
    	world.setBlockToAir(posX, posY, posZ);
    	if (RewriteHelper.hasSkill(player, RewriteHelper.EnergyPointUsage.id)) {
    		RewriteHelper.modifyAuroraPoint(player, 20);
    	}
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIcon(int side, int meta) {
		EntityPlayer player = MainHelper.getPlayerCl();
		boolean flag = RewriteHelper.hasSkill(player, RewriteHelper.EnergyPointUsage.id);
		return flag? this.blockIcon:Blocks.stone.getIcon(side, meta);
    }

}
