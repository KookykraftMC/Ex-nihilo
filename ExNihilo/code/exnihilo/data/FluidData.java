package exnihilo.data;

import net.minecraftforge.common.Configuration;

public class FluidData {
	public static String CATEGORY_FLUIDS = "fluid blocks";
	
	public static int WITCHWATER_ID = 3200;
	public static final String WITCHWATER_KEY = "witchwater";
	public static final String WITCHWATER_UNLOCALIZED_NAME = "witchwater";
	public static final String WITCHWATER_NAME = "Witch Water";
	
	public static void load(Configuration config)
	{
		WITCHWATER_ID = config.getBlock(CATEGORY_FLUIDS, WITCHWATER_KEY, WITCHWATER_ID).getInt();
	}
}
