package exnihilo.compatibility;

import tconstruct.library.crafting.Smeltery;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import exnihilo.ExNihilo;

public class TinkersConstruct {
	private final static int INGOT_AMOUNT = 144;
	
	public static void loadCompatibility()
	{	
		ExNihilo.log.info("--- Tinkers Construct Integration Complete!");
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
		
		if (name.toLowerCase().equals("aluminum") || name.toLowerCase().equals("aluminium"))
			RegisterOre(OreList.Type.Aluminum, block);
	}
	
	public static void RegisterOre(OreList.Type ore, Block block)
	{
		int meltingPoint = getMeltingPoint(ore);
		FluidStack moltenMetal = getMoltenMetal(ore);
		
		if (block != null && meltingPoint != 0 && moltenMetal != null)
		{
			Smeltery.addMelting(block, 0, meltingPoint, moltenMetal);
		}
		
		//ExNihilo.log.info("Added " + block.getUnlocalizedName() + " to TConstruct Smeltery!");
	}
	
	private static int getMeltingPoint(OreList.Type ore)
	{
		switch (ore)
		{
		case Iron:
			return 600;
			
		case Gold:
			return 400;
			
		case Tin:
			return 400;
			
		case Copper:
			return 550;
			
		case Silver:
			return 400;
			
		case Lead:
			return 400;
			
		case Nickel:
			return 400;
			
		case Platinum:
			return 400;
		
		case Aluminum:
			return 400;
			
		default:
			return 0;
		}
	}
	
	private static FluidStack getMoltenMetal(OreList.Type ore)
	{
		Fluid metal = findMoltenMetal(ore);
		
		if (metal != null)
		{
			return new FluidStack(metal, INGOT_AMOUNT * 2);
		}
		
		return null;
	}
	
	private static Fluid findMoltenMetal(OreList.Type ore)
	{
		switch (ore)
		{
		case Iron:
			return FluidRegistry.getFluid("iron.molten");
			
		case Gold:
			return FluidRegistry.getFluid("gold.molten");
			
		case Tin:
			return FluidRegistry.getFluid("tin.molten");
			
		case Copper:
			return FluidRegistry.getFluid("copper.molten");
			
		case Silver:
			return FluidRegistry.getFluid("silver.molten");
			
		case Lead:
			return FluidRegistry.getFluid("lead.molten");
			
		case Nickel:
			return FluidRegistry.getFluid("nickel.molten");
			
		case Platinum:
			return FluidRegistry.getFluid("platinum.molten");
			
		case Aluminum:
			return FluidRegistry.getFluid("aluminum.molten");
			
		default:
			return null;
		}
	}
}
