package exnihilo.compatibility;

import java.util.ArrayList;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.data.ModData;
import exnihilo.items.seeds.ItemSeedRubber;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Color;

public class IC2 {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("IC2");
	}

	public static void loadCompatibility()
	{
		ArrayList<ItemStack> ores;

		ores = OreDictionary.getOres("dustSulfur");
		if (ores.size() > 0)
		{
			ItemStack sulfur = ores.toArray(new ItemStack[ores.size()])[0];

			SieveRegistry.register(ENBlocks.Dust, 0, sulfur.getItem(), sulfur.getItemDamage(), 32);
		}

		Block rubberSapling = GameRegistry.findBlock("IC2", "blockRubSapling");
		ItemSeedRubber.saplings.add(rubberSapling);
		SieveRegistry.register(Blocks.dirt, 0, ENItems.SeedsRubber, 0, 45);

		Item crushedUranium = GameRegistry.findItem("IC2", "itemCrushedOre");
		if (crushedUranium != null)
		{
			SieveRegistry.register(Blocks.sand, 0, crushedUranium, 4, 48);
		}

		Item plantBall = GameRegistry.findItem("IC2", "itemFuelPlantBall");
		if (plantBall != null)
		{
			CompostRegistry.register(plantBall, 0, 0.5f, new Color("269900"));
		}

		Item plantBallCompressed = null;
		for (Item i : Item.itemRegistry)
		{
			if (i != null)
			{
				if (i.getUnlocalizedName().contains("itemFuelPlantCmpr"))
				{
					plantBallCompressed = i;
				}
			}
		}

		if (plantBallCompressed != null)
		{
			CompostRegistry.register(plantBallCompressed, 0, 1.0f, new Color("269900"));
		}

		//Remove the default IC2 cobblestone macerator recipe.
		if (ModData.OVERWRITE_DEFAULT_MACERATOR_RECIPES)
		{
			Map<IRecipeInput, RecipeOutput> recipes = ic2.api.recipe.Recipes.macerator.getRecipes();
			IRecipeInput cobbleRecipe = null;
			IRecipeInput gravelRecipe = null;

			for (IRecipeInput i : recipes.keySet())
			{
				if(i.matches(new ItemStack(Blocks.cobblestone)))
				{
					cobbleRecipe = i;
				}

				if(i.matches(new ItemStack(Blocks.gravel)))
				{
					gravelRecipe = i;
				}
			}

			if (cobbleRecipe != null)
			{
				System.out.println("Ex Nihilo: Removing default IC2 Cobble->Sand macerator recipe.");

				recipes.remove(cobbleRecipe);
			}

			if (gravelRecipe != null)
			{
				System.out.println("Ex Nihilo: Removing default IC2 Gravel->Flint macerator recipe.");

				recipes.remove(gravelRecipe);
			}

			//Add the hammer recipe sequence.
			System.out.println("Ex Nihilo: Adding Hammer Sequence to IC2 Macerator");
			ic2.api.recipe.Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.cobblestone)), null, new ItemStack(Blocks.gravel));
			ic2.api.recipe.Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.gravel)), null, new ItemStack(Blocks.sand));
		}

		ic2.api.recipe.Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.sand)), null, new ItemStack(ENBlocks.Dust));
	}

}
