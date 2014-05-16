package exnihilo.compatibility;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
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
		OreRegistry.createOverworldOre("gold", new Color("FFD000"), 12, Items.gold_ingot);

		if (OreDictionary.getOres("oreCopper").size() > 0 || ignoreOreDict || dropCopper)
		{
			OreRegistry.createOverworldOre("copper", new Color("FF4D00"), 7);
		}

		if (OreDictionary.getOres("oreTin").size() > 0 || ignoreOreDict || dropTin)
		{
			OreRegistry.createOverworldOre("tin", new Color("ABC9B6"), 7);
		}

		if (OreDictionary.getOres("oreSilver").size() > 0 || ignoreOreDict || dropSilver)
		{
			OreRegistry.createOverworldOre("silver", new Color("8CC9FF"), 11);
		}

		if (OreDictionary.getOres("oreLead").size() > 0 || ignoreOreDict || dropLead)
		{
			OreRegistry.createOverworldOre("lead", new Color("2D2563"), 10);
		}

		if (OreDictionary.getOres("oreNickel").size() > 0 || ignoreOreDict || dropNickel)
		{
			OreRegistry.createOverworldOre("nickel", new Color("BAB877"), 12);
		}

		if (OreDictionary.getOres("orePlatinum").size() > 0 || ignoreOreDict || dropPlatinum)
		{
			OreRegistry.createOverworldOre("platinum", new Color("38CDFF"), 40);
		}

		if (OreDictionary.getOres("oreAluminum").size() > 0 || OreDictionary.getOres("oreAluminium").size() > 0 || ignoreOreDict  || dropAluminum)
		{
			OreRegistry.createOverworldOre("aluminum", new Color("FFC7C7"), 10);

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
