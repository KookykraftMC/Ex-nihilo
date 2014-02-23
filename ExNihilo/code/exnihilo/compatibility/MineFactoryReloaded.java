package exnihilo.compatibility;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.items.seeds.ItemSeedRubber;
import exnihilo.registries.SieveRegistry;

public class MineFactoryReloaded {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("MineFactoryReloaded");
	}
	
	public static void loadCompatibility()
	{
		//TODO Find the MFR rubber tree sapling and add it to the ItemSeedRubber saplings list.
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
		else
		{
			System.out.println("Couldn't find MFR rubber saplings!");
			//CommonOre.dumpUnlocalizedNames("rubber");
		}
		
		SieveRegistry.dropRubberSeeds = true;
	}
}
