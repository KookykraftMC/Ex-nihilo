package exnihilo.compatibility.foresty;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import forestry.api.apiculture.FlowerManager;

public class HiveList {
	public static ItemStack beehives;
	public static Hive forest;
	public static Hive meadow;
	public static Hive desert;
	public static Hive jungle;
	public static Hive end;
	public static Hive snow;
	public static Hive water;

	public static boolean generateForestryHives()
	{
		beehives = forestry.api.core.BlockInterface.getBlock("beehives");

		if (beehives != null)
		{
			generateForestHive();
			generateMeadowHive();
			generateDesertHive();

			return true;
		}
		return false;

	}

	private static void generateForestHive()
	{
		forest = new Hive(beehives.itemID, 1);
		forest.minRainfall = 0.29f;
		forest.maxRainfall = 0.9f;
		forest.minTemperature = 0.19f;
		forest.maxTemperature = 1.2f;

		forest.requiredCanSeeSky = true;
		forest.requiresTree = true;

		forest.biomeTypes.add(Type.FOREST);
	}

	private static void generateMeadowHive()
	{
		meadow = new Hive(beehives.itemID, 2);
		meadow.minRainfall = 0.29f;
		meadow.maxRainfall = 0.9f;
		meadow.minTemperature = 0.19f;
		meadow.maxTemperature = 1.2f;

		meadow.requiredCanSeeSky = true;

		meadow.biomeTypes.add(Type.PLAINS);

		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			meadow.flowers.add(item.itemID + ":" + item.getItemDamage());
		}
	}

	private static void generateDesertHive()
	{
		desert = new Hive(beehives.itemID, 3);
		desert.maxRainfall = 0.0f;
		desert.minTemperature = 1.19f;

		desert.requiredCanSeeSky = true;

		desert.biomeTypes.add(Type.DESERT);

		desert.flowers.add(Block.cactus.blockID + ":0");
	}

	public static void generateJungleHive()
	{}

	public static void generateEndHive()
	{}

	public static void generateSnowHive()
	{}

	public static void generateSwampHive()
	{}
}
