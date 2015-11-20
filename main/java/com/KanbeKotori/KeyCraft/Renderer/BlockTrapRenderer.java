package com.KanbeKotori.KeyCraft.Renderer;

import org.lwjgl.opengl.GL11;

import com.KanbeKotori.KeyCraft.Blocks.ModBlocks;
import com.KanbeKotori.KeyCraft.Blocks.TileEntityTrap;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class BlockTrapRenderer implements ISimpleBlockRenderingHandler {
	
	public static int RENDER_ID = -998;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		
		if (renderer.useInventoryTint)
        {
            int j = block.getRenderColor(metadata);

            float f1 = (float)(j >> 16 & 255) / 255.0F;
            float f2 = (float)(j >> 8 & 255) / 255.0F;
            float f3 = (float)(j & 255) / 255.0F;
            GL11.glColor4f(f1, f2, f3, 1.0F);
        }
		renderer.setRenderBoundsFromBlock(block);
		
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        tessellator.draw();

        if (renderer.useInventoryTint)
        {
        	int k = block.getRenderColor(metadata);
            float f2 = (float)(k >> 16 & 255) / 255.0F;
            float f3 = (float)(k >> 8 & 255) / 255.0F;
            float f4 = (float)(k & 255) / 255.0F;
            GL11.glColor4f(f2, f3, f4, 1.0F);
        }

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        tessellator.draw();

        if (renderer.useInventoryTint)
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(x, y, z);
		Block fakeBlock = Block.getBlockById(tile.fakeBlockID);
		if (fakeBlock == Blocks.air) {
			fakeBlock = block;
		}
		
		boolean res = false;
		if (fakeBlock.getRenderType() == RENDER_ID) {
			res = renderer.renderStandardBlock(fakeBlock, x, y, z);
		} else {
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(fakeBlock, world, x, y, z, 0));
			res = renderer.renderBlockByRenderType(fakeBlock, x, y, z);
			renderer.clearOverrideBlockTexture();
		}
		
		return res;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RENDER_ID;
	}

}
