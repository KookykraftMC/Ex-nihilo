package exnihilo.compatibility;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeOutput;

import java.util.ArrayList;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.Blocks;
import exnihilo.Items;
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
			
			SieveRegistry.register(Blocks.Dust.blockID, 0, sulfur.itemID, sulfur.getItemDamage(), 32);
		}
		
		SieveRegistry.register(Block.dirt.blockID, 0, Items.SeedsRubber.itemID, 0, 64);
		
		Item crushedUranium = GameRegistry.findItem("IC2", "itemCrushedOre");
    	if (crushedUranium != null)
    	{
    		SieveRegistry.register(Block.sand.blockID, 0, crushedUranium.itemID, 4, 48);
    	}
    	
    	Item plantBall = null;
    	for (Item i : Item.itemsList)
		{
			if (i != null)
			{
				if (i.getUnlocalizedName().contains("itemFuelPlantBall"))
				{
					plantBall = i;
				}
			}
		}
    	
    	if (plantBall != null)
    	{
    		CompostRegistry.register(plantBall.itemID, 0, 0.5f, new Color("269900"));
    	}
    	
    	Item plantBallCompressed = null;
    	for (Item i : Item.itemsList)
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
    		CompostRegistry.register(plantBallCompressed.itemID, 0, 1.0f, new Color("269900"));
    	}
    	
    	//Remove the default IC2 cobblestone macerator recipe.
    	Map<IRecipeInput, RecipeOutput> recipes = ic2.api.recipe.Recipes.macerator.getRecipes();
    	IRecipeInput cobbleRecipe = null;
    	IRecipeInput gravelRecipe = null;
    	
    	for (IRecipeInput i : recipes.keySet())
    	{
    		if(i.matches(new ItemStack(Block.cobblestone)))
    		{
    			cobbleRecipe = i;
    		}
    		
    		if(i.matches(new ItemStack(Block.gravel)))
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
    	ic2.api.recipe.Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Block.cobblestone)), null, new ItemStack(Block.gravel));
    	//ic2.api.recipe.Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Block.gravel,0,1)), null, new ItemStack(Block.sand,0,1));
    	ic2.api.recipe.Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Block.gravel)), null, new ItemStack(Block.sand));
    	ic2.api.recipe.Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Block.sand)), null, new ItemStack(Blocks.Dust));
	}

}
