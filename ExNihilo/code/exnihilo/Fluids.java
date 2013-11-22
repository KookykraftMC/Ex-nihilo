package exnihilo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.BlockData;
import exnihilo.data.FluidData;
import exnihilo.fluids.BlockWitchWater;
import exnihilo.fluids.FluidWitchWater;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Fluids {
	public static Block blockWitchWater;
	public static Fluid fluidWitchWater;
	
	public static void registerFluids()
	{
		fluidWitchWater = new FluidWitchWater("witchwater");
		FluidRegistry.registerFluid(fluidWitchWater);
		
		blockWitchWater = new BlockWitchWater(FluidData.WITCHWATER_ID, fluidWitchWater, Material.water);
		GameRegistry.registerBlock(blockWitchWater, FluidData.WITCHWATER_KEY);
		
		fluidWitchWater.setBlockID(blockWitchWater);
		
	}
	
	
	public static void registerNames()
	{
		LanguageRegistry.addName(blockWitchWater, FluidData.WITCHWATER_NAME);	
	}
	
	public static void registerIcons(TextureStitchEvent.Post event)
	{
		if (event.map.textureType == 0) {
                    fluidWitchWater.setIcons(blockWitchWater.getBlockTextureFromSide(1), blockWitchWater.getBlockTextureFromSide(2));
            }
	}
	

}
