package com.KanbeKotori.KeyCraft.Blocks;

import java.util.Random;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;
import com.KanbeKotori.KeyCraft.Renderer.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
	
	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }

	@Override
	public int getRenderType() {
        return BlockEnergyPointRenderer.RENDER_ID;
    }


}
