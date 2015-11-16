package com.KanbeKotori.KeyCraft.Blocks;

import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

public class BlockTrapNormal extends BlockTraps {

	protected BlockTrapNormal(EntityLivingBase layer) {
		super(layer);
		this.owner = layer;
	}
	
	/** 当方块被放置时调用此方法。 */
	@Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack) {
		this.owner = entity;
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			if (!RewriteHelper.hasSkill(player, RewriteHelper.TrapProficient.id)) {
				world.setBlockToAir(posX, posY, posZ);
				stack.stackSize++;
				if (owner instanceof EntityPlayer && world.isRemote)	{
					player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.notrapskill")));
				}
			}
		}
	}
	
	/** 当实体走过方块时调用此方法。 */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {
        super.onEntityWalking(world, posX, posY, posZ, entity);
        if (!entity.equals(owner)) {
        	world.setBlockToAir(posX, posY, posZ);
        } else {
        	if (owner instanceof EntityPlayer && world.isRemote)	{
        		((EntityPlayer) owner).addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.yourtrap")));
        	}
        }
    }

}
