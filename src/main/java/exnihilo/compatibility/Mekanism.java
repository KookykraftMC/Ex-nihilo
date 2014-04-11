package exnihilo.compatibility;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;

public class Mekanism {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("Mekanism");
	}

	public static void loadCompatibility()
	{
		SieveRegistry.register(Block.gravel.blockID, 0, ENItems.OsmiumGravel.itemID, 0, 12);
		SieveRegistry.register(Block.sand.blockID, 0, ENItems.OsmiumSand.itemID, 0, 12);
		SieveRegistry.register(ENBlocks.Dust.blockID, 0, ENItems.OsmiumDust.itemID, 0, 12);

		ItemStack ingotOsmium = mekanism.api.ItemRetriever.getItem("Ingot");
		ingotOsmium.setItemDamage(1);

		if (ingotOsmium != null)
		{
			FurnaceRecipes.smelting().addSmelting(ENBlocks.OsmiumOre.blockID, 0, ingotOsmium, 0.1f);
			FurnaceRecipes.smelting().addSmelting(ENBlocks.OsmiumOre.blockID, 1, ingotOsmium, 0.1f);
			FurnaceRecipes.smelting().addSmelting(ENBlocks.OsmiumOre.blockID, 2, ingotOsmium, 0.1f);
		}

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.OsmiumOre, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.OsmiumGravel
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.OsmiumOre, 1, 1),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.OsmiumSand
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.OsmiumOre, 1, 2),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.OsmiumDust
								}));

		ItemStack oreOsmium = mekanism.api.ItemRetriever.getItem("OreBlock");

		if (oreOsmium != null)
		{
			HammerRegistry.registerOre(oreOsmium.itemID, oreOsmium.getItemDamage(), ENItems.OsmiumGravel.itemID, 0);
		}

		HammerRegistry.registerOre(ENBlocks.OsmiumOre.blockID, 0, ENItems.OsmiumSand.itemID, 0);
		HammerRegistry.registerOre(ENBlocks.OsmiumOre.blockID, 1, ENItems.OsmiumDust.itemID, 0);


	}
}
