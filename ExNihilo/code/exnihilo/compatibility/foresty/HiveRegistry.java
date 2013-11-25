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

	public static Hive getHive(BiomeGenBase biome, Surrounding local, boolean canSeeSky)
	{
		Iterator it = hives.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();

			Hive hive = (Hive)pairs.getValue();

			if (hive != null)
			{
				if (hive.areAllRequirementsMet(biome, local, canSeeSky))
				{
					return hive;
				}else
				{
					System.out.println("Hive found, but requirements are not met.");
				}
			}else
			{
				System.out.println("Unable to locate hive");
			}


		}

		return null;
	}
}
