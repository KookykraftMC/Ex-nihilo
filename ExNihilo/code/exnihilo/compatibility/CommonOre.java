package exnihilo.compatibility;

import java.util.ArrayList;
import java.util.Iterator;

import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Smashable;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CommonOre {
	public static void registerOres()
	{
		registerCopperOres();
		registerTinOres();
		registerSilverOres();
		registerLeadOres();
	}
	
	public static void registerRecipes()
	{
		ArrayList<ItemStack> ores;
		
		ores = OreDictionary.getOres("ingotCopper");
		if (ores.size() > 1)
		{
			SieveRegistry.dropCopper = true;
		}
		
		ores = OreDictionary.getOres("oreCopper");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, Items.CopperGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotTin");
		if (ores.size() > 1)
		{
			SieveRegistry.dropTin = true;
		}
		
		ores = OreDictionary.getOres("oreTin");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, Items.TinGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotSilver");
		if (ores.size() > 1)
		{
			SieveRegistry.dropSilver = true;
		}
		
		ores = OreDictionary.getOres("oreSilver");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, Items.SilverGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotLead");
		if (ores.size() > 1)
		{
			SieveRegistry.dropLead = true;
		}
		
		ores = OreDictionary.getOres("oreLead");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, Items.LeadGravel.itemID, 0);
		}
		
		SieveRegistry.RegisterOptionalOres();
	}
	
	private static void registerHammerRecipes(ArrayList<ItemStack> ores, int rewardID, int rewardMeta)
	{
		Iterator<ItemStack> it = ores.iterator();
		while(it.hasNext())
		{
			ItemStack ore = it.next();

			HammerRegistry.registerOre(ore.itemID, ore.getItemDamage(), rewardID, rewardMeta);
		}
	}
	
	public static void registerIngots()
	{
		OreDictionary.registerOre("ingotCopper", Items.CopperIngot);
		OreDictionary.registerOre("ingotTin", Items.TinIngot);
		OreDictionary.registerOre("ingotSilver", Items.SilverIngot);
		OreDictionary.registerOre("ingotLead", Items.LeadIngot);
	}
	
	private static void registerCopperOres()
	{
		HammerRegistry.registerOre(Blocks.CopperOre.blockID, 0, Items.CopperSand.itemID, 0);
		HammerRegistry.registerOre(Blocks.CopperOre.blockID, 1, Items.CopperDust.itemID, 0);
	}
	
	private static void registerTinOres()
	{
		HammerRegistry.registerOre(Blocks.TinOre.blockID, 0, Items.TinSand.itemID, 0);
		HammerRegistry.registerOre(Blocks.TinOre.blockID, 1, Items.TinDust.itemID, 0);
	}
	
	private static void registerSilverOres()
	{
		HammerRegistry.registerOre(Blocks.SilverOre.blockID, 0, Items.SilverSand.itemID, 0);
		HammerRegistry.registerOre(Blocks.SilverOre.blockID, 1, Items.SilverDust.itemID, 0);
	}
	
	private static void registerLeadOres()
	{
		HammerRegistry.registerOre(Blocks.LeadOre.blockID, 0, Items.LeadSand.itemID, 0);
		HammerRegistry.registerOre(Blocks.LeadOre.blockID, 1, Items.LeadDust.itemID, 0);
	}
	
	public static void dumpUnlocalizedNames()
	{
		for (Item b : Item.itemsList)
		{
			if (b != null)
			{
				if (b.getUnlocalizedName().contains("apatite"))
				{
					System.out.println(b.getUnlocalizedName());
				}
			}
		}
	}
}
