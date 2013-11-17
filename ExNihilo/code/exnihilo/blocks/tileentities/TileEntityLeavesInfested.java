package exnihilo.blocks.tileentities;

import exnihilo.Blocks;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.compatibility.Forestry;
import exnihilo.data.BlockData;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityLeavesInfested extends TileEntity
{
	public static ResourceLocation icons = TextureMap.locationBlocksTexture;
	public int blockID = Block.leaves.blockID;
	public int meta = 0;
	public Color color = ColorRegistry.color("white");
	Icon icon = Block.leaves.getIcon(0, 0);
	
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
		Block mimic = Block.blocksList[blockID];

		Color base = new Color(mimic.colorMultiplier(worldObj, xCoord, yCoord, zCoord));
		Color white = ColorRegistry.color("white");
		
        return Color.average(base, white, progress);
    }
	
	public int getBrightness()
	{
		Block block = Block.blocksList[blockID];
		
		return block.getMixedBrightnessForBlock(worldObj, xCoord, yCoord, zCoord);
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
					int blockID = worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z);
					int meta = worldObj.getBlockMetadata(xCoord + x, yCoord + y, zCoord + z);
					
					Block target = Block.blocksList[blockID];
					
					if(target != null && target.isLeaves(null, 0, 0, 0) && !Forestry.addsThisLeaf(target) && worldObj.rand.nextInt(20) == 0)
					{
						worldObj.setBlock(xCoord + x, yCoord + y, zCoord + z, Blocks.LeavesInfested.blockID, meta, 3);
						TileEntityLeavesInfested te = (TileEntityLeavesInfested)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
						te.setMimicBlock(blockID, meta);
					}
				}
			}
		}
	}
	
	public void setMimicBlock(int blockID, int meta)
	{
		this.blockID = blockID;
		this.meta = meta;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		progress = compound.getFloat("progress");
		
		int tempBlockID = compound.getInteger("blockID");
		if (tempBlockID != 0)
			blockID = tempBlockID;
		
		int tempMeta = compound.getInteger("meta");
		if (tempMeta != 0)
			meta = tempMeta;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setFloat("progress", progress);
		compound.setInteger("blockID", blockID);
		compound.setInteger("meta", meta);
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
