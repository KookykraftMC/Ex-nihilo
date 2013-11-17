package exnihilo.compatibility;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.registries.SieveRegistry;

public class Forestry {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("Forestry");
	}
	
	public static void loadCompatibility()
	{	
		ItemStack apatite = forestry.api.core.ItemInterface.getItem("apatite");
		
    	if (apatite != null)
    	{
    		SieveRegistry.register(Block.gravel.blockID, 0, apatite.itemID, apatite.getItemDamage(), 16);
    	}
	}
}
