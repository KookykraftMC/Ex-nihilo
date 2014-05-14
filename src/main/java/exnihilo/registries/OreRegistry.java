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
	public static Hashtable<String, BlockOre> blocks = new Hashtable<String, BlockOre>();
	public static Hashtable<String, ItemOre> items = new Hashtable<String, ItemOre>();
	
	private static void registerOreBlock(String name, BlockOre block)
	{
		if (!blocks.containsValue(block))
		{
			blocks.put(block.getUnlocalizedName(), block);
			GameRegistry.registerBlock(block, block.getName());
		}
		
		if (!ores.contains(name))
		{
			ores.add(name);
		}
	}
	
	public static BlockOre getOreBlock(String name)
	{
		return blocks.get(name);
	}
	
	private static void registerOreItem(String name, ItemOre item)
	{
		if (!items.containsValue(item))
		{
			items.put(item.getUnlocalizedName(), item);
			GameRegistry.registerItem(item, item.getUnlocalizedName());
		}
		
		if (!ores.contains(name))
		{
			ores.add(name);
		}
	}
	
	public static ItemOre getOreItem(String name)
	{
		return items.get(name);
	}
	
	public static Item createOverworldOre(String name, Color color, int rarity)
  {
	  return createOverworldOre(name, color, rarity, null);
  }
	
	public static Item createOverworldOre(String name, Color color, int rarity, Item existingIngot)
	{
		if (ores.contains(name.toLowerCase()))
		{
			//This ore has already been generated. Swift exit required.
			return null;
		}else
		{
			ores.add(name.toLowerCase());
		}
		
		//Create ore blocks.
		BlockOre gravel = BlockOreFactory.MakeOverworldGravel(name, color);
		BlockOre sand = BlockOreFactory.MakeSand(name, color);
		BlockOre dust = BlockOreFactory.MakeDust(name, color);
		
		registerOreBlock(gravel.getUnlocalizedName(), gravel);
		registerOreBlock(sand.getUnlocalizedName(), sand);
		registerOreBlock(dust.getUnlocalizedName(), dust);
		
		//Create ore items.
		ItemOre broken = ItemOreFactory.MakeOverworldBrokenOre(name, color);
		ItemOre crushed = ItemOreFactory.MakeCrushedOre(name, color);
		ItemOre powdered = ItemOreFactory.MakePulverizedOre(name, color);
		
		registerOreItem(broken.getUnlocalizedName(), broken);
		registerOreItem(crushed.getUnlocalizedName(), crushed);
		registerOreItem(powdered.getUnlocalizedName(), powdered);
		
		//Use an existing ingot if it's specified.
		Item ingot;
		if (existingIngot != null)
		{
		  ingot = existingIngot;
		}else
		{
		  ItemOre newIngot = ItemOreFactory.MakeIngot(name, color);
		  registerOreItem(newIngot.getUnlocalizedName(), newIngot);
		  
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
		registerFurnaceRecipe(gravel, ingot);
		registerFurnaceRecipe(sand, ingot);
		registerFurnaceRecipe(dust, ingot);
		
		//register ore dictionary names.
		registerOreDict(name, ingot);
		
		//register sieve recipes
		registerSieveRecipe(Blocks.gravel, broken, rarity);
		registerSieveRecipe(Blocks.sand, crushed, rarity);
		registerSieveRecipe(ENBlocks.Dust, powdered, rarity);
		
		return ingot;
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
}
