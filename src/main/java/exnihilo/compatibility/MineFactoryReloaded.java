package exnihilo.compatibility;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Loader;
import exnihilo.ENItems;
import exnihilo.items.seeds.ItemSeedRubber;
import exnihilo.registries.SieveRegistry;

public class MineFactoryReloaded {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("MineFactoryReloaded");
	}
	
	public static void loadCompatibility()
	{
		Block rubberSapling = null;
		
		for (Block b : Block.blockRegistry)
		{
			if (b != null)
			{
				if (b.getClass().getName().equals("powercrystals.minefactoryreloaded.block.BlockRubberSapling"))
				{
					rubberSapling = b;
					break;
				}
			}
		}
		
		if (rubberSapling != null)
		{
			ItemSeedRubber.saplings.add(rubberSapling);
		}
		
		SieveRegistry.register(Blocks.dirt, 0, ENItems.SeedsRubber, 0, 45);
	}
}
