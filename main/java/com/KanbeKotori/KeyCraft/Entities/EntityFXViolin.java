package com.kanbekotori.keycraft.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFXViolin extends EntityFX {
	private static TextureManager textureManager = Minecraft.getMinecraft().renderEngine;
	private static ResourceLocation texture = new ResourceLocation("keycraft:textures/particles/violin.png");

	public EntityFXViolin(World world, double posX, double posY, double posZ) {
		super(world, posX, posY, posZ);
		double speed = 0.1D;
		double direction = 2 * Math.PI * rand.nextFloat();
		setVelocity(Math.sin(direction) * speed, 0, Math.cos(direction) * speed);
		this.particleMaxAge = 40;
		this.particleGravity = 0.0f;
		this.particleRed = rand.nextFloat();
		this.particleGreen = rand.nextFloat();
		this.particleBlue = rand.nextFloat();
		this.particleAlpha = 1.0f;
		this.particleScale = 2.0f;
	}

	@Override
	public int getFXLayer() {
		return 2;
	}

	@Override
	public void renderParticle(Tessellator tessellator, float delta, float rotationX, float rotationXZ,
			float rotationZ, float rotationYZ, float rotationXY) {
		tessellator.draw();
		tessellator.startDrawingQuads();
		textureManager.bindTexture(texture);
		float f6 = 0.0f;
		float f7 = 1.0f;
		float f8 = 0.0f;
		float f9 = 1.0f;
		float scale = 0.1F * this.particleScale;

		float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)delta - interpPosX);
		float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)delta - interpPosY);
		float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)delta - interpPosZ);
		tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
		tessellator.addVertexWithUV((double)(f11 - rotationX * scale - rotationYZ * scale), (double)(f12 - rotationXZ * scale), (double)(f13 - rotationZ * scale - rotationXY * scale), (double)f7, (double)f9);
		tessellator.addVertexWithUV((double)(f11 - rotationX * scale + rotationYZ * scale), (double)(f12 + rotationXZ * scale), (double)(f13 - rotationZ * scale + rotationXY * scale), (double)f7, (double)f8);
		tessellator.addVertexWithUV((double)(f11 + rotationX * scale + rotationYZ * scale), (double)(f12 + rotationXZ * scale), (double)(f13 + rotationZ * scale + rotationXY * scale), (double)f6, (double)f8);
		tessellator.addVertexWithUV((double)(f11 + rotationX * scale - rotationYZ * scale), (double)(f12 - rotationXZ * scale), (double)(f13 + rotationZ * scale - rotationXY * scale), (double)f6, (double)f9);
		tessellator.draw();
		tessellator.startDrawingQuads();
		textureManager.bindTexture(TextureMap.locationItemsTexture);
	}
	
}
