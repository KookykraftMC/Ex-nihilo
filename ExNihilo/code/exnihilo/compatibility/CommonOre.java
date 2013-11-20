package exnihilo.compatibility;

import java.util.ArrayList;
import java.util.Iterator;

import cpw.mods.fml.common.registry.GameRegistry;

import exnihilo.Blocks;
import exnihilo.Items;
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
		
		ores = OreDictionary.getOres("ingotNickel");
		if (ores.size() > 1)
		{
			SieveRegistry.dropNickel = true;
		}
		
		ores = OreDictionary.getOres("oreNickel");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, Items.NickelGravel.itemID, 0);
		}
		
		ores = OreDictionary.getOres("ingotPlatinum");
		if (ores.size() > 1)
		{
			SieveRegistry.dropPlatinum = true;
		}
		
		ores = OreDictionary.getOres("orePlatinum");
		if (ores.size() > 0)
		{
			registerHammerRecipes(ores, Items.PlatinumGravel.itemID, 0);
		}
		
		registerFurnaceRecipes();
		registerOreRecipes();
		SieveRegistry.RegisterOptionalOres();
	}
	
	private static void registerOreRecipes() {
		//Copper
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.CopperOre, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.CopperGravel
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.CopperOre, 1, 1),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.CopperSand
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.CopperOre, 1, 2),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.CopperDust
								}));
		
		//Tin
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.TinOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.TinGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.TinOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.TinSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.TinOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.TinDust
										}));
				
				//Silver
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.SilverOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.SilverGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.SilverOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.SilverSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.SilverOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.SilverDust
										}));
				
				//Lead
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.LeadOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.LeadGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.LeadOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.LeadSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.LeadOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.LeadDust
										}));
				
				//Nickel	
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.NickelOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.NickelGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.NickelOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.NickelSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.NickelOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.NickelDust
										}));
				
				
				//Platinum	
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.PlatinumOre, 1, 0),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.PlatinumGravel
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.PlatinumOre, 1, 1),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.PlatinumSand
										}));

				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Blocks.PlatinumOre, 1, 2),
								new Object[]
										{
									"xx",
									"xx",
									'x', Items.PlatinumDust
										}));
	}
	
	private static void registerFurnaceRecipes()
	{
		FurnaceRecipes.smelting().addSmelting(Blocks.CopperOre.blockID, 0, new ItemStack(Items.CopperIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.CopperOre.blockID, 1, new ItemStack(Items.CopperIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.CopperOre.blockID, 2, new ItemStack(Items.CopperIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(Blocks.TinOre.blockID, 0, new ItemStack(Items.TinIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.TinOre.blockID, 1, new ItemStack(Items.TinIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.TinOre.blockID, 2, new ItemStack(Items.TinIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(Blocks.SilverOre.blockID, 0, new ItemStack(Items.SilverIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.SilverOre.blockID, 1, new ItemStack(Items.SilverIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.SilverOre.blockID, 2, new ItemStack(Items.SilverIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(Blocks.LeadOre.blockID, 0, new ItemStack(Items.LeadIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.LeadOre.blockID, 1, new ItemStack(Items.LeadIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.LeadOre.blockID, 2, new ItemStack(Items.LeadIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(Blocks.NickelOre.blockID, 0, new ItemStack(Items.NickelIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.NickelOre.blockID, 1, new ItemStack(Items.NickelIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.NickelOre.blockID, 2, new ItemStack(Items.NickelIngot, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(Blocks.PlatinumOre.blockID, 0, new ItemStack(Items.PlatinumIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.PlatinumOre.blockID, 1, new ItemStack(Items.PlatinumIngot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.PlatinumOre.blockID, 2, new ItemStack(Items.PlatinumIngot, 1, 0), 0.1f);
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
		OreDictionary.registerOre("ingotNickel", Items.NickelIngot);
		OreDictionary.registerOre("ingotPlatinum", Items.PlatinumIngot);
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
	
	private static void registerNickleOres()
	{
		HammerRegistry.registerOre(Blocks.NickelOre.blockID, 0, Items.NickelSand.itemID, 0);
		HammerRegistry.registerOre(Blocks.NickelOre.blockID, 1, Items.NickelDust.itemID, 0);
	}
	
	private static void registerPlatinumOres()
	{
		HammerRegistry.registerOre(Blocks.PlatinumOre.blockID, 0, Items.PlatinumSand.itemID, 0);
		HammerRegistry.registerOre(Blocks.PlatinumOre.blockID, 1, Items.PlatinumDust.itemID, 0);
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
