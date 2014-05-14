package exnihilo.compatibility;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.helpers.Color;

public class OreList{

	public static void registerOres()
	{
		ArrayList<ItemStack> ores;
		
		ores = OreDictionary.getOres("oreCopper");
		if (ores.size() > 0)
		{
		  OreRegistry.createOverworldOre("copper", new Color("FF330A"), 7);
		}
		
		OreRegistry.createOverworldOre("tin", new Color("DBFFE8"), 7);
	}
}
