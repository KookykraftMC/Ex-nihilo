package exnihilo.blocks.tileentities;

import exnihilo.Blocks;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.data.BlockData;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityLeavesInfested extends TileEntity
{
	private static final int SPREAD_INTERVAL = 300;
	private int spreadTimer = 0;
	
	private static final float PROGRESS_INTERVAL = .0005f;
	private float progress = 0;
	
	@Override
	public void updateEntity()
	{
		if (progress < 1.0f)
		{
			progress += PROGRESS_INTERVAL;
			
			if (progress > 1.0f)
			{
				progress = 1.0f;
			}
		}
		
		if (!worldObj.isRemote && progress > 0.6f)
		{
			spreadTimer++;

			if (spreadTimer >= SPREAD_INTERVAL)
			{
				spread();
				spreadTimer = worldObj.rand.nextInt(10);

				if (progress < 1.0f)
				{
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
			}
		}
	}
	
	public boolean isComplete()
	{
		return progress >= PROGRESS_INTERVAL;
	}
	
	
	public Color getRenderColor()
    {
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		
		Color base = new Color(Block.leaves.colorMultiplier(worldObj, xCoord, yCoord, zCoord));
		Color white = ColorRegistry.color("white");
		
        return Color.average(base, white, progress);
    }
	
	public float getProgress()
	{
		return progress;
	}
	
	private void spread()
	{
		for (int x = -1; x <= 1; x++)
		{
			for (int y = -1; y <= 1; y++)
			{
				for (int z = -1; z <= 1; z++)
				{
					if(worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z) == Block.leaves.blockID && worldObj.rand.nextInt(20) == 0)
					{
						worldObj.setBlock(xCoord + x, yCoord + y, zCoord + z, Blocks.LeavesInfested.blockID, worldObj.getBlockMetadata(xCoord + x, yCoord + y, zCoord + z), 3);
					}
				}
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		progress = compound.getFloat("progress");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setFloat("progress", progress);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, BlockData.LEAVES_INFESTED_ID, tag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{
		NBTTagCompound tag = pkt.data;
		this.readFromNBT(tag);
	}
}
