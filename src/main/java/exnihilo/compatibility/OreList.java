package exnihilo.compatibility;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.helpers.Color;

public class OreList{
	public static boolean dropCopper = false;
	public static boolean dropTin = false;
	public static boolean dropSilver = false;
	public static boolean dropLead = false;
	public static boolean dropNickel = false;
	public static boolean dropPlatinum = false;
	public static boolean dropAluminum = false;
	public static boolean dropOsmium = false;

	public static void load(Configuration config)
	{
		String CATEGORY_ORE_OPTIONS = "force ore to generate";

		dropCopper = config.get(CATEGORY_ORE_OPTIONS, "copper", false).getBoolean(false);
		dropTin = config.get(CATEGORY_ORE_OPTIONS, "tin", false).getBoolean(false);
		dropLead = config.get(CATEGORY_ORE_OPTIONS, "lead", false).getBoolean(false);
		dropSilver = config.get(CATEGORY_ORE_OPTIONS, "silver", false).getBoolean(false);
		dropNickel = config.get(CATEGORY_ORE_OPTIONS, "nickel", false).getBoolean(false);
		dropPlatinum = config.get(CATEGORY_ORE_OPTIONS, "platinum", false).getBoolean(false);
		dropAluminum = config.get(CATEGORY_ORE_OPTIONS, "aluminum", false).getBoolean(false);
		dropOsmium = config.get(CATEGORY_ORE_OPTIONS, "osmium", false).getBoolean(false);
	}

	public static void registerOres()
	{
		//Debug code. Change this to true to make all the ores generate.
		boolean ignoreOreDict = false;

		OreRegistry.createOverworldOre("iron", new Color("F2AB7C"), 5, Items.iron_ingot);
		OreRegistry.createNetherOre("iron", new Color("F2AB7C"), 6, Items.iron_ingot);
		Item brokenIron = OreRegistry.getBroken("iron");
		HammerRegistry.registerOre(Blocks.iron_ore, 0, brokenIron, 0);
		
		OreRegistry.createOverworldOre("gold", new Color("FFD000"), 32, Items.gold_ingot);
		OreRegistry.createNetherOre("gold",  new Color("FFD000"), 6, Items.gold_ingot);
		Item brokenGold = OreRegistry.getBroken("gold");
		HammerRegistry.registerOre(Blocks.gold_ore, 0, brokenGold, 0);
		
		if (OreDictionary.getOres("oreCopper").size() > 0 || ignoreOreDict || dropCopper)
		{
			OreRegistry.createOverworldOre("copper", new Color("FF4D00"), 18);
			OreRegistry.createNetherOre("copper", new Color("FF4D00"), 10);
		}

		if (OreDictionary.getOres("oreTin").size() > 0 || ignoreOreDict || dropTin)
		{
			OreRegistry.createOverworldOre("tin", new Color("ABC9B6"), 18);
			OreRegistry.createEnderOre("tin", new Color("ABC9B6"), 10);
		}

		if (OreDictionary.getOres("oreSilver").size() > 0 || ignoreOreDict || dropSilver)
		{
			OreRegistry.createOverworldOre("silver", new Color("8CC9FF"), 45);
			OreRegistry.createEnderOre("silver", new Color("8CC9FF"), 6);
		}

		if (OreDictionary.getOres("oreLead").size() > 0 || ignoreOreDict || dropLead)
		{
			OreRegistry.createOverworldOre("lead", new Color("2D2563"), 32);
			OreRegistry.createEnderOre("lead", new Color("2D2563"), 6);
		}

		if (OreDictionary.getOres("oreNickel").size() > 0 || ignoreOreDict || dropNickel)
		{
			OreRegistry.createOverworldOre("nickel", new Color("BAB877"), 32);
			OreRegistry.createNetherOre("nickel", new Color("BAB877"), 10);
		}

		if (OreDictionary.getOres("orePlatinum").size() > 0 || ignoreOreDict || dropPlatinum)
		{
			//No overworld platinum
			OreRegistry.createOverworldOre("platinum", new Color("38CDFF"), 128);
			OreRegistry.createEnderOre("platinum", new Color("38CDFF"), 20);
		}

		if (OreDictionary.getOres("oreAluminum").size() > 0 || OreDictionary.getOres("oreAluminium").size() > 0 || ignoreOreDict  || dropAluminum)
		{
			OreRegistry.createOverworldOre("aluminum", new Color("FFC7C7"), 8);
			
			Item ingot = OreRegistry.getIngot("aluminum");
			if (ingot != null)
			{
				OreRegistry.registerOreDict("aluminium", ingot);
			}
		}

		if (OreDictionary.getOres("oreOsmium").size() > 0 || ignoreOreDict || dropPlatinum)
		{
			OreRegistry.createOverworldOre("osmium", new Color("608FC4"), 10);
		}
	}
}
