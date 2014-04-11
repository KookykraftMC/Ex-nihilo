package exnihilo.registries;

import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import exnihilo.registries.helpers.Meltable;

public class CrucibleRegistry {
	public static Hashtable<String, Meltable> entries = new Hashtable<String, Meltable>();
	
	public static void register(int id, int meta, float solidAmount, Fluid fluid, float fluidAmount, Block appearance)
	{
		Meltable entry = new Meltable(id, meta, solidAmount, fluid, fluidAmount, appearance);
		entries.put(id + ":" + meta, entry);
	}
	
	public static boolean containsItem(int id, int meta)
	{
		return entries.containsKey(id + ":" + meta);
	}
	
	
	public static Meltable getItem(int id, int meta)
	{
		return entries.get(id + ":" + meta);
	}
	
	public static void load(Configuration config)
	{
		//TODO Allow the ratios to be set in the config?
		//TODO Before that, make sure to handle the edge case where you get more fluid out than solids that you put in.
	}

	public static void registerMeltables() 
	{
		register(Block.getIdFromBlock(Blocks.cobblestone), 0, 2000, FluidRegistry.LAVA, 250, Blocks.cobblestone);
		register(Block.getIdFromBlock(Blocks.stone), 0, 2000, FluidRegistry.LAVA, 250, Blocks.stone);
		register(Block.getIdFromBlock(Blocks.gravel), 0, 2000, FluidRegistry.LAVA, 250, Blocks.gravel);
		register(Block.getIdFromBlock(Blocks.netherrack), 0, 2000, FluidRegistry.LAVA, 1000, Blocks.netherrack);
		
		register(Block.getIdFromBlock(Blocks.snow), 0, 2000, FluidRegistry.WATER, 500, Blocks.snow);
		register(Block.getIdFromBlock(Blocks.ice), 0, 2000, FluidRegistry.WATER, 1000, Blocks.ice);
	}
}
