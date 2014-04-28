package exnihilo.compatibility.foresty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import exnihilo.ExNihilo;

public class HiveRegistry {
	public static Map<String, Hive> hives = new HashMap<String, Hive>();
	public static Random rand = new Random();

	public static void registerHive(Hive hive)
	{
		hives.put(hive.block + ":" + hive.meta, hive);
	}

	@SuppressWarnings("rawtypes")
	public static Hive getHive(BiomeGenBase biome, Surrounding local, boolean canSeeSky, int height)
	{
		List<Hive> found = new ArrayList<Hive>();
		Iterator it = hives.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();

			Hive hive = (Hive)pairs.getValue();

			if (hive != null)
			{
				if (hive.areAllRequirementsMet(biome, local, canSeeSky, height))
				{
					found.add(hive);
					//return hive;
				}
				//System.out.println("Hive found, but requirements are not met.");
			}
		}
		
		if (!found.isEmpty())
		{
			int index = rand.nextInt(found.size());
			
			return found.get(index);
		}
		
		//System.out.println("Unable to locate appropriate hive");
		return null;
	}
	
	public static void registerHives()
	{
		ExNihilo.log.info("Beginning Hive Registry...");
		if (HiveList.generateForestryHives())
		{
			registerHive(HiveList.forest);
			registerHive(HiveList.meadow);
			registerHive(HiveList.desert);
			registerHive(HiveList.jungle);
			registerHive(HiveList.end);
			registerHive(HiveList.snow);
			registerHive(HiveList.swamp);
			ExNihilo.log.info("Sucessfully added Forestry Hives");
		}
		
//		if(HiveList.generateExtreBeesHives())
//		{
//			registerHive(HiveList.water);
//			registerHive(HiveList.rock);
//			registerHive(HiveList.nether);
//			
//			System.out.println("Ex Nihilo: Found Extra Bees!");
//		}
//		
//		if(HiveList.generateMagicBeesHives())
//		{
//			registerHive(HiveList.curious);
//			registerHive(HiveList.resonating);
//			registerHive(HiveList.unusual);
//			registerHive(HiveList.deep);
//			registerHive(HiveList.infernal);
//			registerHive(HiveList.oblivion);
//			
//			System.out.println("Ex Nihilo: Found Magic Bees!");
//		}
		//CommonOre.dumpUnlocalizedNames("hive");
		ExNihilo.log.info("Hive Registry Completed!");
	}
}
