/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori & xfgryujk.
 * ����Ʒ�� Kanbe-Kotori & xfgryujk ����������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.kanbekotori.keycraft.KeyCraft;
import com.kanbekotori.keycraft.entities.EntityJavelin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderJavelin extends Render {
	
	private static final ResourceLocation JavelinTexture = new ResourceLocation(KeyCraft.MODID, "textures/entity/javelin.png");
	
	public void doRender(EntityJavelin entity, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
		this.bindEntityTexture(entity);
		GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        //ԭ���Ƶ�ʵ������
        GL11.glTranslatef(0.0F, entity.height / 2.0F, 0.0F);
        GL11.glRotatef(entity.prevRotationYaw - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(entity.prevRotationPitch, 0.0F, 0.0F, 1.0F);
        
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);

        float f10 = 0.05625F;
        GL11.glScalef(f10, f10, f10);
        for (int i = 0; i < 4; ++i)
        {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f10);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-3.25D, -0.5D, 0.0D,  1.0D / 16.0D, 14.0D / 16.0D); // ����
            tessellator.addVertexWithUV( 3.25D, -0.5D, 0.0D, 14.0D / 16.0D,  1.0D / 16.0D); // ����
            tessellator.addVertexWithUV( 3.25D,  0.5D, 0.0D, 16.0D / 16.0D,  3.0D / 16.0D); // ����
            tessellator.addVertexWithUV(-3.25D,  0.5D, 0.0D,  3.0D / 16.0D, 16.0D / 16.0D); // ����
            tessellator.draw();
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }
	
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return JavelinTexture;
    }
	
	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityJavelin)entity, x, y, z, p_76986_8_, p_76986_9_);
    }
	
}
