/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * 本作品版权由Nulla开发组所有。
 * Developed by Kanbe-Kotori & xfgryujk.
 * 本作品由 Kanbe-Kotori & xfgryujk 合作开发。
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.*;

@SideOnly(Side.CLIENT)
public class EntityFXJavelin extends EntityFX {
	private static TextureManager textureManager = Minecraft.getMinecraft().renderEngine;
	private static ResourceLocation texture = new ResourceLocation("keycraft:textures/particles/javelin.png");
	private final float PI3 = (float)(Math.PI / 3.0);
	private final float PI6 = (float)(Math.PI / 6.0);

	public EntityFXJavelin(World world, double posX, double posY, double posZ, Vec3 direction) {
		super(world, posX, posY, posZ);
		double speed = rand.nextDouble() * 3.0d;
		direction.rotateAroundY((rand.nextFloat() - 0.5f) * PI3);
		direction.rotateAroundX((rand.nextFloat() - 0.5f) * PI6);
		direction.rotateAroundZ((rand.nextFloat() - 0.5f) * PI6);
		setVelocity(direction.xCoord * speed, direction.yCoord * speed, direction.zCoord * speed);
		this.particleGravity = 0.0f;
		//this.particleRed = 1.0f;
		//this.particleGreen = 0.0f;
		//this.particleBlue = 0.0f;
		this.particleAlpha = 1.0f;
		this.particleScale = 1.0f;
		this.particleMaxAge = (int)(50f / (this.rand.nextFloat() * 0.75f + 0.25f));
		this.noClip = true;
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
