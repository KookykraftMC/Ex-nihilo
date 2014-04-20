package exnihilo.blocks.tileentities;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import exnihilo.ENBlocks;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;

public class TileEntityLeavesInfested extends TileEntity
{
	public Block block = Blocks.leaves;
	public int meta = 0;
	public Color color = ColorRegistry.color("white");
	public boolean dying = false;
	public boolean permanent = false;

	private static final int SPREAD_INTERVAL = 100;
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
		Color base = new Color(block.colorMultiplier(worldObj, xCoord, yCoord, zCoord));
		Color white = ColorRegistry.color("white");

		return Color.average(base, white, progress);
	}

	public int getBrightness()
	{
		return block.getMixedBrightnessForBlock(worldObj, xCoord, yCoord, zCoord);
	}

	public float getProgress()
	{
		return progress;
	}

	private void spread()
	{
		int x = this.worldObj.rand.nextInt(3) - 1;
		int y = this.worldObj.rand.nextInt(3) - 1;
		int z = this.worldObj.rand.nextInt(3) - 1;

		int meta = worldObj.getBlockMetadata(xCoord + x, yCoord + y, zCoord + z);

		//You would think that "isLeaves" would be enough to NOT have them spawn in the air around the tree. Apparently not...
		if(block != null && !worldObj.isAirBlock(x, y, z) && block.isLeaves(worldObj, x, y, z) && block != ENBlocks.LeavesInfested) // && !Forestry.addsThisLeaf(block))
		{
			worldObj.setBlock(xCoord + x, yCoord + y, zCoord + z, ENBlocks.LeavesInfested, meta, 3);
			TileEntityLeavesInfested te = (TileEntityLeavesInfested)worldObj.getTileEntity(xCoord + x, yCoord + y, zCoord + z);
			te.setMimicBlock(block, meta);
		}
	}

	public void setMimicBlock(Block block, int meta)
	{
		this.block = block;
		this.meta = meta;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		progress = compound.getFloat("progress");

		if(!compound.getString("block").equals("")) {
			block = (Block)Block.blockRegistry.getObject(compound.getString("block"));
		}else{
			block = null;
		}

		int tempMeta = compound.getInteger("meta");
		if (tempMeta != 0)
			meta = tempMeta;
		
		permanent = compound.getBoolean("permanent");
		dying = compound.getBoolean("dying");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setFloat("progress", progress);
		if(block == null) {
			compound.setString("block", "");
		}else{
			compound.setString("block", Block.blockRegistry.getNameForObject(block));
		}
		compound.setInteger("meta", meta);
		compound.setBoolean("permanent", permanent);
		compound.setBoolean("dying", dying);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.func_148857_g();
		this.readFromNBT(tag);
	}
}
