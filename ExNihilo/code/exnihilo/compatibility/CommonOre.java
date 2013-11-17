package exnihilo.compatibility;

import java.util.ArrayList;
import java.util.Iterator;

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
		//TODO: There is a bunch of code in the SieveRegistry that needs to be moved here.
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

			registerHammerRecipe(ore.itemID, ore.getItemDamage(), rewardID, rewardMeta);
		}
	}
	
	private static void registerHammerRecipe(int oreID, int oreMeta, int rewardID, int rewardMeta)
	{
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 0.5f, 0.1f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 0.05f, 0.1f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 0.0f, 0.05f);
	}
	
	public static void registerIngots()
	{
		OreDictionary.registerOre("ingotCopper", Items.CopperIngot);
		OreDictionary.registerOre("ingotTin", Items.TinIngot);
		OreDictionary.registerOre("ingotSilver", Items.SilverIngot);
		OreDictionary.registerOre("ingotLead", Items.LeadIngot);
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
