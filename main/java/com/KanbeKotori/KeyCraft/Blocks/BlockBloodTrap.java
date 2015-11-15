package com.KanbeKotori.KeyCraft.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class BlockBloodTrap extends Block {
	
	private EntityLivingBase owner;
	private IIcon icon;

	protected BlockBloodTrap(EntityLivingBase layer) {
		super(Material.rock);
		this.owner = layer;
	}
	
	/** 当方块被放置时调用此方法。 */
	@Override
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase entity, ItemStack p_149689_6_) {
		this.owner = entity;
	}
	
	/** 当实体走过方块时调用此方法。 */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {
        super.onEntityWalking(world, posX, posY, posZ, entity);
        if (!entity.equals(owner)) {
        	world.setBlockToAir(posX, posY, posZ);
        	DamageSource source;
        	if (owner instanceof EntityPlayer)	{
        		source = DamageSource.causePlayerDamage((EntityPlayer)owner);
        	} else {
        		source = DamageSource.magic;
        	}
        	entity.attackEntityFrom(source, 20.0F);
        } else {
        	if (owner instanceof EntityPlayer && world.isRemote)	{
        		((EntityPlayer) owner).addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.yourtrap")));
        	}
        }
    }
	
	/** 当方块被右击时调用此方法。 */
    public boolean onBlockActivated(World world, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
    	ItemStack held = player.getHeldItem();
		if (player.equals(this.owner) && held != null) {
			Block block = Block.getBlockFromItem(held.getItem());
			if (block != null) {
				int metadata = held.getItem().getMetadata(held.getItemDamage());
				this.icon = block.getIcon(1, metadata);
			}
		}
    	return false;
    }
    
    /** 获取方块材质。 */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	if (this.icon != null) {
    		return this.icon;
    	}
        return this.blockIcon;
    }

}
