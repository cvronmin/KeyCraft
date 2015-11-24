package com.KanbeKotori.KeyCraft.Blocks;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

public class BlockTrapBlowUp extends BlockTraps {

	protected BlockTrapBlowUp(EntityLivingBase layer) {
		super(layer);
	}
	
	/** 当方块被放置时调用此方法。 */
	@Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack) {
		super.onBlockPlacedBy(world, posX, posY, posZ, entity, stack);
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			if (!RewriteHelper.hasSkill(player, RewriteHelper.TrapProficient.id)) {
				world.setBlockToAir(posX, posY, posZ);
				stack.stackSize++;
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.notrapskill")));
				}
			}
		}
	}
	
	/** 当实体走过方块时调用此方法。 */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {
        super.onEntityWalking(world, posX, posY, posZ, entity);
        TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(posX, posY, posZ);
        if (entity instanceof EntityPlayer && ((EntityPlayer)entity).getDisplayName().equals(tile.ownerName)) {
        	if (!world.isRemote) {
        		((EntityPlayer)entity).addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.yourtrap")));
        	}
        } else {
        	entity.setVelocity(entity.motionX, entity.motionY + 5.0F, entity.motionZ);
        	world.removeTileEntity(posX, posY, posZ);
        	world.setBlockToAir(posX, posY, posZ);
        }
    }
	
	/** 当方块被炸烂时 直接吹飞。 */
    public void onBlockDestroyedByExplosion(World world, int posX, int posY, int posZ, Explosion exp) {
        if (!world.isRemote) {
            TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(posX, posY, posZ);
        	List entities = world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(posX - 8.0D, posY - 8.0D, posZ - 8.0D, posX + 8.0D, posY + 8.0D, posZ + 8.0D));
    		for (Iterator iterator = entities.iterator(); iterator.hasNext(); ) {
    			EntityLivingBase entity = (EntityLivingBase)iterator.next();
            	entity.setVelocity(entity.motionX, entity.motionY + 5.0F, entity.motionZ);
    		}
        	world.removeTileEntity(posX, posY, posZ);
        }
    }

}
