package exnihilo.compatibility.foresty;

import java.util.Iterator;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fluids.FluidRegistry;
import forestry.api.apiculture.FlowerManager;

public class HiveList {
	public static ItemStack beehives;
	public static ItemStack extraBeesHives;
	public static ItemStack magicBeesHives;
	
	//Forestry
	public static Hive forest;
	public static Hive meadow;
	public static Hive desert;
	public static Hive jungle;
	public static Hive end;
	public static Hive snow;
	public static Hive swamp;
	
	//Extra Bees
	public static Hive water;
	public static Hive rock;
	public static Hive nether;

	public static boolean generateForestryHives()
	{
		beehives = forestry.api.core.BlockInterface.getBlock("beehives");

		if (beehives != null)
		{
			generateForestHive();
			generateMeadowHive();
			generateDesertHive();
			generateJungleHive();
			generateEndHive();
			generateSnowHive();
			generateSwampHive();

			return true;
		}
		return false;

	}
	
	public static boolean generateExtreBeesHives()
	{
		Block ebHives = null;
		
		for (Block b : Block.blocksList)
		{
			if (b != null)
			{
				if (b.getClass().getName().contains("binnie.extrabees.worldgen.BlockExtraBeeHive"))
				{
					ebHives = b;
				}
			}
		}
		
		if (ebHives != null)
		{
			extraBeesHives = new ItemStack(ebHives, 1, 0);
			
			generateWaterHive();
			generateRockHive();
			generateNetherHive();
			return true;
		}
		
		return false;
	}

	
	public static boolean generateMagicBeesHives()
	{
		Block magicHives = null;
		
		for (Block b : Block.blocksList)
		{
			if (b != null)
			{
				if (b.getClass().getName().contains("magicbees.block.BlockHive"))
				{
					magicHives = b;
				}
			}
		}
		
		if (magicHives != null)
		{
			magicBeesHives = new ItemStack(magicHives, 1, 0);
			return true;
		}
		
		return false;
	}
	
	
	
	private static void generateForestHive()
	{
		forest = new Hive(beehives.itemID, 1);
		forest.minRainfall = 0.29f;
		forest.maxRainfall = 0.9f;
		forest.minTemperature = 0.19f;
		forest.maxTemperature = 1.2f;

		forest.requiredCanSeeSky = true;
		forest.requiresTree = true;

		forest.biomeTypes.add(Type.FOREST);
		forest.defaultSpawnBonus = 20;
	}

	private static void generateMeadowHive()
	{
		meadow = new Hive(beehives.itemID, 2);
		meadow.minRainfall = 0.29f;
		meadow.maxRainfall = 0.9f;
		meadow.minTemperature = 0.19f;
		meadow.maxTemperature = 1.2f;

		meadow.requiredCanSeeSky = true;

		meadow.biomeTypes.add(Type.PLAINS);

		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			meadow.flowers.add(item.itemID + ":" + item.getItemDamage());
		}
	}

	private static void generateDesertHive()
	{
		desert = new Hive(beehives.itemID, 3);
		desert.maxRainfall = 0.0f;
		desert.minTemperature = 1.19f;

		desert.requiredCanSeeSky = true;

		desert.biomeTypes.add(Type.DESERT);

		desert.flowers.add(Block.cactus.blockID + ":0");
	}

	public static void generateJungleHive()
	{
		jungle = new Hive(beehives.itemID, 4);
		jungle.minRainfall = 0.89f;
		jungle.minTemperature = 1.19f;

		jungle.requiredCanSeeSky = true;
		jungle.requiresTree = true;

		jungle.biomeTypes.add(Type.JUNGLE);

		jungle.flowers.add(Block.vine.blockID + ":0");
		jungle.flowers.add(Block.vine.blockID + ":1");
		jungle.flowers.add(Block.vine.blockID + ":2");
		jungle.flowers.add(Block.vine.blockID + ":3");
		jungle.flowers.add(Block.vine.blockID + ":4");
		jungle.flowers.add(Block.vine.blockID + ":5");
		jungle.flowers.add(Block.vine.blockID + ":6");
		jungle.flowers.add(Block.vine.blockID + ":7");
		jungle.flowers.add(Block.vine.blockID + ":8");
		jungle.flowers.add(Block.vine.blockID + ":9");
		jungle.flowers.add(Block.vine.blockID + ":10");
		jungle.flowers.add(Block.vine.blockID + ":11");
		jungle.flowers.add(Block.vine.blockID + ":12");
		jungle.flowers.add(Block.vine.blockID + ":13");
		jungle.flowers.add(Block.vine.blockID + ":14");
		jungle.flowers.add(Block.vine.blockID + ":15");
	}

	public static void generateEndHive()
	{
		end = new Hive(beehives.itemID, 5);
		end.requiredCanSeeSky = true;
		end.requiredSubstrate = Block.whiteStone.blockID + ":0";
		end.biomeTypes.add(Type.END);
		end.defaultSpawnBonus = -40;
	}

	public static void generateSnowHive()
	{
		snow = new Hive(beehives.itemID, 6);
		snow.maxTemperature = 0.05f;

		snow.requiredCanSeeSky = true;
		snow.requiredSubstrate = Block.snow.blockID + ":0";
		
		snow.biomeTypes.add(Type.FROZEN);
		
		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			snow.flowers.add(item.itemID + ":" + item.getItemDamage());
		}
	}

	public static void generateSwampHive()
	{
		swamp = new Hive(beehives.itemID, 7);
		swamp.minRainfall = 0.89f;
		swamp.minTemperature = 0.19f;
		swamp.maxTemperature = 1.2f;

		swamp.requiredCanSeeSky = true;

		swamp.biomeTypes.add(Type.SWAMP);

		swamp.flowers.add(Block.mushroomBrown.blockID + ":0");
		swamp.flowers.add(Block.mushroomRed.blockID + ":0");
	}
	
	//EXTRA BEES!
	public static void generateWaterHive()
	{
		water = new Hive(extraBeesHives.itemID, 0);
		water.minTemperature = 0.19f;

		water.biomeTypes.add(Type.WATER);
		water.requiredSubstrate = FluidRegistry.WATER.getBlockID() + ":0";
		water.flowers.add(Block.waterlily.blockID + ":0");
	}
	
	public static void generateRockHive()
	{
		rock = new Hive(extraBeesHives.itemID, 1);

		rock.requiredCanSeeSky = false;

		rock.requiredSubstrate = Block.stone.blockID + ":0";
		rock.defaultSpawnBonus = -20;
	}
	
	public static void generateNetherHive()
	{
		nether = new Hive(extraBeesHives.itemID, 2);

		nether.requiredCanSeeSky = false;

		nether.biomeTypes.add(Type.NETHER);
		nether.requiredSubstrate = Block.netherrack.blockID + ":0";
		nether.flowers.add(Block.netherStalk.blockID + ":0");
		nether.flowers.add(Block.netherStalk.blockID + ":1");
		nether.flowers.add(Block.netherStalk.blockID + ":2");
		nether.flowers.add(Block.netherStalk.blockID + ":4");
	}
}
