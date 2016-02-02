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
package com.kanbekotori.keycraft.entities;

import com.kanbekotori.keycraft.helper.RewriteHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityBaseball extends EntityThrowableWithoutGravity {

	protected static final float SPEED_NO_SKILL = 3.0F;
	protected static final float SPEED_HAS_SKILL = 10.0F;
	protected static final float DAMAGE_NO_SKILL = 5.0F;
	protected static final float DAMAGE_HAS_SKILL = 10.0F;
	
	public EntityBaseball(World world) {
        super(world, 0.25f, 0.25F);
    }
	
	public EntityBaseball(World world, EntityLivingBase thrower) {
        super(world, thrower);
        
        // ��������λ�ú��ٶ�
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
