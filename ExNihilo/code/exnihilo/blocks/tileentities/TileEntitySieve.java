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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySieve extends TileEntity{
	private static final float MIN_RENDER_CAPACITY = 0.70f;
	private static final float MAX_RENDER_CAPACITY = 0.9f;
	private static final float PROCESSING_INTERVAL = 0.075f;
	private static final int UPDATE_INTERVAL = 20;
	private Color color = new Color(1f,1f,1f,1f);
	
	private float volume = 0;
	public SieveMode mode;
	
	private int timer = 0;
	private boolean update = false;
	private boolean particleMode = false;
	
	
	public enum SieveMode
	{EMPTY(0), DIRT(1), GRAVEL(2), SAND(3), SOULSAND(4), DUST(5);
	private SieveMode(int v){this.value = v;}
	public int value;
	}
	
	public TileEntitySieve()
	{
		mode = mode.EMPTY;
	}
	
	
	@Override
	public void updateEntity()
	{
		if(worldObj.isRemote && particleMode)
		{
			switch(mode)
			{
			case EMPTY:
				break;
			
			case DIRT:
				color = ColorRegistry.color("dirt");
				break;
			
			case GRAVEL:
				color = ColorRegistry.color("gravel");
				break;
				
			case SAND:
				color = ColorRegistry.color("sand");
				break;
				
			case SOULSAND:
				color = ColorRegistry.color("soul_sand");
				break;
				
			case DUST:
				color = ColorRegistry.color("dust");
				break;
			}
			
			spawnFX(color);
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
		int blockID = 0;
		int meta = 0;
		
		if (creative)
		{
			volume = 0;
		}else
		{
			volume -= PROCESSING_INTERVAL;
		}
		particleMode = true;
		
		switch(mode)
		{
		case EMPTY:
			break;
		
		case DIRT:
			blockID = Block.dirt.blockID;
			break;
		
		case GRAVEL:
			blockID = Block.gravel.blockID;
			break;
			
		case SAND:
			blockID = Block.sand.blockID;
			break;
			
		case SOULSAND:
			blockID = Block.slowSand.blockID;
			break;
			
		case DUST:
			blockID = Blocks.Dust.blockID;
			break;
			
		default:
			break;
		}
		
		

		if (volume <= 0)
		{
			mode = mode.EMPTY;
			//give rewards!
			if (!worldObj.isRemote)
			{
				ArrayList<SiftReward> rewards = SieveRegistry.getRewards(blockID, meta);
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

		update = true;
	}
	
	@SideOnly(Side.CLIENT)
	private void spawnFX(Color color)
	{
		for (int x = 0; x < 4; x++)
		{	
			ParticleSieve dust = new ParticleSieve(worldObj, 
					xCoord + 0.8d * worldObj.rand.nextFloat() + 0.2d, 
					yCoord + 0.69d, 
					zCoord + 0.8d * worldObj.rand.nextFloat() + 0.2d, 
					0.0d, 0.0d, 0.0d, color);
			Minecraft.getMinecraft().effectRenderer.addEffect(dust);
		}
	}
	
	public void AddDirt()
	{
		mode = SieveMode.DIRT;
		volume = 1.0f;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	public void AddGravel()
	{
		mode = SieveMode.GRAVEL;
		volume = 1.0f;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	public void AddSand()
	{
		mode = SieveMode.SAND;
		volume = 1.0f;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	public void AddSoulSand()
	{
		mode = SieveMode.SOULSAND;
		volume = 1.0f;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	public void AddDust()
	{
		mode = SieveMode.DUST;
		volume = 1.0f;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
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
			mode = SieveMode.DIRT;
			break;

		case 2:
			mode = SieveMode.GRAVEL;
			break;

		case 3:
			mode = SieveMode.SAND;
			break;	
		
		case 4:
			mode = SieveMode.SOULSAND;
			break;
			
		case 5:
			mode = SieveMode.DUST;
			break;
		}
		
		volume = compound.getFloat("volume");
		particleMode = compound.getBoolean("particles");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("mode", mode.value);
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
