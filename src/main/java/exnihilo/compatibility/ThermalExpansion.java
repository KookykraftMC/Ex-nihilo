package exnihilo.compatibility;

import java.lang.reflect.Method;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import exnihilo.ENBlocks;
import exnihilo.ExNihilo;
import exnihilo.data.ModData;
import exnihilo.registries.HeatRegistry;

public class ThermalExpansion {
	public static void loadCompatibility()
	{	
		if (ModData.OVERWRITE_DEFAULT_PULVERIZER_RECIPES)
		{
			overwritePulverizerRecipe(3200, new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.gravel), new ItemStack(Blocks.sand), 10, true);
			overwritePulverizerRecipe(3200, new ItemStack(Blocks.gravel), new ItemStack(Blocks.sand), new ItemStack(ENBlocks.Dust), 10, true);
			ExNihilo.log.info("Pulverizer: overwrote the cobble->sand recipe with cobble->gravel");
			ExNihilo.log.info("Pulverizer: added recipe for gravel->sand");
		}
		
		addPulverizerRecipe(3200, new ItemStack(Blocks.sand), new ItemStack(ENBlocks.Dust), null, 0, true);
		ExNihilo.log.info("Pulverizer: added recipe for sand->dust");
		
		Block pyrotheum = FluidRegistry.getFluid("pyrotheum").getBlock();

		if (pyrotheum != null)
		{
			HeatRegistry.register(pyrotheum, 0.5f);
			HeatRegistry.register(pyrotheum, 0, 0.7f);
			ExNihilo.log.info("Added blazing pyrotheum as a crucible heat source");
		}
		
		ExNihilo.log.info("--- Thermal Expansion Integration Complete!");
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
		
		catch (Exception ex){System.out.println("Unable to add pulverizer recipes, (" + ex.getMessage() + ")");}
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
		catch (Exception ex){System.out.println("Unable to add pulverizer recipes, (" + ex.getMessage() + ")");}
	}
	
	public static void TryRegisterOre(String name, Block block)
	{
		name = name.replace("ender_", "");
		name = name.replace("nether_", "");

		if (name.toLowerCase().equals("iron"))
			RegisterOre(OreList.Type.Iron, block);

		if (name.toLowerCase().equals("gold"))
			RegisterOre(OreList.Type.Gold, block);

		if (name.toLowerCase().equals("copper"))
			RegisterOre(OreList.Type.Copper, block);

		if (name.toLowerCase().equals("tin"))
			RegisterOre(OreList.Type.Tin, block);

		if (name.toLowerCase().equals("nickel"))
			RegisterOre(OreList.Type.Nickel, block);

		if (name.toLowerCase().equals("platinum"))
			RegisterOre(OreList.Type.Platinum, block);

		if (name.toLowerCase().equals("silver"))
			RegisterOre(OreList.Type.Silver, block);

		if (name.toLowerCase().equals("lead"))
			RegisterOre(OreList.Type.Lead, block);
	}
	
	public static void RegisterOre(OreList.Type ore, Block block)
	{
		ItemStack iblock = new ItemStack(block);
		ItemStack primary;
		ItemStack secondary;
		
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
}
