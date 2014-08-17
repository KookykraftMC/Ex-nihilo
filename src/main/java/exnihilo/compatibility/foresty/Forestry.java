package exnihilo.compatibility.foresty;

import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.ExNihilo;
import exnihilo.registries.SieveRegistry;
import forestry.core.config.ForestryItem;

public class Forestry {
	public static void loadCompatibility()
	{
		ExNihilo.log.info("Beginning Forestry Integration...");
		ItemStack apatite = ForestryItem.apatite.getItemStack();

		if (apatite != null) {
			SieveRegistry.register(Blocks.gravel, 0, apatite.getItem(), apatite.getItemDamage(), 16);
			ExNihilo.log.info("Apatite was successfully integrated");
		}else{
			ExNihilo.log.error("APATITE WAS NOT INTEGRATED");
		}
		
		HiveRegistry.registerHives();
		registerRecipes();
		
		ExNihilo.log.info("Forestry Integration Complete!");
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static boolean addsThisLeaf(Block block)
	{
		if (Loader.isModLoaded("Forestry"))
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
	
	private static void registerRecipes()
	{
		GameRegistry.addShapelessRecipe(
						new ItemStack(ENBlocks.BeeTrap, 1, 0),
						new Object[]
								{ 
							new ItemStack(Blocks.hay_block, 1, 0),
							new ItemStack(ENItems.Mesh, 1, 0)
								});
		ExNihilo.log.info("Recipes sucessfully added");
	}
}
