package exnihilo.registries;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.blocks.ores.BlockOre;
import exnihilo.blocks.ores.BlockOreFactory;
import exnihilo.items.ores.ItemOre;
import exnihilo.items.ores.ItemOreFactory;
import exnihilo.registries.helpers.Color;

public class OreRegistry {
	public static List<String> ores = new ArrayList<String>();
	public static Hashtable<String, BlockOre> gravelTable = new Hashtable<String, BlockOre>();
	public static Hashtable<String, BlockOre> sandTable = new Hashtable<String, BlockOre>();
	public static Hashtable<String, BlockOre> dustTable = new Hashtable<String, BlockOre>();

	public static Hashtable<String, ItemOre> brokenTable = new Hashtable<String, ItemOre>();
	public static Hashtable<String, ItemOre> crushedTable = new Hashtable<String, ItemOre>();
	public static Hashtable<String, ItemOre> powderedTable = new Hashtable<String, ItemOre>();
	public static Hashtable<String, ItemOre> ingotTable = new Hashtable<String, ItemOre>();

	private static void registerOreBlock(String name, BlockOre block, Hashtable<String, BlockOre> table)
	{
		if (!table.containsValue(block))
		{
			table.put(name.toLowerCase(), block);
			GameRegistry.registerBlock(block, block.getName());
		}

		if (!ores.contains(name.toLowerCase()))
		{
			ores.add(name.toLowerCase());
		}
	}

	private static void registerOreItem(String name, ItemOre item, Hashtable<String, ItemOre> table)
	{
		String lname = name.toLowerCase();

		if (!table.containsValue(item))
		{
			table.put(lname, item);
			GameRegistry.registerItem(item, item.getUnlocalizedName());
		}

		if (!ores.contains(lname))
		{
			ores.add(lname);
		}
	}

	public static void createOverworldOre(String name, Color color, int rarity)
	{
		createOverworldOre(name, color, rarity, null, false);
	}
	
	public static void createOverworldOre(String name, Color color, int rarity, Item ingot)
	{
		createOverworldOre(name, color, rarity, ingot, false);
	}

	public static void createOverworldOre(String name, Color color, int rarity, Item existingIngot, boolean skipFurnaceRecipes)
	{
		if (ores.contains(name.toLowerCase()))
		{
			//This ore has already been generated. Swift exit required.
			return;
		}else
		{
			ores.add(name.toLowerCase());
		}

		//Create ore blocks.
		BlockOre gravel = BlockOreFactory.MakeOverworldGravel(name, color);
		BlockOre sand = BlockOreFactory.MakeSand(name, color);
		BlockOre dust = BlockOreFactory.MakeDust(name, color);

		registerOreBlock(gravel.getUnlocalizedName(), gravel, gravelTable);
		registerOreBlock(sand.getUnlocalizedName(), sand, sandTable);
		registerOreBlock(dust.getUnlocalizedName(), dust, dustTable);

		//Create ore items.
		ItemOre broken = ItemOreFactory.MakeOverworldBrokenOre(name, color);
		ItemOre crushed = ItemOreFactory.MakeCrushedOre(name, color);
		ItemOre powdered = ItemOreFactory.MakePulverizedOre(name, color);

		registerOreItem(broken.getUnlocalizedName(), broken, brokenTable);
		registerOreItem(crushed.getUnlocalizedName(), crushed, crushedTable);
		registerOreItem(powdered.getUnlocalizedName(), powdered, powderedTable);

		//Use an existing ingot if it's specified.
		Item ingot;
		if (existingIngot != null)
		{
			ingot = existingIngot;
		}else
		{
			ItemOre newIngot = ItemOreFactory.MakeIngot(name, color);
			registerOreItem(newIngot.getUnlocalizedName(), newIngot, ingotTable);

			ingot = (Item)newIngot;
		}

		//Register hammer recipes.
		ArrayList<ItemStack> ores = OreDictionary.getOres("ingdot" + formatOreName(name));
		if (ores.size() > 1)
		{
			for (ItemStack i : ores)
			{
				registerHammerRecipe(Block.getBlockFromItem(i.getItem()), broken);
			}
		}

		registerHammerRecipe(gravel, crushed);
		registerHammerRecipe(sand, powdered);

		//Register crafting recipes.
		registerCraftingRecipe(broken, gravel);
		registerCraftingRecipe(crushed, sand);
		registerCraftingRecipe(powdered, dust);

		//Register furnace recipes.
		if (!skipFurnaceRecipes)
		{
			registerFurnaceRecipe(gravel, ingot);
			registerFurnaceRecipe(sand, ingot);
			registerFurnaceRecipe(dust, ingot);
		}

		//register ore dictionary names.
		registerOreDict(name, ingot);

		//register sieve recipes
		registerSieveRecipe(Blocks.gravel, broken, rarity);
		registerSieveRecipe(Blocks.sand, crushed, rarity);
		registerSieveRecipe(ENBlocks.Dust, powdered, rarity);
	}

	public static void registerOreDict(String name, Item ingot)
	{
		OreDictionary.registerOre("ingot" + formatOreName(name), ingot);
	}

	private static void registerHammerRecipe(Block block, ItemOre reward)
	{
		HammerRegistry.registerOre(block, 0, reward, 0);
	}

	private static void registerCraftingRecipe(ItemOre ingredient, BlockOre result)
	{
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(result, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', ingredient
								}));
	}

	private static void registerFurnaceRecipe(BlockOre ore, Item ingot)
	{
		FurnaceRecipes.smelting().func_151393_a(ore, new ItemStack(ingot, 1, 0), 0.1f);
	}

	private static void registerSieveRecipe(Block block, ItemOre item, int rarity)
	{
		SieveRegistry.register(block, item, 0, rarity);
	}

	private static String formatOreName(String input)
	{
		String lcase = input.toLowerCase();

		String output = lcase.substring(0, 1).toUpperCase() + lcase.substring(1);

		return output;
	}




	//IO
	public static Block getGravel(String name)
	{
		return gravelTable.get(name.toLowerCase()); 
	}

	public static Block getSand(String name)
	{
		return sandTable.get(name.toLowerCase()); 
	}

	public static Block getDust(String name)
	{
		return dustTable.get(name.toLowerCase()); 
	}

	public static Item getBroken(String name)
	{
		return brokenTable.get(name.toLowerCase());
	}

	public static Item getCrushed(String name)
	{
		return crushedTable.get(name.toLowerCase());
	}

	public static Item getPowdered(String name)
	{
		return powderedTable.get(name.toLowerCase());
	}

	public static Item getIngot(String name)
	{
		return ingotTable.get(name.toLowerCase());
	}
}
