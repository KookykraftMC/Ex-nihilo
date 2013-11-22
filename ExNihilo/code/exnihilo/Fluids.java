package exnihilo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import exnihilo.data.BlockData;
import exnihilo.data.FluidData;
import exnihilo.fluids.BlockWitchWater;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Fluids {
	public static Block blockWitchWater;
	public static Fluid fluidWitchWater;
	
	public static void registerFluids()
	{
		fluidWitchWater = new Fluid("witchwater");
		FluidRegistry.registerFluid(fluidWitchWater);
		
		blockWitchWater = new BlockWitchWater(FluidData.WITCHWATER_ID, fluidWitchWater, Material.water);
		GameRegistry.registerBlock(blockWitchWater, FluidData.WITCHWATER_KEY);
		
		fluidWitchWater.setBlockID(blockWitchWater);
		
	}
	
	
	public static void registerNames()
	{
		LanguageRegistry.addName(blockWitchWater, FluidData.WITCHWATER_NAME);	
	}
}
