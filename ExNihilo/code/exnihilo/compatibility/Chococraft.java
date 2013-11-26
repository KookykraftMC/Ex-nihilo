package exnihilo.compatibility;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.SieveRegistry;

public class Chococraft {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("chococraft");
	}
	
	public static void loadCompatibility()
	{	
		Item gysahlSeeds = null;
		
		for (Item i : Item.itemsList)
		{
			if (i != null)
			{
				if (i.getUnlocalizedName().equals("item.gysahl_seeds"))
				{
					gysahlSeeds = i;
				}
			}
		}
		
    	if (gysahlSeeds != null)
    	{
    		SieveRegistry.register(Block.dirt.blockID, 0, gysahlSeeds.itemID, 0, 32);
    	}
	}
}
