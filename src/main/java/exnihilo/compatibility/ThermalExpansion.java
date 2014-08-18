package exnihilo.compatibility;

import java.lang.reflect.Method;

import scala.Console;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import exnihilo.ENBlocks;
import exnihilo.data.ModData;

public class ThermalExpansion {
	public static void loadCompatibility()
	{	
		if (ModData.OVERWRITE_DEFAULT_PULVERIZER_RECIPES)
		{
			overwritePulverizerRecipe(3200, new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.gravel), new ItemStack(Blocks.sand), 10, true);
			overwritePulverizerRecipe(3200, new ItemStack(Blocks.gravel), new ItemStack(Blocks.sand), new ItemStack(ENBlocks.Dust), 10, true);
		}
		
		addPulverizerRecipe(3200, new ItemStack(Blocks.sand), new ItemStack(ENBlocks.Dust), null, 0, true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void overwritePulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance, boolean overwrite)
	{
		Class pulverizer = null;
		Method addRecipe = null;

		Object[] parameters ={(Object)energy, (Object)input, (Object)primaryOutput, (Object)secondaryOutput, (Object)secondaryChance};
		try {
			pulverizer = Class.forName("thermalexpansion.util.crafting.PulverizerManager");

			if (pulverizer != null)
			{	
				addRecipe = pulverizer.getDeclaredMethod("addTERecipe", int.class, ItemStack.class, ItemStack.class, ItemStack.class, int.class);
				addRecipe.setAccessible(true);
			}

			if (addRecipe != null)
			{
				addRecipe.invoke(null, parameters);
			}
		}
		catch (Exception ex){System.out.println("Ex Nihilo: Failed to add pulverizer recipes, " + ex.getMessage());}
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
				addRecipe = pulverizer.getDeclaredMethod("addRecipe", int.class, ItemStack.class, ItemStack.class, ItemStack.class, int.class, boolean.class);
				addRecipe.setAccessible(true);
			}

			if (addRecipe != null)
			{
				addRecipe.invoke(null, parameters);
			}
		}
		catch (Exception ex){System.out.println("Ex Nihilo: Failed to add pulverizer recipes, " + ex.getMessage());}
	}
	
	public static void TryRegisterOre(String name, Block block)
	{
		name = name.replace("ender_", "");
		name = name.replace("nether_", "");
		
		if (name.toLowerCase() == "iron")
			RegisterOre(Ore.Iron, block);
		
		if (name.toLowerCase() == "gold")
			RegisterOre(Ore.Gold, block);
		
		if (name.toLowerCase() == "copper")
			RegisterOre(Ore.Copper, block);
			
		if (name.toLowerCase() == "tin")
			RegisterOre(Ore.Tin, block);
			
		if (name.toLowerCase() == "nickel")
			RegisterOre(Ore.Nickel, block);

		if (name.toLowerCase() == "platinum")
			RegisterOre(Ore.Platinum, block);
			
		if (name.toLowerCase() == "silver")
			RegisterOre(Ore.Silver, block);
			
		if (name.toLowerCase() == "lead")
			RegisterOre(Ore.Lead, block);
	}
	
	public static void RegisterOre(Ore ore, Block block)
	{
		ItemStack iblock = new ItemStack(block);
		ItemStack primary;
		ItemStack secondary;
		
		Console.out().println("Registering ore " + block.getUnlocalizedName() + " with the ore type " + ore.toString());
		
		switch (ore)
		{
		case Iron:
			primary = GameRegistry.findItemStack("ThermalFoundation", "dustIron", 2);
			secondary = GameRegistry.findItemStack("ThermalFoundation", "dustNickel", 1);
			
			addPulverizerRecipe(3200, iblock, primary, secondary, 10, true);
			break;
			
		case Gold:
			primary = GameRegistry.findItemStack("ThermalFoundation", "dustGold", 2);
			secondary = null;
			
			addPulverizerRecipe(3200, iblock, primary, secondary, 10, true);
			break;
			
		case Tin:
			primary = GameRegistry.findItemStack("ThermalFoundation", "dustTin", 2);
			secondary = GameRegistry.findItemStack("ThermalFoundation", "dustIron", 1);
			
			addPulverizerRecipe(3200, iblock, primary, secondary, 10, true);
			break;
			
		case Copper:
			primary = GameRegistry.findItemStack("ThermalFoundation", "dustCopper", 2);
			secondary = GameRegistry.findItemStack("ThermalFoundation", "dustGold", 1);
			
			addPulverizerRecipe(3200, iblock, primary, secondary, 10, true);
			break;
			
		case Silver:
			primary = GameRegistry.findItemStack("ThermalFoundation", "dustSilver", 2);
			secondary = GameRegistry.findItemStack("ThermalFoundation", "dustLead", 1);
			
			addPulverizerRecipe(3200, iblock, primary, secondary, 10, true);
			break;
			
		case Lead:
			primary = GameRegistry.findItemStack("ThermalFoundation", "dustLead", 2);
			secondary = GameRegistry.findItemStack("ThermalFoundation", "dustSilver", 1);
			
			addPulverizerRecipe(3200, iblock, primary, secondary, 10, true);
			break;
			
		case Nickel:
			primary = GameRegistry.findItemStack("ThermalFoundation", "dustNickel", 2);
			secondary = GameRegistry.findItemStack("ThermalFoundation", "dustPlatinum", 1);
			
			addPulverizerRecipe(3200, iblock, primary, secondary, 10, true);
			break;
			
		case Platinum:
			primary = GameRegistry.findItemStack("ThermalFoundation", "dustPlatinum", 2);
			secondary = null;
			
			addPulverizerRecipe(3200, iblock, primary, secondary, 10, true);
			break;
			
		default:
			break;
		}
	}
	
	public enum Ore
	{
		Iron,
		Gold,
		Tin,
		Copper,
		Nickel,
		Platinum,
		Silver,
		Lead,
	}
}
