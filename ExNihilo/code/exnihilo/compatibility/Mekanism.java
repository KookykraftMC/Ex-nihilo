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
import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;

public class Mekanism {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("Mekanism");
	}

	public static void loadCompatibility()
	{
		SieveRegistry.register(Block.gravel.blockID, 0, Items.OsmiumGravel.itemID, 0, 12);
		SieveRegistry.register(Block.sand.blockID, 0, Items.OsmiumSand.itemID, 0, 12);
		SieveRegistry.register(Blocks.Dust.blockID, 0, Items.OsmiumDust.itemID, 0, 12);

		ItemStack ingotOsmium = mekanism.api.ItemRetriever.getItem("Ingot");
		ingotOsmium.setItemDamage(1);

		if (ingotOsmium != null)
		{
			FurnaceRecipes.smelting().addSmelting(Blocks.OsmiumOre.blockID, 0, ingotOsmium, 0.1f);
			FurnaceRecipes.smelting().addSmelting(Blocks.OsmiumOre.blockID, 1, ingotOsmium, 0.1f);
			FurnaceRecipes.smelting().addSmelting(Blocks.OsmiumOre.blockID, 2, ingotOsmium, 0.1f);
		}

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.OsmiumOre, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.OsmiumGravel
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.OsmiumOre, 1, 1),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.OsmiumSand
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.OsmiumOre, 1, 2),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.OsmiumDust
								}));

		ItemStack oreOsmium = mekanism.api.ItemRetriever.getItem("OreBlock");

		if (oreOsmium != null)
		{
			HammerRegistry.registerOre(oreOsmium.itemID, oreOsmium.getItemDamage(), Items.OsmiumGravel.itemID, 0);
		}

		HammerRegistry.registerOre(Blocks.OsmiumOre.blockID, 0, Items.OsmiumSand.itemID, 0);
		HammerRegistry.registerOre(Blocks.OsmiumOre.blockID, 1, Items.OsmiumDust.itemID, 0);


	}
}
