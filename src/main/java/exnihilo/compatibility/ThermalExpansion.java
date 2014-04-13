package exnihilo.compatibility;

import java.lang.reflect.Method;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import exnihilo.ENBlocks;
import exnihilo.data.ModData;

public class ThermalExpansion {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("ThermalExpansion");
	}
	
	public static void loadCompatibility()
	{	
		if (ModData.OVERWRITE_DEFAULT_PULVERIZER_RECIPES)
		{
			addPulverizerRecipe(3200, new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.gravel), new ItemStack(Blocks.sand), 10, true);
			addPulverizerRecipe(3200, new ItemStack(Blocks.gravel), new ItemStack(Blocks.sand), new ItemStack(ENBlocks.Dust), 10, true);
		}
		
		addPulverizerRecipe(3200, new ItemStack(Blocks.sand), new ItemStack(ENBlocks.Dust), null, 0, true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addPulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance, boolean overwrite)
	{
		Class pulverizer = null;
		Method addRecipe = null;
		Object[] parameters ={(Object)energy, (Object)input, (Object)primaryOutput, (Object)secondaryOutput, (Object)secondaryChance, (Object)overwrite};
		
		try {
			pulverizer = Class.forName("thermalexpansion.util.crafting.PulverizerManager");

			if (pulverizer != null)
			{	
				//System.out.println("Ex Nihilo: Successfully located the PulverizerManager!");
				addRecipe = pulverizer.getDeclaredMethod("addRecipe", int.class, ItemStack.class, ItemStack.class, ItemStack.class, int.class, boolean.class);
				addRecipe.setAccessible(true);
			}//else
			//{System.out.println("Ex Nihilo: Could not locate PulverizerManager");}

			if (addRecipe != null)
			{
				//System.out.println("Ex Nihilo: Successfully located the addRecipe() method!");
				addRecipe.invoke(null, parameters);
			}//else
			//{System.out.println("Ex Nihilo: Could not locate addRecipe method on class: PulverizerManager");}
		}
		catch (Exception ex){System.out.println("Ex Nihilo: Failed to add pulverizer recipes, " + ex.getMessage());}
	}
}
