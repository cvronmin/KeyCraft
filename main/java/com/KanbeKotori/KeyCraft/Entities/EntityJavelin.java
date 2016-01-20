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
package com.KanbeKotori.KeyCraft.Entities;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityJavelin extends EntityThrowable {

	/** 相对于弓箭的速度 */
	protected static final float SPEED_NO_SKILL = 1.5F;
	protected static final float SPEED_HAS_SKILL = 2.0F;
	protected static final float DAMAGE_NO_SKILL = 25.0F;
	protected static final float DAMAGE_HAS_SKILL = 50.0F;

	public EntityJavelin(World world) {
		super(world);
		this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
	}
	
	public EntityJavelin(World world, EntityLivingBase thrower, float speed) {
		super(world, thrower);
		this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
        
        float speed2 = SPEED_NO_SKILL;
        if (thrower instanceof EntityPlayer && RewriteHelper.hasSkill((EntityPlayer)thrower, RewriteHelper.JavelinOfLouis.id)) {
        	speed2 = SPEED_HAS_SKILL;
        }
        
        // 重新设置位置和速度
        this.setLocationAndAngles(thrower.posX, thrower.posY + (double)thrower.getEyeHeight(), thrower.posZ, thrower.rotationYaw, thrower.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed * speed2, 0.0F);
    }
	
	protected void onImpact(MovingObjectPosition target) {
        if (target.entityHit != null) {
        	EntityLivingBase thrower = this.getThrower();
        	
        	float damage = DAMAGE_NO_SKILL;
            if (thrower instanceof EntityPlayer && RewriteHelper.hasSkill((EntityPlayer)thrower, RewriteHelper.JavelinOfLouis.id)) {
            	damage = DAMAGE_HAS_SKILL;
            }
            float speed = (float)Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
            damage = damage * speed / 5.8F;
            
        	target.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, thrower == null ? this : thrower), damage);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

}
