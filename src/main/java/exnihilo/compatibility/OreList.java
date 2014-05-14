package exnihilo.compatibility;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Color;

public class OreList{

	public static void registerOres()
	{
	  boolean ignoreOreDict = true;
	  
		OreRegistry.createOverworldOre("iron", new Color("F2AB7C"), 5, Items.iron_ingot);
    OreRegistry.createOverworldOre("gold", new Color("FFD000"), 12, Items.gold_ingot);
		
		if (OreDictionary.getOres("oreCopper").size() > 0 || ignoreOreDict || SieveRegistry.dropCopper)
		{
		  OreRegistry.createOverworldOre("copper", new Color("FF4D00"), 7);
		}
		
    if (OreDictionary.getOres("oreTin").size() > 0 || ignoreOreDict || SieveRegistry.dropTin)
    {
      OreRegistry.createOverworldOre("tin", new Color("ABC9B6"), 7);
    }
    
    if (OreDictionary.getOres("oreSilver").size() > 0 || ignoreOreDict || SieveRegistry.dropSilver)
    {
      OreRegistry.createOverworldOre("silver", new Color("ADC6DB"), 11);
    }
		
    if (OreDictionary.getOres("oreLead").size() > 0 || ignoreOreDict || SieveRegistry.dropLead)
    {
      OreRegistry.createOverworldOre("lead", new Color("2D2563"), 10);
    }
    
    if (OreDictionary.getOres("oreNickel").size() > 0 || ignoreOreDict || SieveRegistry.dropNickel)
    {
      OreRegistry.createOverworldOre("nickel", new Color("BAB877"), 12);
    }
    
    if (OreDictionary.getOres("orePlatinum").size() > 0 || ignoreOreDict || SieveRegistry.dropPlatinum)
    {
      OreRegistry.createOverworldOre("platinum", new Color("38CDFF"), 40);
    }
    
    if (OreDictionary.getOres("oreAluminum").size() > 0 || OreDictionary.getOres("oreAluminium").size() > 0 || ignoreOreDict  || SieveRegistry.dropAluminum)
    {
      Item aluminumIngot = OreRegistry.createOverworldOre("aluminum", new Color("FFC7C7"), 10);
      OreRegistry.registerOreDict("aluminium", aluminumIngot);
    }
    
    if (OreDictionary.getOres("oreOsmium").size() > 0 || ignoreOreDict)
    {
      OreRegistry.createOverworldOre("osmium", new Color("608FC4"), 10);
    }
	}
}
