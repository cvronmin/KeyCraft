package com.KanbeKotori.KeyCraft.Entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityJavelin extends EntityThrowable {

	/** 相对于弓箭的速度 */
	protected static float SPEED = 1.5F;
	protected static float DAMAGE = 10.0F;

	public EntityJavelin(World world) {
		super(world);
		this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
	}
	
	public EntityJavelin(World world, EntityLivingBase thrower, float speed, boolean hasSkill) {
		super(world, thrower);
		this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
        if (hasSkill) {
        	this.DAMAGE = 20.0F;
        	this.SPEED = 2.0F;
        }
        this.DAMAGE /= (speed/3);
        
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
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed * SPEED, 0.0F);
    }
	
	protected void onImpact(MovingObjectPosition target) {
        if (target.entityHit != null) {
        	EntityLivingBase thrower = this.getThrower();
        	target.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, thrower == null ? this : thrower), DAMAGE);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

}
