package exnihilo.compatibility;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.SieveRegistry;

public class Chococraft {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("chococraft");
	}

	public static void loadCompatibility()
	{	
		Item gysahlSeeds = GameRegistry.findItem("chococraft", "item.gysahl_seeds");

		if (gysahlSeeds != null)
		{
			SieveRegistry.register(Blocks.dirt, 0, gysahlSeeds, 0, 32);
		}
	}
}