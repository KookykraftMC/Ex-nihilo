package exnihilo.blocks.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.Blocks;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.helpers.Color;
import exnihilo.registries.helpers.Compostable;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityBarrel extends TileEntity implements IFluidHandler, ISidedInventory{	
	private static final float MIN_RENDER_CAPACITY = 0.1f;
	private static final float MAX_RENDER_CAPACITY = 0.9f;
	private static final int MAX_COMPOSTING_TIME = 1000;
	private static final int MAX_FLUID = 1000;
	private static final int UPDATE_INTERVAL = 10;

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
		WITCHY(11, ExtractMode.None),
		OBSIDIAN(12, ExtractMode.Always),
		COBBLESTONE(13, ExtractMode.Always);

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
	public Icon icon;

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
		//Check for updates
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
				if(!worldObj.isRemote && isFull() && ModData.ALLOW_BARREL_RECIPE_SOULSAND && getNearbyBlocks(Block.mycelium.blockID, 0) > 0)
				{
					colorBase = new Color(fluid.getFluid().getColor());
					mode = BarrelMode.SPORED;
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
				
				//Turn into cobblestone?
				if (isFull() && worldObj.getBlockId(xCoord, yCoord + 1, zCoord) == FluidRegistry.LAVA.getBlockID())
				{
					mode = BarrelMode.COBBLESTONE;
				}
			}

			//LAVA!
			if (fluid.fluidID == FluidRegistry.LAVA.getID())
			{
				//Burn the barrel it is flammable.
				if(worldObj.getBlockMaterial(xCoord, yCoord, zCoord).getCanBurn())
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
							worldObj.setBlock(xCoord, yCoord + 2, zCoord, Block.fire.blockID);
							return;
						}
						else
						{
							//spit lava on the ground
							worldObj.setBlock(xCoord, yCoord, zCoord, Block.lavaMoving.blockID, 0, 3);
							return;
						}	
					}
				}
				
				//Turn into obsidian
				if (isFull() && worldObj.getBlockId(xCoord, yCoord + 1, zCoord) == FluidRegistry.WATER.getBlockID())
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
				color = color.average(colorBase, colorDirt, (float)timer / (float)MAX_COMPOSTING_TIME);

				//Are we done yet?
				if(timer >= this.MAX_COMPOSTING_TIME)
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
			color = color.average(colorBase, colorSlime, (float)timer / (float)MAX_COMPOSTING_TIME);

			if (isDone())
			{
				timer = 0;
				mode = BarrelMode.SLIME;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
			break;

		case SLIME:
			if(worldObj.difficultySetting > 0)
			{
				timer++;
			}

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
			break;

		case SPORED:
			timer += 1 + (getNearbyBlocks(Block.mycelium.blockID, 0) / 2);

			Color colorWitchy = ColorRegistry.color("water_witchy_offset");
			color = color.average(colorBase, colorWitchy, (float)timer / (float)MAX_COMPOSTING_TIME);

			if(!worldObj.isRemote && getNearbyBlocks(Block.mycelium.blockID, 0) > 0)
			{
				//Spawn Mushrooms
				if (timer % 100 == 0)
				{
					for (int x = -2; x <= 2; x++)
					{
						for (int y = -1; y <= 1; y++)
						{
							for (int z = -2; z <= 2; z++)
							{
								if(worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z) == Block.mycelium.blockID && worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) && worldObj.rand.nextInt(300) == 0)
								{
									int choice = worldObj.rand.nextInt(2);

									if (choice == 0)
										worldObj.setBlock(xCoord + x, yCoord + y + 1, zCoord + z, Block.mushroomBrown.blockID, 0, 3);
									if (choice == 1)
										worldObj.setBlock(xCoord + x, yCoord + y + 1, zCoord + z, Block.mushroomRed.blockID, 0, 3);
								}
							}
						}
					}
				}

				if (timer % 200 == 0)
				{
					//Try to crack bricks
				}
			}

			if (isDone())
			{
				timer = 0;
				mode = BarrelMode.WITCHY;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
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
		float percentage = (float)timer / (float)MAX_COMPOSTING_TIME;

		if (percentage >= 1.0f)
		{
			return true;
		}else
		{
			return false;
		}
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
		//TODO - add more item modes.
		switch (mode)
		{
		case CLAY:
			return new ItemStack(Block.blockClay, 1, 0);

		case DIRT:
			return new ItemStack(Block.dirt, 1, 0);

		case ENDSTONE:
			return new ItemStack(Block.whiteStone, 1, 0);

		case NETHERRACK:
			return new ItemStack(Block.netherrack, 1, 0);

		case SLIME:
			return new ItemStack(Item.slimeBall, 1 + worldObj.rand.nextInt(4));

		case SOULSAND:
			return new ItemStack(Block.slowSand, 1, 0);
			
		case OBSIDIAN:
			return new ItemStack(Block.obsidian, 1, 0);
			
		case COBBLESTONE:
			return new ItemStack(Block.cobblestone, 1, 0);

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
		fluid.amount = 0;
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
			mode = BarrelMode.WITCHY;
			break;
			
		case 12:
			mode = BarrelMode.OBSIDIAN;
			break;
			
		case 13:
			mode = BarrelMode.COBBLESTONE;
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

		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, BlockData.BARREL_ID, tag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{
		NBTTagCompound tag = pkt.data;
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

	public int getNearbyBlocks(int blockID, int blockMeta)
	{
		int count = 0;

		for (int x = -1; x <= 1; x++)
		{
			for (int y = -1; y <= 1; y++)
			{
				for (int z = -1; z <= 1; z++)
				{
					if(worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z) == blockID && worldObj.getBlockMetadata(xCoord + x, yCoord + y, zCoord + z) == blockMeta)
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
		if (slot == 1)
		{
			if (mode == BarrelMode.COMPOST || mode == BarrelMode.EMPTY)
			{
				if(CompostRegistry.containsItem(item.itemID, item.getItemDamage()))
				{
					this.addCompostItem(CompostRegistry.getItem(item.itemID, item.getItemDamage()));
				}
			}

			if(mode == BarrelMode.FLUID && this.isFull())
			{
				if(fluid.fluidID == FluidRegistry.WATER.getID())
				{
					if (ModData.ALLOW_BARREL_RECIPE_CLAY && item.itemID == Blocks.Dust.blockID)
					{
						this.mode = BarrelMode.CLAY;
					}
				}

				if(fluid.fluidID == FluidRegistry.LAVA.getID())
				{
					if (ModData.ALLOW_BARREL_RECIPE_NETHERRACK && item.itemID == Item.redstone.itemID)
					{
						this.mode = BarrelMode.NETHERRACK;
					}

					if (ModData.ALLOW_BARREL_RECIPE_ENDSTONE && item.itemID == Item.glowstone.itemID)
					{
						this.mode = BarrelMode.ENDSTONE;
					}
				}
			}

			if (mode == BarrelMode.WITCHY)
			{
				if (ModData.ALLOW_BARREL_RECIPE_SOULSAND && item.itemID == Block.sand.blockID)
				{
					System.out.println("Inserting sand!");
					resetColor();
					this.mode = BarrelMode.SOULSAND;
				}
			}
		}
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		// TODO Auto-generated method stub		
		if (slot == 1)
		{
			return isItemValid(item);
		}

		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		if (side == 1 && slot == 1)
		{
			return isItemValid(item);
		}

		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) {
		// TODO Auto-generated method stub
		if (side == 0 && slot == 0)
		{
			if (mode.canExtract == ExtractMode.Always)
			{
				return true;
			}
			
			if (worldObj.difficultySetting == 0 && mode.canExtract == ExtractMode.PeacefulOnly)
			{
				return true;
			}
		}

		return false;
	}

	private boolean isItemValid(ItemStack item)
	{
		if (!this.isFull() && mode == BarrelMode.COMPOST || mode == BarrelMode.EMPTY)
		{
			if(ModData.ALLOW_BARREL_RECIPE_DIRT && CompostRegistry.containsItem(item.itemID, item.getItemDamage()))
			{
				return true;
			}
		}

		if(mode == BarrelMode.FLUID && this.isFull())
		{
			if(fluid.fluidID == FluidRegistry.WATER.getID())
			{
				if (ModData.ALLOW_BARREL_RECIPE_CLAY && item.itemID == Blocks.Dust.blockID)
				{
					return true;
				}
			}


			if(fluid.fluidID == FluidRegistry.LAVA.getID())
			{
				if (ModData.ALLOW_BARREL_RECIPE_NETHERRACK && item.itemID == Item.redstone.itemID)
				{
					return true;
				}

				if (ModData.ALLOW_BARREL_RECIPE_ENDSTONE && item.itemID == Item.glowstone.itemID)
				{
					return true;
				}
			}
		}

		if (mode == BarrelMode.WITCHY)
		{
			if (ModData.ALLOW_BARREL_RECIPE_SOULSAND && item.itemID == Block.sand.blockID)
			{
				return true;
			}
		}

		return false;
	}
}
