package exnihilo.blocks.tileentities;

import java.util.ArrayList;
import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.Blocks;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.data.BlockData;
import exnihilo.particles.ParticleSieve;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Color;
import exnihilo.registries.helpers.SiftReward;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public class TileEntitySieve extends TileEntity{
	private static final float MIN_RENDER_CAPACITY = 0.70f;
	private static final float MAX_RENDER_CAPACITY = 0.9f;
	private static final float PROCESSING_INTERVAL = 0.075f;
	private static final int UPDATE_INTERVAL = 20;
	private Color color = new Color(1f,1f,1f,1f);

	public int contentID = 0;
	public int contentMeta = 0;

	private float volume = 0;
	public SieveMode mode = SieveMode.EMPTY;

	private int timer = 0;
	private boolean update = false;
	private boolean particleMode = false;


	public enum SieveMode
	{EMPTY(0), FILLED(1);
	private SieveMode(int v){this.value = v;}
	public int value;
	}

	public TileEntitySieve()
	{
		mode = mode.EMPTY;
	}

	public void addSievable(int blockID, int blockMeta)
	{
		this.contentID = blockID;
		this.contentMeta = blockMeta;

		this.mode = SieveMode.FILLED;

		volume = 1.0f;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void updateEntity()
	{
		if(worldObj.isRemote && particleMode)
		{
			spawnFX(contentID, contentMeta);
		}

		timer++;
		if (timer >= UPDATE_INTERVAL)
		{
			timer = 0;
			disableParticles();

			if (update)
			{
				update();
			}
		}
	}

	public void ProcessContents(boolean creative)
	{	
		if (creative)
		{
			volume = 0;
		}else
		{
			volume -= PROCESSING_INTERVAL;
		}

		if (volume <= 0)
		{
			mode = mode.EMPTY;
			//give rewards!
			if (!worldObj.isRemote)
			{
				ArrayList<SiftReward> rewards = SieveRegistry.getRewards(contentID, contentMeta);
				if (rewards.size() > 0)
				{
					Iterator<SiftReward> it = rewards.iterator();
					while(it.hasNext())
					{
						SiftReward reward = it.next();

						if (worldObj.rand.nextInt(reward.rarity) == 0)
						{
							EntityItem entityitem = new EntityItem(worldObj, (double)xCoord + 0.5D, (double)yCoord + 1.5D, (double)zCoord + 0.5D, new ItemStack(reward.id, 1, reward.meta));

							double f3 = 0.05F;
							entityitem.motionX = worldObj.rand.nextGaussian() * f3;
							entityitem.motionY = (0.2d);
							entityitem.motionZ = worldObj.rand.nextGaussian() * f3;

							worldObj.spawnEntityInWorld(entityitem);

							//System.out.println("Spawning: " + reward.id);
						}
					}
				}
			}
		}
		else
		{
			particleMode = true;
		}

		update = true;
	}

	@SideOnly(Side.CLIENT)
	private void spawnFX(int blockID, int blockMeta)
	{
		Block block = Block.blocksList[blockID];
		if (block != null)
		{
			Icon icon = block.getIcon(0, blockMeta);

			for (int x = 0; x < 4; x++)
			{	
				ParticleSieve dust = new ParticleSieve(worldObj, 
						xCoord + 0.8d * worldObj.rand.nextFloat() + 0.15d, 
						yCoord + 0.69d, 
						zCoord + 0.8d * worldObj.rand.nextFloat() + 0.15d, 
						0.0d, 0.0d, 0.0d, icon);
				
				Minecraft.getMinecraft().effectRenderer.addEffect(dust);
			}
		}
	}

	public float getAdjustedVolume()
	{
		float capacity = MAX_RENDER_CAPACITY - MIN_RENDER_CAPACITY;
		float adjusted = volume * capacity;		
		adjusted += MIN_RENDER_CAPACITY;
		return adjusted;
	}

	private void update()
	{
		update = false;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	private void disableParticles()
	{
		particleMode = false;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		switch (compound.getInteger("mode"))
		{
		case 0:
			mode = SieveMode.EMPTY;
			break;

		case 1:
			mode = SieveMode.FILLED;
			break;
		}
		contentID = compound.getInteger("contentID");
		contentMeta = compound.getInteger("contentMeta");
		volume = compound.getFloat("volume");
		particleMode = compound.getBoolean("particles");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("mode", mode.value);
		compound.setInteger("contentID", contentID);
		compound.setInteger("contentMeta", contentMeta);
		compound.setFloat("volume", volume);
		compound.setBoolean("particles", particleMode);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, BlockData.SIEVE_ID, tag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{
		NBTTagCompound tag = pkt.data;
		this.readFromNBT(tag);
	}
}
