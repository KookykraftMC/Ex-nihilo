package exnihilo.data;

import net.minecraftforge.common.Configuration;

public class WorldData {
	private static String CATEGORY_WORLDGEN_OPTIONS = "void generation options";
	
	public static boolean hijackOverworld;
	public static boolean hijackNether;
	public static boolean hijackEnd;
	
	public static boolean allowNetherFortresses;
	
	public static void load(Configuration config)
	{
		//TODO: Load config settings.
		hijackOverworld = config.get(CATEGORY_WORLDGEN_OPTIONS, "overworld", false).getBoolean(false);
		hijackNether = config.get(CATEGORY_WORLDGEN_OPTIONS, "nether", false).getBoolean(false);
		hijackEnd = config.get(CATEGORY_WORLDGEN_OPTIONS, "end", false).getBoolean(false);
		
		allowNetherFortresses = config.get(CATEGORY_WORLDGEN_OPTIONS, "nether_fortresses", false).getBoolean(false);
	}
	
}
