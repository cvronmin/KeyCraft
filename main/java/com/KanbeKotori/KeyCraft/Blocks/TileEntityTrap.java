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
package com.KanbeKotori.KeyCraft.Blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTrap extends TileEntity {

	public String ownerName;
	public int fakeBlockID;
	
	public TileEntityTrap() {
		ownerName = "";
		fakeBlockID = 0;
	}
	
	public Block getFakeBlock() {
		Block fakeBlock = Block.getBlockById(fakeBlockID);
		if (fakeBlock == Blocks.air) {
			fakeBlock = this.getBlockType();
		}
		return fakeBlock;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        ownerName = data.getString("ownerName");
        fakeBlockID = data.getInteger("fakeBlockID");
        
        // 客户端更新方块
        if (worldObj != null && worldObj.isRemote) {
        	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

	@Override
    public void writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setString("ownerName", ownerName);
        data.setInteger("fakeBlockID", fakeBlockID);
    }
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tagCompound = new NBTTagCompound();
	    writeToNBT(tagCompound);
	    return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tagCompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
    }
	
}
