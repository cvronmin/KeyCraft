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
package com.kanbekotori.keycraft.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.kanbekotori.keycraft.helper.RewriteHelper;

public class BlockTrapTNT extends BlockTraps {

	protected BlockTrapTNT(EntityLivingBase layer) {
		super(layer);
	}
	
	/** �����鱻����ʱ���ô˷����� */
	@Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack) {
		super.onBlockPlacedBy(world, posX, posY, posZ, entity, stack);
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			if (!RewriteHelper.hasSkill(player, RewriteHelper.TrapProficient.id)) {
				world.setBlockToAir(posX, posY, posZ);
				stack.stackSize++;
				if (world.isRemote)	{
					player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.notrapskill")));
				}
			}
		}
	}
	
	/** ��ʵ���߹�����ʱ���ô˷����� */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {
        super.onEntityWalking(world, posX, posY, posZ, entity);
        TileEntityTrap tile = (TileEntityTrap)world.getTileEntity(posX, posY, posZ);
        if (entity instanceof EntityPlayer && ((EntityPlayer)entity).getDisplayName().equals(tile.ownerName)) {
        	if (!world.isRemote) {
        		((EntityPlayer)entity).addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.yourtrap")));
        	}
        } else {
			world.removeTileEntity(posX, posY, posZ);
        	world.setBlockToAir(posX, posY, posZ);
        	world.createExplosion(world.getPlayerEntityByName(tile.ownerName), posX, posY, posZ, 10.0f, true);
        }
    }
	
	/** �����鱻ը��ʱ ����������ը�� */
    public void onBlockDestroyedByExplosion(World world, int posX, int posY, int posZ, Explosion exp) {
        if (!world.isRemote) {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, posX + 0.5F, posY + 0.5F, posZ + 0.5F, exp.getExplosivePlacedBy());
            entitytntprimed.fuse = world.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
            world.spawnEntityInWorld(entitytntprimed);
        	world.removeTileEntity(posX, posY, posZ);
        }
    }

}
