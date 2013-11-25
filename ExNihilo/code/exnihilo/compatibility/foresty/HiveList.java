package exnihilo.compatibility.foresty;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import forestry.api.apiculture.FlowerManager;

public class HiveList {

	public static void registerMeadowsHive()
	{
		ItemStack beehives = forestry.api.core.BlockInterface.getBlock("beehives");

		if (beehives != null)
		{
			Hive meadows = new Hive(beehives.itemID, 2);
			meadows.minRainfall = 0.29f;
			meadows.maxRainfall = 0.9f;
			meadows.minTemperature = 0.19f;
			meadows.maxTemperature = 1.2f;

			meadows.biomeTypes.add(Type.PLAINS);

			Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
			while(it.hasNext())
			{
				ItemStack item = it.next();
				meadows.flowers.add(item.itemID + ":" + item.getItemDamage());
			}

			HiveRegistry.registerHive(meadows);
		}
	}
}
