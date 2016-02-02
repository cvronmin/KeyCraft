package com.kanbekotori.keycraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityKagariCannon extends EntityThrowableWithoutGravity {

	protected static final float SPEED = 0.2F;
	protected static final float DAMAGE = 200F;
	
	public EntityKagariCannon(World world) {
        super(world, 0.25F, 0.25F);
    }
	
	public EntityKagariCannon(World world, EntityLivingBase thrower) {
        super(world, thrower);
        
        // ��������λ�ú��ٶ�
        this.setLocationAndAngles(thrower.posX, thrower.posY + (double)thrower.getEyeHeight(), thrower.posZ, thrower.rotationYaw, thrower.rotationPitch);
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, SPEED, 0.0F);
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