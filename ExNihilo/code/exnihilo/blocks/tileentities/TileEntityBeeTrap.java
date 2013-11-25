package exnihilo.blocks.tileentities;

import exnihilo.compatibility.foresty.Forestry;
import exnihilo.compatibility.foresty.Hive;
import exnihilo.compatibility.foresty.HiveRegistry;
import exnihilo.compatibility.foresty.Surrounding;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBeeTrap extends TileEntity {
	private Surrounding blocks = new Surrounding();

	private final int MAX_X = 2;
	private final int MIN_X = -2;
	private int x = MIN_X;

	private final int MAX_Y = 2;
	private final int MIN_Y = -2;
	private int y = MIN_Y;

	private final int MAX_Z = 2;
	private final int MIN_Z = -2;
	private int z = MIN_Z;
	
	private boolean complete = false;

	@Override
	public void updateEntity()
	{
		if (!worldObj.isRemote && Forestry.isLoaded())
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
			
			if (complete)
			{
				System.out.println("Scan completed!");
				//Call get hive. 

				Hive hive = HiveRegistry.getHive(worldObj.getBiomeGenForCoords(xCoord, zCoord), blocks, worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord));
				//If hive != null, replace this block with the returned hive.
				if (hive != null)
				{
					worldObj.setBlock(xCoord, yCoord, zCoord, hive.blockID, hive.meta, 3);
				}else
				{
					System.out.println("Hive was null.");
				}
				
				//Reset the scanner if spawning failed.
				blocks = new Surrounding();
				complete = false;
			}else
			{
				blocks.addBlock(worldObj.getBlockId(xCoord + x, yCoord + y,zCoord + z), worldObj.getBlockMetadata(xCoord + x, yCoord + y,zCoord + z));
				x++;
			}
		}
	}
}
