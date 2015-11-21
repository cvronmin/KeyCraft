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
