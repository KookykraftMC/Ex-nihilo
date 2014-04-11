package exnihilo.compatibility;

import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.event.FMLInterModComms;
import exnihilo.ENBlocks;
import exnihilo.ExNihilo;
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
			addPulverizerRecipe(3200, new ItemStack(Block.cobblestone), new ItemStack(Block.gravel), new ItemStack(Block.sand), 10, true);
			addPulverizerRecipe(3200, new ItemStack(Block.gravel), new ItemStack(Block.sand), new ItemStack(ENBlocks.Dust), 10, true);
		}
		
		addPulverizerRecipe(3200, new ItemStack(Block.sand), new ItemStack(ENBlocks.Dust), null, 0, true);
	}
	
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
