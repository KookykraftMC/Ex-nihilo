package exnihilo.blocks.tileentities;

import exnihilo.ENBlocks;
import exnihilo.blocks.tileentities.TileEntityCrucible.CrucibleMode;
import exnihilo.compatibility.foresty.Forestry;
import exnihilo.compatibility.foresty.Hive;
import exnihilo.compatibility.foresty.HiveRegistry;
import exnihilo.compatibility.foresty.Surrounding;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityBeeTrap extends TileEntity {
	private Surrounding blocks = new Surrounding();
	private static int TIMER_MAX = 6000;
	private int timer = 0;

	private static final int MAX_X = 2;
	private static final int MIN_X = -2;
	private int x = MIN_X;

	private static final int MAX_Y = 2;
	private static final int MIN_Y = -2;
	private int y = MIN_Y;

	private static final int MAX_Z = 2;
	private static final int MIN_Z = -2;
	private int z = MIN_Z;
	
	//Spawn chance, higher = more rare.
	private static final int HIVE_SPAWN_CHANCE = 60;
	
	private boolean complete = false;

	@Override
	public void updateEntity()
	{
		if (!worldObj.isRemote && Forestry.isLoaded())
		{
			timer++;
			
			if ((float)timer / (float)TIMER_MAX > 0.6f)
			{
				//Scan one block per tick. Nice and slow. No lag.
				if (x > MAX_X)
				{
					x = MIN_X;
					y++;
				}

				if(y > MAX_Y)
				{
					y = MIN_Y;
					z++;
				}

				if(z > MAX_Z)
				{
					z = MIN_Z;
					complete = true;
				}
			}
			
			if (complete)
			{
				boolean canSeeSky = yCoord >= worldObj.getTopSolidOrLiquidBlock(xCoord, zCoord) - 1;
				BiomeGenBase biome = worldObj.getBiomeGenForCoords(xCoord, zCoord);
				
				//check to see if the current location meets the requirements for a hive to spawn.
				Hive hive = HiveRegistry.getHive(biome, blocks, canSeeSky, yCoord);
				
				//If hive != null, replace this block with the returned hive.
				if (hive != null && worldObj.rand.nextInt(HIVE_SPAWN_CHANCE - Math.min(30, hive.getSpawnChanceModifier(blocks))) == 0)
				{
					worldObj.setBlock(xCoord, yCoord, zCoord, hive.blockID, hive.meta, 3);
				}else
				{
					//Reset the scanner if spawning failed.
					blocks = new Surrounding();
					complete = false;
				}
			}else
			{
				//scan not complete, continue scanning.
				int blockID = worldObj.getBlockId(xCoord + x, yCoord + y,zCoord + z);
				int meta = worldObj.getBlockMetadata(xCoord + x, yCoord + y,zCoord + z);
				
				blocks.addBlock(blockID, meta);
				if (x == 0 && y == 1 && z == 0)
				{
					blocks.setBlockAbove(blockID, meta);
				}
				
				x++;
			}
			
			//If the timer expires, then we require re-treatment with seed oil.
			if (timer > TIMER_MAX)
			{
				worldObj.setBlock(xCoord, yCoord, zCoord, ENBlocks.BeeTrap.blockID, 0, 3);
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		timer = compound.getInteger("timer");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("timer", timer);
	}
}
