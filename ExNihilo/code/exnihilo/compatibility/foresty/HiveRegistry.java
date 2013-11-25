package exnihilo.compatibility.foresty;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.world.biome.BiomeGenBase;

public class HiveRegistry {
	public static Map<String, Hive> hives = new HashMap<String, Hive>();

	public static void registerHive(Hive hive)
	{
		hives.put(hive.blockID + ":" + hive.meta, hive);
	}

	public static Hive getHive(BiomeGenBase biome, Surrounding local, boolean canSeeSky, int height)
	{
		Iterator it = hives.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();

			Hive hive = (Hive)pairs.getValue();

			if (hive != null)
			{
				if (hive.areAllRequirementsMet(biome, local, canSeeSky, height))
				{
					return hive;
				}else
				{
					System.out.println("Hive found, but requirements are not met.");
				}
			}
		}
		System.out.println("Unable to locate appropriate hive");

		return null;
	}
	
	public static void registerForestryHives()
	{
		boolean hivesFound = (HiveList.generateForestryHives());
		
		if (hivesFound)
		{
			registerHive(HiveList.forest);
			registerHive(HiveList.meadow);
			registerHive(HiveList.desert);
		}
	}
}
