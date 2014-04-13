package exnihilo.compatibility;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
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
		Block rubberSapling = GameRegistry.findBlock("MineFactoryReloaded", "rubberSapling");

		if (rubberSapling != null)
		{
			ItemSeedRubber.saplings.add(rubberSapling);
		}

		SieveRegistry.register(Blocks.dirt, 0, ENItems.SeedsRubber, 0, 45);
	}
}
