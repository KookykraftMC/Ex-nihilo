package exnihilo.registries;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minecraft.block.Block;

import exnihilo.registries.helpers.Compostable;
import exnihilo.registries.helpers.HeatSource;

public class HeatRegistry {
	public static Hashtable<String, HeatSource> entries = new Hashtable<String, HeatSource>();
	
	public static void register(int id, int meta, float value)
	{
		HeatSource entry = new HeatSource(id, meta, value);
		entries.put(id + ":" + meta, entry);
	}
	
	public static boolean containsItem(int id, int meta)
	{
		return entries.containsKey(id + ":" + meta);
	}
	
	public static HeatSource getItem(int id, int meta)
	{
		return entries.get(id + ":" + meta);
	}
	
	public static void registerVanillaHeatSources()
	{
		register(Block.torchWood.blockID, 0, 0.1f);
		register(Block.lavaStill.blockID, 0, 0.2f);
		register(Block.lavaMoving.blockID, 0, 0.1f);
		register(Block.furnaceBurning.blockID, 0, 0.15f);
		register(Block.fire.blockID, 0, 0.3f);
	}
}
