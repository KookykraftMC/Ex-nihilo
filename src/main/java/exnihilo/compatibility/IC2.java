package exnihilo.compatibility;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;

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
import exnihilo.ExNihilo;
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
		ExNihilo.log.info("Beginning IC2 Integration...");
		ArrayList<ItemStack> ores;

		ores = OreDictionary.getOres("dustSulfur");
		if (ores.size() > 0){
			ItemStack sulfur = ores.toArray(new ItemStack[ores.size()])[0];
			SieveRegistry.register(ENBlocks.Dust, 0, sulfur.getItem(), sulfur.getItemDamage(), 32);
			ExNihilo.log.info("Sulfur was successfully integrated");
		}else{
			ExNihilo.log.error("SULFUR WAS NOT INTEGRATED");
		}

		Block rubberSapling = GameRegistry.findBlock("IC2", "blockRubSapling");
		if(rubberSapling != null) {
			ItemSeedRubber.AddSapling(rubberSapling);
			SieveRegistry.register(Blocks.dirt, 0, ENItems.SeedsRubber, 0, 45);
			ExNihilo.log.info("Rubber was successfully integrated");
		}else{
			ExNihilo.log.error("RUBBER WAS NOT INTEGRATED");
		}

		Item crushedOres = GameRegistry.findItem("IC2", "itemCrushedOre");
		if (crushedOres != null) {
			SieveRegistry.register(Blocks.sand, 0, crushedOres, 4, 48);
			ExNihilo.log.info("Crushed Ores were successfully integrated");
		}else{
			ExNihilo.log.error("CRUSHED ORES WERE NOT INTEGRATED");
		}

		Item plantBall = GameRegistry.findItem("IC2", "itemFuelPlantBall");
		if (plantBall != null) {
			CompostRegistry.register(plantBall, 0, 0.5f, new Color("269900"));
			ExNihilo.log.info("Plantball was successfully integrated");
		}else{
			ExNihilo.log.error("PLANTBALL WAS NOT INTEGRATED");
		}

		Item plantBallCompressed = GameRegistry.findItem("IC2", "itemFuelPlantCmpr");
		if (plantBallCompressed != null) {
			CompostRegistry.register(plantBallCompressed, 0, 1.0f, new Color("269900"));
			ExNihilo.log.info("Compressed Plants were successfully integrated");
		}else{
			ExNihilo.log.error("COMPRESSED PLANTS WERE NOT INTEGRATED");
		}

		//Remove the default IC2 cobblestone macerator recipe.
		if (ModData.OVERWRITE_DEFAULT_MACERATOR_RECIPES)
		{
			Map<IRecipeInput, RecipeOutput> recipes = Recipes.macerator.getRecipes();
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

			if (cobbleRecipe != null) {
				recipes.remove(cobbleRecipe);
				ExNihilo.log.info("Successfully removed default Cobble to Sand Macerator recipe");
			}else{
				ExNihilo.log.error("DEFAULT COBBLE TO SAND MACERATOR RECIPE WASN'T REMOVED");
			}

			if (gravelRecipe != null) {
				recipes.remove(gravelRecipe);
				ExNihilo.log.info("Successfully removed default Gravel to Flint Macerator recipe");
			}else{
				ExNihilo.log.error("DEFAULT GRAVEL TO FLINT MACERATOR RECIPE WASN'T REMOVED");
			}

			//Add the hammer recipe sequence.
			Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.cobblestone)), null, new ItemStack(Blocks.gravel));
			Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.gravel)), null, new ItemStack(Blocks.sand));
			ExNihilo.log.info("Successfully added Hammer sequence to Macerator");
		}

		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.sand)), null, new ItemStack(ENBlocks.Dust));
		ExNihilo.log.info("IC2 Integration Complete!");
	}

}
