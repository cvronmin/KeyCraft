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
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityBaseball extends EntityThrowable {

	protected static final float SPEED_NO_SKILL = 3.0F;
	protected static final float SPEED_HAS_SKILL = 10.0F;
	protected static final float DAMAGE_NO_SKILL = 5.0F;
	protected static final float DAMAGE_HAS_SKILL = 10.0F;
	
	public EntityBaseball(World world) {
        super(world);
    }
	
	public EntityBaseball(World world, EntityLivingBase thrower) {
        super(world, thrower);
        
        // 重新设置位置和速度
        this.setLocationAndAngles(thrower.posX, thrower.posY + (double)thrower.getEyeHeight(), thrower.posZ, thrower.rotationYaw, thrower.rotationPitch);
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        if (thrower instanceof EntityPlayer) {
        	this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, 
        							 RewriteHelper.hasSkill((EntityPlayer)thrower, RewriteHelper.BruteForce.id) ? SPEED_HAS_SKILL : SPEED_NO_SKILL, 0.0F);
        } else {
        	this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, SPEED_NO_SKILL, 0.0F);
        }
    }
	
	protected void onImpact(MovingObjectPosition target) {
        if (target.entityHit != null) {
        	EntityLivingBase thrower = this.getThrower();
        	if (thrower instanceof EntityPlayer) {
        		target.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, thrower), 
        										  RewriteHelper.hasSkill((EntityPlayer)thrower, RewriteHelper.BruteForce.id) ? SPEED_HAS_SKILL : DAMAGE_NO_SKILL);
        	} else {
        		target.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, thrower == null ? this : thrower), DAMAGE_NO_SKILL);
        	}
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

}
