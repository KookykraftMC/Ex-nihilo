package exnihilo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.data.FluidData;
import exnihilo.fluids.BlockWitchWater;
import exnihilo.fluids.BucketHandler;
import exnihilo.fluids.FluidWitchWater;
import exnihilo.fluids.buckets.ItemBucketWitchWater;

public class Fluids {
	public static Block blockWitchWater;
	public static Fluid fluidWitchWater;
	
	//BUCKETS!
	public static Item BucketWitchWater;
	
	public static void registerFluids()
	{
		fluidWitchWater = new FluidWitchWater("witchwater");
		FluidRegistry.registerFluid(fluidWitchWater);
		
		blockWitchWater = new BlockWitchWater(fluidWitchWater, Material.water);
		GameRegistry.registerBlock(blockWitchWater, FluidData.WITCHWATER_KEY);
	}
	
	public static void registerBuckets()
	{
		//BUCKETS!
		BucketWitchWater = new ItemBucketWitchWater(blockWitchWater);
		GameRegistry.registerItem(BucketWitchWater, FluidData.BUCKET_WITCHWATER_UNLOCALIZED_NAME);
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("witchwater", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(BucketWitchWater), new ItemStack(Items.bucket));
		BucketHandler.INSTANCE.buckets.put(blockWitchWater, BucketWitchWater);
		
		
		//This should happen last.
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}
	
	
	
//	public static void registerNames()
//	{
//		LanguageRegistry.addName(blockWitchWater, FluidData.WITCHWATER_NAME);	
//	}
	
	public static void registerIcons(TextureStitchEvent.Post event)
	{
		if (event.map.getTextureType() == 0) {
                    fluidWitchWater.setIcons(blockWitchWater.getBlockTextureFromSide(1), blockWitchWater.getBlockTextureFromSide(2));
            }
	}
	

}
