package exnihilo.data;

import net.minecraftforge.common.Configuration;

public class FluidData {
	public static String CATEGORY_FLUIDS = "fluid blocks";
	
	public static int WITCHWATER_ID = 3200;
	public static final String WITCHWATER_KEY = "witchwater";
	public static final String WITCHWATER_UNLOCALIZED_NAME = "witchwater";
	public static final String WITCHWATER_NAME = "Witch Water";
	
	//BUCKETS!
	public static final String CATEGORY_BUCKETS = "buckets";

	public static int BUCKET_WITCHWATER_ID = 9456;
	public static final String BUCKET_WITCHWATER_KEY = "bucket_witchwater";
	public static final String BUCKET_WITCHWATER_UNLOCALIZED_NAME = "bucket_witchwater";
	public static final String BUCKET_WITCHWATER_NAME = "Witch Water Bucket";
	
	public static void load(Configuration config)
	{
		WITCHWATER_ID = config.getBlock(CATEGORY_FLUIDS, WITCHWATER_KEY, WITCHWATER_ID).getInt();
		
		//BUCKETS!
		BUCKET_WITCHWATER_ID = config.getItem(CATEGORY_BUCKETS, BUCKET_WITCHWATER_UNLOCALIZED_NAME, BUCKET_WITCHWATER_ID).getInt() - 256;
	}
}
