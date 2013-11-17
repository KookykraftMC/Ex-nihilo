package exnihilo;

import exnihilo.world.WorldProviderDefaultVoid;
import exnihilo.world.WorldProviderEndVoid;
import exnihilo.world.WorldProviderHellVoid;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;

public class World {
	private static String CATEGORY_WORLDGEN_OPTIONS = "void generation options";
	
	public static boolean hijackOverworld;
	public static boolean hijackNether;
	public static boolean hijackEnd;
	
	public static void load(Configuration config)
	{
		//TODO: Load config settings.
		hijackOverworld = config.get(CATEGORY_WORLDGEN_OPTIONS, "overworld", false).getBoolean(false);
		hijackNether = config.get(CATEGORY_WORLDGEN_OPTIONS, "nether", false).getBoolean(false);
		hijackEnd = config.get(CATEGORY_WORLDGEN_OPTIONS, "end", false).getBoolean(false);
	}
	
	public static void registerWorldProviders()
	{
		if (hijackNether)
		{
			DimensionManager.unregisterProviderType(-1);
			DimensionManager.registerProviderType(-1, WorldProviderHellVoid.class, true);
		}
		
		if (hijackOverworld)
		{
			DimensionManager.unregisterProviderType(0);
			DimensionManager.registerProviderType(0, WorldProviderDefaultVoid.class, true);
		}
		
		if (hijackEnd)
		{
			DimensionManager.unregisterProviderType(1);
			DimensionManager.registerProviderType(1, WorldProviderEndVoid.class, true);
		}
	}
}
