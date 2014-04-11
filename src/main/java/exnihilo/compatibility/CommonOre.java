package exnihilo.compatibility;

import java.util.ArrayList;
import java.util.Iterator;

import cpw.mods.fml.common.registry.GameRegistry;

import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Smashable;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class CommonOre {
	public static void registerOres()
	{
		registerCopperOres();
		registerTinOres();
		registerSilverOres();
		registerLeadOres();
		registerNickleOres();
		registerPlatinumOres();
		registerAluminumOres();
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
			registerHammerRecipes(ores, ENItems.CopperGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotTin");
		if (ores.size() > 1)
		{
			SieveRegistry.dropTin = true;
		}
		
		ores = OreDictionary.getOres("oreTin");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, ENItems.TinGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotSilver");
		if (ores.size() > 1)
		{
			SieveRegistry.dropSilver = true;
		}
		
		ores = OreDictionary.getOres("oreSilver");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, ENItems.SilverGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotLead");
		if (ores.size() > 1)
		{
			SieveRegistry.dropLead = true;
		}
		
		ores = OreDictionary.getOres("oreLead");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, ENItems.LeadGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotNickel");
		if (ores.size() > 1)
		{
			SieveRegistry.dropNickel = true;
		}
		
		ores = OreDictionary.getOres("oreNickel");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, ENItems.NickelGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotPlatinum");
		if (ores.size() > 1)
		{
			SieveRegistry.dropPlatinum = true;
		}
		
		ores = OreDictionary.getOres("orePlatinum");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, ENItems.PlatinumGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotAluminum");
		if (ores.size() > 1)
		{
			SieveRegistry.dropAluminum = true;
		}
		
		ores = OreDictionary.getOres("oreAluminum");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, ENItems.AluminumGravel.itemID, 0);
		}
		
		registerFurnaceRecipes();
		registerOreRecipes();
		SieveRegistry.RegisterOptionalOres();
	}
	
	private static void registerOreRecipes() {
		//Copper
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.CopperOre, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.CopperGravel
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.CopperOre, 1, 1),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.CopperSand
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.CopperOre, 1, 2),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.CopperDust
								}));
		
		//Tin
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.TinOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.TinGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.TinOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.TinSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.TinOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.TinDust
										}));
				
				//Silver
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.SilverOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.SilverGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.SilverOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.SilverSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.SilverOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.SilverDust
										}));
				
				//Lead
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.LeadOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.LeadGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.LeadOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.LeadSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.LeadOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.LeadDust
										}));
				
				//Nickel	
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.NickelOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.NickelGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.NickelOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.NickelSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.NickelOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.NickelDust
										}));
				
				
				//Platinum	
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.PlatinumOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.PlatinumGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.PlatinumOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.PlatinumSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.PlatinumOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.PlatinumDust
										}));
				
				//Aluminum	
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.AluminumOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.AluminumGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.AluminumOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.AluminumSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.AluminumOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', ENItems.AluminumDust
										}));
	}
	
	private static void registerFurnaceRecipes()
	{
		FurnaceRecipes.smelting().addSmelting(ENBlocks.CopperOre.blockID, 0, new ItemStack(ENItems.CopperIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.CopperOre.blockID, 1, new ItemStack(ENItems.CopperIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.CopperOre.blockID, 2, new ItemStack(ENItems.CopperIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(ENBlocks.TinOre.blockID, 0, new ItemStack(ENItems.TinIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.TinOre.blockID, 1, new ItemStack(ENItems.TinIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.TinOre.blockID, 2, new ItemStack(ENItems.TinIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(ENBlocks.SilverOre.blockID, 0, new ItemStack(ENItems.SilverIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.SilverOre.blockID, 1, new ItemStack(ENItems.SilverIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.SilverOre.blockID, 2, new ItemStack(ENItems.SilverIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(ENBlocks.LeadOre.blockID, 0, new ItemStack(ENItems.LeadIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.LeadOre.blockID, 1, new ItemStack(ENItems.LeadIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.LeadOre.blockID, 2, new ItemStack(ENItems.LeadIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(ENBlocks.NickelOre.blockID, 0, new ItemStack(ENItems.NickelIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.NickelOre.blockID, 1, new ItemStack(ENItems.NickelIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.NickelOre.blockID, 2, new ItemStack(ENItems.NickelIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(ENBlocks.PlatinumOre.blockID, 0, new ItemStack(ENItems.PlatinumIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.PlatinumOre.blockID, 1, new ItemStack(ENItems.PlatinumIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.PlatinumOre.blockID, 2, new ItemStack(ENItems.PlatinumIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(ENBlocks.AluminumOre.blockID, 0, new ItemStack(ENItems.AluminumIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.AluminumOre.blockID, 1, new ItemStack(ENItems.AluminumIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(ENBlocks.AluminumOre.blockID, 2, new ItemStack(ENItems.AluminumIngot, 1, 0), 0.1f);
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
		OreDictionary.registerOre("ingotCopper", ENItems.CopperIngot);
		OreDictionary.registerOre("ingotTin", ENItems.TinIngot);
		OreDictionary.registerOre("ingotSilver", ENItems.SilverIngot);
		OreDictionary.registerOre("ingotLead", ENItems.LeadIngot);
		OreDictionary.registerOre("ingotNickel", ENItems.NickelIngot);
		OreDictionary.registerOre("ingotPlatinum", ENItems.PlatinumIngot);
		OreDictionary.registerOre("ingotAluminum", ENItems.AluminumIngot);
	}
	
	private static void registerCopperOres()
	{
		HammerRegistry.registerOre(ENBlocks.CopperOre.blockID, 0, ENItems.CopperSand.itemID, 0);
		HammerRegistry.registerOre(ENBlocks.CopperOre.blockID, 1, ENItems.CopperDust.itemID, 0);
	}
	
	private static void registerTinOres()
	{
		HammerRegistry.registerOre(ENBlocks.TinOre.blockID, 0, ENItems.TinSand.itemID, 0);
		HammerRegistry.registerOre(ENBlocks.TinOre.blockID, 1, ENItems.TinDust.itemID, 0);
	}
	
	private static void registerSilverOres()
	{
		HammerRegistry.registerOre(ENBlocks.SilverOre.blockID, 0, ENItems.SilverSand.itemID, 0);
		HammerRegistry.registerOre(ENBlocks.SilverOre.blockID, 1, ENItems.SilverDust.itemID, 0);
	}
	
	private static void registerLeadOres()
	{
		HammerRegistry.registerOre(ENBlocks.LeadOre.blockID, 0, ENItems.LeadSand.itemID, 0);
		HammerRegistry.registerOre(ENBlocks.LeadOre.blockID, 1, ENItems.LeadDust.itemID, 0);
	}
	
	private static void registerNickleOres()
	{
		HammerRegistry.registerOre(ENBlocks.NickelOre.blockID, 0, ENItems.NickelSand.itemID, 0);
		HammerRegistry.registerOre(ENBlocks.NickelOre.blockID, 1, ENItems.NickelDust.itemID, 0);
	}
	
	private static void registerPlatinumOres()
	{
		HammerRegistry.registerOre(ENBlocks.PlatinumOre.blockID, 0, ENItems.PlatinumSand.itemID, 0);
		HammerRegistry.registerOre(ENBlocks.PlatinumOre.blockID, 1, ENItems.PlatinumDust.itemID, 0);
	}
	
	private static void registerAluminumOres()
	{
		HammerRegistry.registerOre(ENBlocks.AluminumOre.blockID, 0, ENItems.AluminumSand.itemID, 0);
		HammerRegistry.registerOre(ENBlocks.AluminumOre.blockID, 1, ENItems.AluminumDust.itemID, 0);
	}
	
	public static void dumpUnlocalizedNames(String name)
	{
		for (Block b : Block.blocksList)
		{
			if (b != null)
			{
				if (b.getUnlocalizedName().contains(name))
				{
					System.out.println(b.blockID + ":" + b.getClass().getName());
				}
			}
		}
		
//		for (Item b : Item.itemsList)
//		{
//			if (b != null)
//			{
//				if (b.getUnlocalizedName().contains(name))
//				{
//					System.out.println(b.itemID + ":" + b.getUnlocalizedName());
//				}
//			}
//		}
	}
}
