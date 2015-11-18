package com.KanbeKotori.KeyCraft.Renderer;

import org.lwjgl.opengl.GL11;

import com.KanbeKotori.KeyCraft.Blocks.ModBlocks;
import com.KanbeKotori.KeyCraft.Blocks.TileEntityTrap;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTrapRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float p_147500_8_) {
		TileEntityTrap tile = (TileEntityTrap)tileEntity;
		Block block = Block.getBlockById(tile.fakeBlockID);
		if (block == Blocks.air) {
			block = ModBlocks.NormalTrap;
		}

		// 渲染失败，自己想办法
		Tessellator.instance.startDrawingQuads();
		RenderBlocks renderer = new RenderBlocks(tile.getWorldObj());
		renderer.setRenderBoundsFromBlock(block);
		renderer.setOverrideBlockTexture(renderer.getBlockIcon(block));
		renderer.renderStandardBlock(block, tile.xCoord, tile.yCoord, tile.zCoord);
		Tessellator.instance.draw();
	}

}
