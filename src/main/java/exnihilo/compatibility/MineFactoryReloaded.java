package exnihilo.compatibility;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.items.seeds.ItemSeedRubber;

public class MineFactoryReloaded {
	
	public static void loadCompatibility()
	{
		Block rubberSapling = GameRegistry.findBlock("MineFactoryReloaded", "tile.mfr.rubberwood.sapling");

		if (rubberSapling != null)
		{
			ItemSeedRubber.AddSapling(rubberSapling);
		}
	}
}
