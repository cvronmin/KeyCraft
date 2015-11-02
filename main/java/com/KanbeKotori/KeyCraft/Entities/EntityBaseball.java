package com.KanbeKotori.KeyCraft.Entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBaseball extends EntityThrowable {

	static protected float SPEED = 3.0F;
	static protected float DAMAGE = 5.0F;
	
	public EntityBaseball(World world) {
        super(world);
    }
	
	public EntityBaseball(World world, EntityLivingBase thrower) {
        super(world, thrower);
    }
	
	public EntityBaseball(World world, EntityLivingBase thrower, float speed) {
        super(world, thrower);
        this.SPEED = speed;
    }
	
	protected void onImpact(MovingObjectPosition target) {
        if (target.entityHit != null) {
            target.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), DAMAGE);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
	
	/** Get speed */
	@Override
	protected float func_70182_d() {
		return SPEED;
	}

}
