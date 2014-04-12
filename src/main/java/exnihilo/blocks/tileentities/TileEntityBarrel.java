package exnihilo.blocks.tileentities;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.Fluids;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.helpers.Color;
import exnihilo.registries.helpers.Compostable;

public class TileEntityBarrel extends TileEntity implements IFluidHandler, ISidedInventory{	
	private static final float MIN_RENDER_CAPACITY = 0.1f;
	private static final float MAX_RENDER_CAPACITY = 0.9f;
	private static final int MAX_COMPOSTING_TIME = 1000;
	private static final int MAX_FLUID = 1000;
	private static final int UPDATE_INTERVAL = 10;

	private static final int MOSS_SPREAD_X_POS = 2;
	private static final int MOSS_SPREAD_X_NEG = -2;
	private static final int MOSS_SPREAD_Y_POS = 2;
	private static final int MOSS_SPREAD_Y_NEG = -1;
	private static final int MOSS_SPREAD_Z_POS = 2;
	private static final int MOSS_SPREAD_Z_NEG = -2;

	public enum BarrelMode
	{
		EMPTY(0, ExtractMode.None), 
		FLUID(1, ExtractMode.None), 
		COMPOST(2, ExtractMode.None), 
		DIRT(3, ExtractMode.Always), 
		CLAY(4, ExtractMode.Always), 
		SPORED(5, ExtractMode.None), 
		SLIME(6, ExtractMode.Always), 
		NETHERRACK(7, ExtractMode.Always), 
		ENDSTONE(8, ExtractMode.Always), 
		MILKED(9, ExtractMode.None), 
		SOULSAND(10, ExtractMode.Always),
		BEETRAP(11, ExtractMode.Always), 
		OBSIDIAN(12, ExtractMode.Always),
		COBBLESTONE(13, ExtractMode.Always),
		BLAZE_COOKING(14, ExtractMode.None),
		BLAZE(15, ExtractMode.PeacefulOnly),
		ENDER_COOKING(16, ExtractMode.None),
		ENDER(17, ExtractMode.PeacefulOnly);

		private BarrelMode(int v, ExtractMode extract){this.value = v; this.canExtract = extract;}
		public int value;
		public ExtractMode canExtract;
	}

	public enum ExtractMode
	{
		None,
		Always,
		PeacefulOnly;
	}

	public FluidStack fluid;
	private float volume;
	private int timer;
	public BarrelMode mode;
	public Color color;
	private Color colorBase;
	public IIcon icon;

	private boolean needsUpdate = false;
	private int updateTimer = 0;

	public TileEntityBarrel()
	{
		color = ColorRegistry.color("white");
		colorBase = color;
		mode = BarrelMode.EMPTY;
		volume = 0;
		timer = 0;
		fluid = new FluidStack(FluidRegistry.WATER, 0);
	}

	@Override
	public void updateEntity()
	{	
		//XXX Barrel state logic.
		if (updateTimer >= UPDATE_INTERVAL)
		{
			updateTimer = 0;
			if (needsUpdate)
			{
				needsUpdate = false;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		}
		else
		{
			updateTimer++;
		}

		switch(this.mode)
		{
		case EMPTY:
			//Handle Rain
			if (!worldObj.isRemote && worldObj.isRaining() && yCoord >= worldObj.getTopSolidOrLiquidBlock(xCoord, zCoord) - 1 && worldObj.getBiomeGenForCoords(xCoord, zCoord).rainfall > 0.0f)
			{
				fluid = new FluidStack(FluidRegistry.WATER, 0);
				mode = BarrelMode.FLUID;
			}
			break;

		case FLUID:
			//WATER!
			if (fluid.fluidID == FluidRegistry.WATER.getID())
			{
				//Handle Rain
				if (!worldObj.isRemote && !isFull() && worldObj.isRaining() && yCoord >= worldObj.getTopSolidOrLiquidBlock(xCoord, zCoord) - 1 && worldObj.getBiomeGenForCoords(xCoord, zCoord).rainfall > 0.0f)
				{
					volume += worldObj.getBiomeGenForCoords(xCoord, zCoord).rainfall / (float)1000;

					if (volume > 1)
					{
						volume = 1;
					}

					fluid.amount = (int)(MAX_FLUID * volume);
					needsUpdate = true;
				}

				//Check for spores.
				if(!worldObj.isRemote && isFull() && ModData.ALLOW_BARREL_RECIPE_SOULSAND && getNearbyBlocks(Blocks.mycelium, 0) > 0)
				{
					colorBase = new Color(fluid.getFluid().getColor());
					mode = BarrelMode.SPORED;
					needsUpdate = true;
				}

				//Turn into cobblestone?
				if (isFull() && worldObj.getBlock(xCoord, yCoord + 1, zCoord) == FluidRegistry.LAVA.getBlock())
				{
					mode = BarrelMode.COBBLESTONE;
				}

				//Spread moss.
				if(!worldObj.isRemote && fluid.amount > 0 && worldObj.getBlock(xCoord, yCoord, zCoord).getMaterial().getCanBurn() && worldObj.rand.nextInt(500) == 0)
				{
					int x = xCoord + (worldObj.rand.nextInt(MOSS_SPREAD_X_POS - MOSS_SPREAD_X_NEG + 1) + MOSS_SPREAD_X_NEG);
					int y = yCoord + (worldObj.rand.nextInt(MOSS_SPREAD_Y_POS - MOSS_SPREAD_Y_NEG + 1) + MOSS_SPREAD_Y_NEG);
					int z = zCoord + (worldObj.rand.nextInt(MOSS_SPREAD_Z_POS - MOSS_SPREAD_Z_NEG + 1) + MOSS_SPREAD_Z_NEG);
					int lightLevel = worldObj.getBlockLightValue(x,y+1,z);

					if(!worldObj.isAirBlock(x, y, z) && worldObj.getTopSolidOrLiquidBlock(x, z) > y && lightLevel >= 9 && lightLevel <= 11)
					{
						Block selected = worldObj.getBlock(x, y, z);
						int meta = worldObj.getBlockMetadata(x, y, z);

						if (selected == Blocks.stonebrick && meta == 0)
						{
							worldObj.setBlock(x, y, z, Blocks.stonebrick, 1, 3);
							drain(ForgeDirection.DOWN, 100, true);
						}

						if (selected == Blocks.cobblestone)
						{
							worldObj.setBlock(x, y, z, Blocks.mossy_cobblestone, 0, 3);
							drain(ForgeDirection.DOWN, 100, true);
						}
					}
				}
			}

			//LAVA!
			if (fluid.fluidID == FluidRegistry.LAVA.getID())
			{
				//Burn the barrel it is flammable.
				if(worldObj.getBlock(xCoord, yCoord, zCoord).getMaterial().getCanBurn())
				{
					timer++;
					if (timer % 30 == 0)
					{
						worldObj.spawnParticle("largesmoke", (double)xCoord + Math.random(), (double)yCoord + 1.2D, (double)zCoord + Math.random(), 0.0D, 0.0D, 0.0D);
					}

					if (timer % 5 == 0)
					{
						worldObj.spawnParticle("smoke", (double)xCoord + Math.random(), (double)yCoord + 1.2D, (double)zCoord + Math.random(), 0.0D, 0.0D, 0.0D);
					}

					if (timer >= 400)
					{
						timer = 0;
						if (fluid.amount < 1000)
						{
							//burn
							worldObj.setBlock(xCoord, yCoord + 2, zCoord, Blocks.fire);
							return;
						}
						else
						{
							//spit lava on the ground
							worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.lava, 0, 3);
							return;
						}	
					}
				}

				//Turn into obsidian
				if (isFull() && worldObj.getBlock(xCoord, yCoord + 1, zCoord) == FluidRegistry.WATER.getBlock())
				{
					mode = BarrelMode.OBSIDIAN;
				}
			}
			break;

		case COMPOST:
			if (volume >= 1.0F)
			{
				timer++;

				//Change color
				Color colorDirt = ColorRegistry.color("dirt");
				color = Color.average(colorBase, colorDirt, (float)timer / (float)MAX_COMPOSTING_TIME);

				//Are we done yet?
				if(timer >= TileEntityBarrel.MAX_COMPOSTING_TIME)
				{
					mode = BarrelMode.DIRT;
					timer = 0;
					color = ColorRegistry.color("white");
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
			}
			break;

		case MILKED:
			timer++;

			Color colorSlime = ColorRegistry.color("water_slime_offset");
			color = Color.average(colorBase, colorSlime, (float)timer / (float)MAX_COMPOSTING_TIME);

			if (isDone())
			{
				timer = 0;
				mode = BarrelMode.SLIME;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
			break;

		case SLIME:
			if(worldObj.difficultySetting.getDifficultyId() > 0)
			{
				timer++;


				if(isDone())
				{
					timer = 0;

					if(!worldObj.isRemote)
					{
						EntitySlime slime = new EntitySlime(worldObj);
						slime.setPosition(xCoord, yCoord + 1, zCoord);

						worldObj.spawnEntityInWorld(slime);
					}

					resetBarrel();
				}
			}

			break;

		case SPORED:
			int nearbyMycelium = getNearbyBlocks(Blocks.mycelium, 0);

			timer += 1 + (nearbyMycelium / 2);

			Color colorWitchy = ColorRegistry.color("water_witchy_offset");
			color = Color.average(colorBase, colorWitchy, (float)timer / (float)MAX_COMPOSTING_TIME);

			if(!worldObj.isRemote && nearbyMycelium > 0)
			{
				//Spawn Mushrooms
				for (int x = -2; x <= 2; x++)
				{
					for (int y = -1; y <= 1; y++)
					{
						for (int z = -2; z <= 2; z++)
						{
							if(worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z) == Blocks.mycelium && worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) && worldObj.rand.nextInt(1500) == 0)
							{
								int choice = worldObj.rand.nextInt(2);

								if (choice == 0)
									worldObj.setBlock(xCoord + x, yCoord + y + 1, zCoord + z, Blocks.brown_mushroom, 0, 3);
								if (choice == 1)
									worldObj.setBlock(xCoord + x, yCoord + y + 1, zCoord + z, Blocks.red_mushroom, 0, 3);
							}
						}
					}
				}
			}

			if (isDone())
			{
				timer = 0;
				fluid = FluidRegistry.getFluidStack("witchwater", fluid.amount);
				mode = BarrelMode.FLUID;

				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
			break;

			//BLAZE
		case BLAZE_COOKING:
			timer++;

			if (!worldObj.isRemote && worldObj.getBlock(xCoord, yCoord, zCoord).getMaterial().getCanBurn())
			{
				//an earth-shattering kaboom...
				worldObj.func_147480_a(xCoord, yCoord, zCoord, false);
				this.worldObj.createExplosion(null, xCoord, yCoord, zCoord, 4.0f, true);
			}

			if (worldObj.isRemote && worldObj.rand.nextInt(20) == 0)
			{
				//spawn lava particles
				this.worldObj.spawnParticle("lava", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, 0.0d, 0.0d, 0.0d);
			}

			if (timer >= (int)(0.7 * MAX_COMPOSTING_TIME) && worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))
			{
				//Spawn fire!
				worldObj.setBlock(xCoord, yCoord+1, zCoord, Blocks.fire);
			}

			if(isDone())
			{
				this.mode = BarrelMode.BLAZE;
				timer = 0;
			}
			break;

		case BLAZE:
			if (worldObj.isRemote)
			{
				if (worldObj.rand.nextInt(5) == 0)
				{
					//spawn lava particles
					this.worldObj.spawnParticle("lava", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, 0.0d, 0.0d, 0.0d);

				}
			}

			if (!worldObj.isRemote && worldObj.difficultySetting.getDifficultyId() > 0)
			{
				if(isDone())
				{
					timer = 0;
					resetBarrel();
					break;
				}

				//Try to spawn blaze, if you can't keep trying.
				for (int x = -1; x <= 1; x++)
				{
					for (int y = -1; y <= 1; y++)
					{
						for (int z = -1; z <= 1; z++)
						{
							if (
									(worldObj.isAirBlock(xCoord + x, yCoord + y, zCoord + z) || worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z) == Blocks.fire) && 
									(worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) || worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z) == Blocks.fire) && 
									worldObj.rand.nextInt(10) == 0 && !isDone())
							{
								timer = MAX_COMPOSTING_TIME;

								EntityBlaze blaze = new EntityBlaze(worldObj);
								blaze.setPosition(xCoord + x + 0.5d, yCoord + y, zCoord + z + 0.5d);

								worldObj.spawnEntityInWorld(blaze);
							}
						}
					}
				}
			}

			break;

			//ENDER
		case ENDER_COOKING:
			timer++;

			if (worldObj.isRemote && worldObj.rand.nextInt(20) == 0)
			{
				//spawn ender particles
				float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				this.worldObj.spawnParticle("portal", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, (double)f, (double)f1, (double)f2);
			}

			if(isDone())
			{
				this.mode = BarrelMode.ENDER;
				timer = 0;
			}
			break;

		case ENDER:
			if (worldObj.isRemote && worldObj.rand.nextInt(5) == 0)
			{
				//spawn ender particles
				float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				this.worldObj.spawnParticle("portal", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, (double)f, (double)f1, (double)f2);
			}

			if (!worldObj.isRemote && worldObj.difficultySetting.getDifficultyId() > 0)
			{
				if(isDone())
				{
					timer = 0;
					resetBarrel();
					break;
				}

				//Try to spawn enderman, if you can't keep trying.
				for (int x = -1; x <= 1; x++)
				{
					for (int y = -1; y <= 1; y++)
					{
						for (int z = -1; z <= 1; z++)
						{
							if (
									worldObj.isAirBlock(xCoord + x, yCoord + y, zCoord + z) && 
									worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) && 
									worldObj.isAirBlock(xCoord + x, yCoord + y + 2, zCoord + z) &&
									worldObj.rand.nextInt(10) == 0 && !isDone())
							{
								timer = MAX_COMPOSTING_TIME;

								EntityEnderman enderman = new EntityEnderman(worldObj);
								enderman.setPosition(xCoord + x + 0.5d, yCoord + y, zCoord + z + 0.5d);

								worldObj.spawnEntityInWorld(enderman);
							}
						}
					}
				}
			}

			break;

		default:
			break;
		}
	}

	public boolean addCompostItem(Compostable item)
	{
		if (mode == BarrelMode.EMPTY)
		{
			mode = BarrelMode.COMPOST;
			timer = 0;
		}

		if (mode == BarrelMode.COMPOST && volume < 1.0f)
		{
			volume += item.value;

			if (volume > 1.0f)
			{
				volume = 1.0f;
			}

			//Calculate the average of the colors
			float weightA = item.value / volume;
			float weightB = 1.0f - weightA;

			float r = weightA * item.color.r + weightB * color.r;
			float g = weightA * item.color.g + weightB * color.g;
			float b = weightA * item.color.b + weightB * color.b;
			float a = weightA * item.color.a + weightB * color.a;

			color = new Color(r,g,b,a);

			//Set the starting color that will be used in the cooking process.
			if (volume == 1.0f)
			{
				colorBase = color;
			}

			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			//needsUpdate = true;
			return true;
		}
		else
		{
			return false;
		}
	}	

	public boolean isFull()
	{
		if (volume >= 1.0f)
		{
			return true;
		}else
		{
			return false;
		}
	}

	public boolean isDone()
	{
		return timer >= MAX_COMPOSTING_TIME;
	}

	public void resetColor()
	{
		colorBase = ColorRegistry.color("white");
		color = ColorRegistry.color("white");
	}

	public void giveAppropriateItem()
	{
		giveItem(getExtractItem());
	}

	private void giveItem(ItemStack item)
	{
		if(!worldObj.isRemote)
		{
			EntityItem entityitem = new EntityItem(worldObj, (double)xCoord + 0.5D, (double)yCoord + 1.5D, (double)zCoord + 0.5D, item);

			double f3 = 0.05F;
			entityitem.motionX = worldObj.rand.nextGaussian() * f3;
			entityitem.motionY = (0.2d);
			entityitem.motionZ = worldObj.rand.nextGaussian() * f3;

			worldObj.spawnEntityInWorld(entityitem);

			timer = 0;
		}

		resetBarrel();
	}

	private ItemStack getExtractItem()
	{
		//XXX getExtractItem
		switch (mode)
		{
		case CLAY:
			return new ItemStack(Blocks.clay, 1, 0);

		case DIRT:
			return new ItemStack(Blocks.dirt, 1, 0);

		case ENDSTONE:
			return new ItemStack(Blocks.end_stone, 1, 0);

		case NETHERRACK:
			return new ItemStack(Blocks.netherrack, 1, 0);

		case SLIME:
			return new ItemStack(Items.slime_ball, 1 + worldObj.rand.nextInt(4));

		case SOULSAND:
			return new ItemStack(Blocks.soul_sand, 1, 0);

		case OBSIDIAN:
			return new ItemStack(Blocks.obsidian, 1, 0);

		case COBBLESTONE:
			return new ItemStack(Blocks.cobblestone, 1, 0);

		case BLAZE:
			return new ItemStack(Items.blaze_rod, 1, 0);

		case ENDER:
			return new ItemStack(Items.ender_pearl, 1, 0);
			
		case BEETRAP:
			return new ItemStack(ENBlocks.BeeTrapTreated, 1, 0);

		default:
			return null;
		}
	}

	public float getAdjustedVolume()
	{
		float capacity = MAX_RENDER_CAPACITY - MIN_RENDER_CAPACITY;
		float adjusted = volume * capacity;		
		adjusted += MIN_RENDER_CAPACITY;
		return adjusted;
	}

	private void resetBarrel()
	{
		fluid = new FluidStack(FluidRegistry.WATER, 0);
		volume = 0;
		color = ColorRegistry.color("white");
		colorBase = ColorRegistry.color("white");
		mode = BarrelMode.EMPTY;
		needsUpdate = true;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		switch (compound.getInteger("mode"))
		{
		case 0:
			mode = BarrelMode.EMPTY;
			break;

		case 1:
			mode = BarrelMode.FLUID;
			break;

		case 2:
			mode = BarrelMode.COMPOST;
			break;

		case 3:
			mode = BarrelMode.DIRT;
			break;	

		case 4:
			mode = BarrelMode.CLAY;
			break;

		case 5:
			mode = BarrelMode.SPORED;
			break;

		case 6:
			mode = BarrelMode.SLIME;
			break;

		case 7:
			mode = BarrelMode.NETHERRACK;
			break;	

		case 8:
			mode = BarrelMode.ENDSTONE;
			break;	

		case 9:
			mode = BarrelMode.MILKED;
			break;	

		case 10:
			mode = BarrelMode.SOULSAND;
			break;	

		case 11:
			mode = BarrelMode.BEETRAP;
			break;

		case 12:
			mode = BarrelMode.OBSIDIAN;
			break;

		case 13:
			mode = BarrelMode.COBBLESTONE;
			break;

		case 14:
			mode = BarrelMode.BLAZE_COOKING;
			break;

		case 15:
			mode = BarrelMode.BLAZE;
			break;

		case 16:
			mode = BarrelMode.ENDER_COOKING;
			break;

		case 17:
			mode = BarrelMode.ENDER;
			break;
		}

		volume = compound.getFloat("volume");
		timer = compound.getInteger("timer");

		color = new Color(compound.getInteger("color"));
		colorBase = new Color (compound.getInteger("colorBase"));
		fluid = new FluidStack(FluidRegistry.getFluid(compound.getShort("fluid")), (int)(volume * MAX_FLUID));
		needsUpdate = true;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("mode", mode.value);
		compound.setFloat("volume", volume);
		compound.setInteger("timer", timer);
		compound.setInteger("color", color.toInt());
		compound.setInteger("colorBase", colorBase.toInt());
		compound.setShort("fluid", (short)fluid.fluidID);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, BlockData.BARREL_ID, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.func_148857_g();
		readFromNBT(tag);
	}



	//IFluidHandler!	
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		//Simulate the fill to see if there is room for incoming liquids.
		int capacity = MAX_FLUID - fluid.amount;

		if (!doFill)
		{
			if (mode == BarrelMode.EMPTY)
			{
				return resource.amount;
			}

			if (mode == BarrelMode.FLUID && resource.fluidID == fluid.fluidID)
			{
				if (capacity >= resource.amount)
				{
					return resource.amount;
				}else
				{
					return capacity;
				}
			}
		}else
			//Really fill the barrel.
		{
			if (mode == BarrelMode.EMPTY)
			{
				if (resource.fluidID != fluid.fluidID)
				{
					fluid =  new FluidStack(FluidRegistry.getFluid(resource.fluidID),resource.amount);
				}else
				{
					fluid.amount = resource.amount;
				}
				mode = BarrelMode.FLUID;
				volume = (float)fluid.amount / (float)MAX_FLUID;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				//needsUpdate = true;
				return resource.amount;
			}

			if (mode == BarrelMode.FLUID && resource.fluidID == fluid.fluidID)
			{
				if (capacity >= resource.amount)
				{
					fluid.amount += resource.amount;
					volume = (float)fluid.amount / (float)MAX_FLUID;
					//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
					needsUpdate = true;
					return resource.amount;
				}else
				{
					fluid.amount = MAX_FLUID;
					volume = 1.0f;
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
					//needsUpdate = true;
					return capacity;
				}
			}
		}

		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (resource == null || mode != BarrelMode.FLUID || !resource.isFluidEqual(fluid))
			return null;

		if (!doDrain)
		{
			if (fluid.amount >= resource.amount)
			{
				FluidStack simulated = new FluidStack(FluidRegistry.getFluid(resource.fluidID),resource.amount);
				return simulated;
			}else
			{
				FluidStack simulated = new FluidStack(FluidRegistry.getFluid(resource.fluidID),fluid.amount);
				return simulated;
			}
		}else
		{
			if (fluid.amount > resource.amount)
			{
				FluidStack drained = new FluidStack(FluidRegistry.getFluid(resource.fluidID),resource.amount);
				fluid.amount -= resource.amount;
				volume = (float)fluid.amount / (float)MAX_FLUID;
				//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = true;
				//System.out.println("A Server: " + worldObj.isRemote + ". Amount: " + fluid.amount);
				return drained;
			}else
			{
				FluidStack drained = new FluidStack(FluidRegistry.getFluid(resource.fluidID),fluid.amount);
				fluid.amount = 0;
				volume = 0;
				mode = BarrelMode.EMPTY;
				timer = 0;
				//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = true;
				//System.out.println("A Server: " + worldObj.isRemote + ". Amount: " + fluid.amount);
				return drained;
			}
		}
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (mode != BarrelMode.FLUID)
			return null;

		if (!doDrain)
		{
			if (fluid.amount >= maxDrain)
			{
				FluidStack simulated = new FluidStack(FluidRegistry.getFluid(fluid.fluidID),maxDrain);
				return simulated;
			}else
			{
				FluidStack simulated = new FluidStack(FluidRegistry.getFluid(fluid.fluidID),fluid.amount);
				return simulated;
			}
		}else
		{
			if (fluid.amount > maxDrain)
			{
				FluidStack drained = new FluidStack(FluidRegistry.getFluid(fluid.fluidID),maxDrain);
				fluid.amount -= maxDrain;
				volume = (float)fluid.amount / (float)MAX_FLUID;
				//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = true;
				//System.out.println("B Server: " + worldObj.isRemote + ". Amount: " + fluid.amount);
				return drained;
			}else
			{
				FluidStack drained = new FluidStack(FluidRegistry.getFluid(fluid.fluidID),fluid.amount);
				fluid.amount = 0;
				volume = 0;
				mode = BarrelMode.EMPTY;
				timer = 0;
				//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = true;
				//System.out.println("B Server: " + worldObj.isRemote + ". Amount: " + fluid.amount);
				return drained;
			}
		}
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		FluidTankInfo info = new FluidTankInfo(fluid, MAX_FLUID);
		FluidTankInfo[] array =  new FluidTankInfo[1];
		array[0] = info;
		return array;
	}

	public int getNearbyBlocks(Block block, int blockMeta)
	{
		int count = 0;

		for (int x = -1; x <= 1; x++)
		{
			for (int y = -1; y <= 1; y++)
			{
				for (int z = -1; z <= 1; z++)
				{
					if(worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z) == block && worldObj.getBlockMetadata(xCoord + x, yCoord + y, zCoord + z) == blockMeta)
					{
						count++;
					}
				}
			}
		}

		return count;
	}

	public int getLightLevel()
	{
		if (mode == BarrelMode.FLUID)
		{
			return fluid.getFluid().getLuminosity();
		}

		if(mode == BarrelMode.BLAZE || mode == BarrelMode.BLAZE_COOKING)
		{
			return 15;
		}

		return 0;
	}



	//ISidedInventory!
	@Override
	public int getSizeInventory() {
		return 2;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		if (slot == 0)
		{
			return getExtractItem();
		}

		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (slot == 0)
		{
			ItemStack item = getExtractItem();

			resetBarrel();
			return item;
		}

		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack item) {
		//XXX addItemFromPipe
		if (slot == 0)
		{
			if (item == null)
			{
				resetBarrel();
			}
		}

		if (slot == 1)
		{
			if (mode == BarrelMode.COMPOST || mode == BarrelMode.EMPTY)
			{
				if(CompostRegistry.containsItem(Item.getIdFromItem(item.getItem()), item.getItemDamage()))
				{
					this.addCompostItem(CompostRegistry.getItem(Item.getIdFromItem(item.getItem()), item.getItemDamage()));
				}
			}

			if(mode == BarrelMode.FLUID && this.isFull())
			{
				if(fluid.fluidID == FluidRegistry.WATER.getID())
				{
					if (ModData.ALLOW_BARREL_RECIPE_CLAY && Block.getBlockFromItem(item.getItem()) == ENBlocks.Dust)
					{
						this.mode = BarrelMode.CLAY;
					}
				}

				if(fluid.fluidID == FluidRegistry.LAVA.getID())
				{
					if (ModData.ALLOW_BARREL_RECIPE_NETHERRACK && item.getItem() == Items.redstone)
					{
						this.mode = BarrelMode.NETHERRACK;
					}

					if (ModData.ALLOW_BARREL_RECIPE_ENDSTONE && item.getItem() == Items.glowstone_dust)
					{
						this.mode = BarrelMode.ENDSTONE;
					}

					if(ModData.ALLOW_BARREL_RECIPE_BLAZE_RODS && item.getItem() == ENItems.DollAngry)
					{
						mode = BarrelMode.BLAZE_COOKING;
					}
				}

				if (fluid.fluidID == Fluids.fluidWitchWater.getID())
				{
					if(ModData.ALLOW_BARREL_RECIPE_SOULSAND && Block.getBlockFromItem(item.getItem()) == Blocks.sand)
					{
						resetColor();
						mode = BarrelMode.SOULSAND;
					}

					if(ModData.ALLOW_BARREL_RECIPE_ENDER_PEARLS && item.getItem() == ENItems.DollCreepy)
					{
						mode = BarrelMode.ENDER_COOKING;
					}
				}
				
				Fluid seedOil = FluidRegistry.getFluid("seedoil");
				if (seedOil != null && fluid.fluidID == seedOil.getID())
				{
					mode = BarrelMode.BEETRAP;
				}
			}
		}

		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return false;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {	
		if (slot == 1)
		{
			return isItemValid(item);
		}

		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		if (side == 0)
		{
			return new int[]{0};
		}else if (side == 1)
		{
			return new int[]{1};
		}

		return new int[0];
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side) {
		if (side == 1 && slot == 1)
		{
			return isItemValid(item);
		}

		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) {
		if (side == 0 && slot == 0)
		{
			if (mode.canExtract == ExtractMode.Always)
			{
				return true;
			}

			if (worldObj.difficultySetting.equals(0) && mode.canExtract == ExtractMode.PeacefulOnly)
			{
				return true;
			}
		}

		return false;
	}

	public boolean isItemValid(ItemStack item)
	{
		///XXX isItemValid
		if (!this.isFull() && mode == BarrelMode.COMPOST || mode == BarrelMode.EMPTY)
		{
			if(ModData.ALLOW_BARREL_RECIPE_DIRT && CompostRegistry.containsItem(Item.getIdFromItem(item.getItem()), item.getItemDamage()))
			{
				return true;
			}
		}

		if(mode == BarrelMode.FLUID && this.isFull())
		{
			if(fluid.fluidID == FluidRegistry.WATER.getID())
			{
				if (ModData.ALLOW_BARREL_RECIPE_CLAY && Block.getBlockFromItem(item.getItem()) == ENBlocks.Dust)
				{
					return true;
				}
			}


			if(fluid.fluidID == FluidRegistry.LAVA.getID())
			{
				if (ModData.ALLOW_BARREL_RECIPE_NETHERRACK && item.getItem() == Items.redstone)
				{
					return true;
				}

				if (ModData.ALLOW_BARREL_RECIPE_ENDSTONE && item.getItem() == Items.glowstone_dust)
				{
					return true;
				}

				if(ModData.ALLOW_BARREL_RECIPE_BLAZE_RODS && item.getItem() == ENItems.DollAngry)
				{
					return true;
				}
			}


			if (fluid.fluidID == Fluids.fluidWitchWater.getID())
			{
				if(ModData.ALLOW_BARREL_RECIPE_SOULSAND && Block.getBlockFromItem(item.getItem()) == Blocks.sand)
				{
					return true;
				}

				if(ModData.ALLOW_BARREL_RECIPE_ENDER_PEARLS && item.getItem() == ENItems.DollCreepy)
				{
					return true;
				}
			}
			
			Fluid seedOil = FluidRegistry.getFluid("seedoil");
			if (seedOil != null && fluid.fluidID == seedOil.getID() && Block.getBlockFromItem(item.getItem()) == ENBlocks.BeeTrap)
			{
				return true;
			}
		}

		return false;
	}
}
