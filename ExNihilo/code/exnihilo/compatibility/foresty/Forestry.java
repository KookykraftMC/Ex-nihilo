package exnihilo.compatibility.foresty;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.registries.SieveRegistry;
import forestry.api.apiculture.FlowerManager;
import forestry.api.arboriculture.ITreeRoot;
import forestry.api.core.BlockInterface;
import forestry.api.genetics.AlleleManager;

public class Forestry {
	//public static ITreeRoot trees = (ITreeRoot) AlleleManager.alleleRegistry.getSpeciesRoot("rootTrees");

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

		registerBeeHives();
	}

	public static void registerBeeHives()
	{
		ItemStack beehives = forestry.api.core.ItemInterface.getItem("beehives");

		if (beehives != null)
		{
			Hive meadows = new Hive(beehives.itemID, 1);
			meadows.minRainfall = 0.29f;
			meadows.maxRainfall = 0.9f;
			meadows.minTemperature = 0.19f;
			meadows.maxTemperature = 1.2f;

			Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
			while(it.hasNext())
			{
				ItemStack item = it.next();
				meadows.flowers.add(item.itemID + ":" + item.getItemDamage());
			}
		}
	}

	public static boolean addsThisLeaf(Block block)
	{
		if (Forestry.isLoaded())
		{
			Class forestryLeafBlock = null;
			try {
				forestryLeafBlock = Class.forName("forestry.arboriculture.gadgets.BlockLeaves");

				Method dropStuff = null;
				if (forestryLeafBlock != null)
				{	
					if (forestryLeafBlock.cast(block) != null);
					return true;
				}
			}
			catch (Exception ex){}
		}
		return false;
	}
}
