package exnihilo.compatibility;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.Items;
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
		
		for (Block b : Block.blocksList)
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
		
		SieveRegistry.register(Block.dirt.blockID, 0, Items.SeedsRubber.itemID, 0, 64);
	}
}
