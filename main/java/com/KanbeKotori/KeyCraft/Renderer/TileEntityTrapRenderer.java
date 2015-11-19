package com.KanbeKotori.KeyCraft.Renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.KanbeKotori.KeyCraft.Blocks.ModBlocks;
import com.KanbeKotori.KeyCraft.Blocks.TileEntityTrap;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class TileEntityTrapRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float p_147500_8_) {
		TileEntityTrap tile = (TileEntityTrap)tileEntity;
		Block block = Block.getBlockById(tile.fakeBlockID);
		if (block == Blocks.air) {
			block = ModBlocks.NormalTrap;
		}

		// 渲染失败，自己想办法
		renderBlock(tile.getWorldObj(), block, tile, x, y, z);
	}
	
	public void renderBlock(World world, Block block, TileEntityTrap tile, double x, double y, double z) {
        bindTexture(TextureMap.locationBlocksTexture);
		Tessellator tessellator = Tessellator.instance;
		RenderBlocks renderer = new RenderBlocks(world);

        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glTranslated(x + 0.5D, y + 0.5D, z + 0.5D);
        /*GL11.glTranslated(x, y, z);
        
        tessellator.startDrawingQuads();
        boolean res = renderer.renderBlockByRenderType(block, 0, 0, 0);
        if (!res) { // 比如NormalTrap
        	renderer.renderStandardBlock(block, 0, 0, 0);
        }
        tessellator.draw();*/

        renderer.renderBlockAsItem(block, 0, 1.0F);

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
	}

}
