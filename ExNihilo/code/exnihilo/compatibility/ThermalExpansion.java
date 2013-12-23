package exnihilo.compatibility;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.event.FMLInterModComms;
import exnihilo.Blocks;
import exnihilo.ExNihilo;

public class ThermalExpansion {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("ThermalExpansion");
	}
	
	public static void loadCompatibility()
	{	
		NBTTagCompound cobbleToGravel = new NBTTagCompound();
		cobbleToGravel.setInteger("energy", 3200);
		cobbleToGravel.setInteger("secondaryChance", 10);
		cobbleToGravel.setBoolean("overwrite", true);
		cobbleToGravel.setCompoundTag("input", new NBTTagCompound());
		cobbleToGravel.setCompoundTag("primaryOutput", new NBTTagCompound());
		cobbleToGravel.setCompoundTag("secondaryOutput", new NBTTagCompound());

		new ItemStack(Block.cobblestone).writeToNBT(cobbleToGravel.getCompoundTag("input"));
		new ItemStack(Block.gravel).writeToNBT(cobbleToGravel.getCompoundTag("primaryOutput"));
		new ItemStack(Block.sand).writeToNBT(cobbleToGravel.getCompoundTag("secondaryOutput"));
		
		FMLInterModComms.sendRuntimeMessage(ExNihilo.instance, "ThermalExpansion", "PulverizerRecipe", cobbleToGravel);
		System.out.println("Ex Nihilo: Added Cobble->Gravel recipe to TE Pulverizer");
		
//		if(FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe", cobbleToGravel))
//		{
//			System.out.println("Ex Nihilo: Added Cobble->Gravel recipe to TE Pulverizer");
//		}
		
		NBTTagCompound gravelToSand = new NBTTagCompound();
		gravelToSand.setInteger("energy", 3200);
		gravelToSand.setInteger("secondaryChance", 10);
		gravelToSand.setBoolean("overwrite", true);
		gravelToSand.setCompoundTag("input", new NBTTagCompound());
		gravelToSand.setCompoundTag("primaryOutput", new NBTTagCompound());
		gravelToSand.setCompoundTag("secondaryOutput", new NBTTagCompound());

		new ItemStack(Block.gravel).writeToNBT(gravelToSand.getCompoundTag("input"));
		new ItemStack(Block.sand).writeToNBT(gravelToSand.getCompoundTag("primaryOutput"));
		new ItemStack(Blocks.Dust).writeToNBT(gravelToSand.getCompoundTag("secondaryOutput"));
		
		FMLInterModComms.sendRuntimeMessage(ExNihilo.instance, "ThermalExpansion", "PulverizerRecipe", gravelToSand);
		System.out.println("Ex Nihilo: Added Gravel->Sand recipe to TE Pulverizer");
		
//		if(FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe", gravelToSand))
//		{
//			System.out.println("Ex Nihilo: Added Gravel->Sand recipe to TE Pulverizer");
//		}

		NBTTagCompound sandToDust = new NBTTagCompound();
		sandToDust.setInteger("energy", 3200);
		sandToDust.setCompoundTag("input", new NBTTagCompound());
		sandToDust.setCompoundTag("primaryOutput", new NBTTagCompound());

		new ItemStack(Block.sand).writeToNBT(sandToDust.getCompoundTag("input"));
		new ItemStack(Blocks.Dust).writeToNBT(sandToDust.getCompoundTag("primaryOutput"));
		
		FMLInterModComms.sendRuntimeMessage(ExNihilo.instance, "ThermalExpansion", "PulverizerRecipe", sandToDust);
		System.out.println("Ex Nihilo: Added Sand->Dust recipe to TE Pulverizer");
		
//		if(FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe", sandToDust))
//		{
//			System.out.println("Ex Nihilo: Added Sand->Dust recipe to TE Pulverizer");
//		}
	}
}
