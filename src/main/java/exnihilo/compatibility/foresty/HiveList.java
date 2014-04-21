package exnihilo.compatibility.foresty;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fluids.FluidRegistry;
import forestry.api.apiculture.FlowerManager;
import forestry.core.config.ForestryBlock;

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

	//Extra Bees
	public static Hive curious;
	public static Hive resonating;
	public static Hive unusual;
	public static Hive deep;
	public static Hive oblivion;
	public static Hive infernal;

	public static boolean generateForestryHives()
	{
		beehives = new ItemStack(ForestryBlock.beehives);

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

	//Not updated to 1.7 yet
//	public static boolean generateExtreBeesHives()
//	{
//		Block ebHives = null;
//
//		for (Block b : Block.blocksList)
//		{
//			if (b != null)
//			{
//				if (b.getClass().getName().contains("binnie.extrabees.worldgen.BlockExtraBeeHive"))
//				{
//					ebHives = b;
//				}
//			}
//		}
//
//		if (ebHives != null)
//		{
//			extraBeesHives = new ItemStack(ebHives, 1, 0);
//
//			generateWaterHive();
//			generateRockHive();
//			generateNetherHive();
//			return true;
//		}
//
//		return false;
//	}


	//Not updated to 1.7 yet
//	public static boolean generateMagicBeesHives()
//	{
//		Block magicHives = null;
//
//		for (Block b : Block.blocksList)
//		{
//			if (b != null)
//			{
//				if (b.getClass().getName().contains("magicbees.block.BlockHive"))
//				{
//					magicHives = b;
//				}
//			}
//		}
//
//		if (magicHives != null)
//		{
//			magicBeesHives = new ItemStack(magicHives, 1, 0);
//			
//			generateCuriousHive();
//			generateResonatingHive();
//			generateUnusualHive();
//			generateDeepHive();
//			generateOblivionHive();
//			generateInfernalHive();
//			return true;
//		}
//
//		return false;
//	}



	private static void generateForestHive()
	{
		forest = new Hive(Block.getBlockFromItem(beehives.getItem()), 1);

		forest.requiredCanSeeSky = true;
		forest.requiresTree = true;

		forest.biomeTypes.add(Type.FOREST);
		forest.defaultSpawnBonus = 20;
	}

	private static void generateMeadowHive()
	{
		meadow = new Hive(Block.getBlockFromItem(beehives.getItem()), 2);

		meadow.requiredCanSeeSky = true;

		meadow.biomeTypes.add(Type.PLAINS);

		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			meadow.flowers.add(item + ":" + item.getItemDamage());
		}
	}

	private static void generateDesertHive()
	{
		desert = new Hive(Block.getBlockFromItem(beehives.getItem()), 3);

		desert.requiredCanSeeSky = true;

		desert.biomeTypes.add(Type.DESERT);

		desert.flowers.add(Blocks.cactus + ":0");
	}

	public static void generateJungleHive()
	{
		jungle = new Hive(Block.getBlockFromItem(beehives.getItem()), 4);

		jungle.requiredCanSeeSky = true;
		jungle.requiresTree = true;

		jungle.biomeTypes.add(Type.JUNGLE);

		jungle.flowers.add(Blocks.vine + ":0");
		jungle.flowers.add(Blocks.vine + ":1");
		jungle.flowers.add(Blocks.vine + ":2");
		jungle.flowers.add(Blocks.vine + ":3");
		jungle.flowers.add(Blocks.vine + ":4");
		jungle.flowers.add(Blocks.vine + ":5");
		jungle.flowers.add(Blocks.vine + ":6");
		jungle.flowers.add(Blocks.vine + ":7");
		jungle.flowers.add(Blocks.vine + ":8");
		jungle.flowers.add(Blocks.vine + ":9");
		jungle.flowers.add(Blocks.vine + ":10");
		jungle.flowers.add(Blocks.vine + ":11");
		jungle.flowers.add(Blocks.vine + ":12");
		jungle.flowers.add(Blocks.vine + ":13");
		jungle.flowers.add(Blocks.vine + ":14");
		jungle.flowers.add(Blocks.vine + ":15");
	}

	public static void generateEndHive()
	{
		end = new Hive(Block.getBlockFromItem(beehives.getItem()), 5);
		end.requiredCanSeeSky = true;
		end.requiredSubstrate = Blocks.end_stone + ":0";
		end.biomeTypes.add(Type.END);
		end.defaultSpawnBonus = -40;
	}

	public static void generateSnowHive()
	{
		snow = new Hive(Block.getBlockFromItem(beehives.getItem()), 6);

		snow.requiredCanSeeSky = true;
		snow.requiredSubstrate = Blocks.snow + ":0";

		snow.biomeTypes.add(Type.FROZEN);

		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			snow.flowers.add(item + ":" + item.getItemDamage());
		}
	}

	public static void generateSwampHive()
	{
		swamp = new Hive(Block.getBlockFromItem(beehives.getItem()), 7);

		swamp.requiredCanSeeSky = true;

		swamp.biomeTypes.add(Type.SWAMP);

		swamp.flowers.add(Blocks.brown_mushroom + ":0");
		swamp.flowers.add(Blocks.red_mushroom + ":0");
	}

	//EXTRA BEES!
	public static void generateWaterHive()
	{
		water = new Hive(Block.getBlockFromItem(extraBeesHives.getItem()), 0);

		water.biomeTypes.add(Type.WATER);
		water.requiredSubstrate = FluidRegistry.WATER.getBlock() + ":0";
		water.requiresBlockAbove = FluidRegistry.WATER.getBlock() + ":0";
		water.flowers.add(Blocks.waterlily + ":0");
	}

	public static void generateRockHive()
	{
		rock = new Hive(Block.getBlockFromItem(extraBeesHives.getItem()), 1);

		rock.requiredCanSeeSky = false;

		rock.requiredSubstrate = Blocks.stone + ":0";
		rock.defaultSpawnBonus = -20;
	}

	public static void generateNetherHive()
	{
		nether = new Hive(Block.getBlockFromItem(extraBeesHives.getItem()), 2);

		nether.requiredCanSeeSky = false;

		nether.biomeTypes.add(Type.NETHER);
		nether.requiredSubstrate = Blocks.netherrack + ":0";
		nether.flowers.add(Blocks.nether_wart + ":0");
		nether.flowers.add(Blocks.nether_wart + ":1");
		nether.flowers.add(Blocks.nether_wart + ":2");
		nether.flowers.add(Blocks.nether_wart + ":4");
	}

	//MAGIC BEES!
	public static void generateCuriousHive()
	{
		curious = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 0);
		
		curious.requiredCanSeeSky = true;
		curious.biomeTypes.add(Type.FOREST);
		
		curious.requiresTree = true;
		
		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			curious.flowers.add(item + ":" + item.getItemDamage());
		}
	}

	public static void generateResonatingHive()
	{
		resonating = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 2);
		
		resonating.requiredCanSeeSky = true;
		resonating.biomeTypes.add(Type.DESERT);
		
		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			resonating.flowers.add(item + ":" + item.getItemDamage());
		}
	}

	public static void generateUnusualHive()
	{
		unusual = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 1);
		
		unusual.requiredCanSeeSky = true;
		unusual.biomeTypes.add(Type.JUNGLE);
		
		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			unusual.flowers.add(item + ":" + item.getItemDamage());
		}
	}

	public static void generateDeepHive()
	{
		deep = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 3);
		
		deep.requiredCanSeeSky = false;
		deep.biomeTypes.add(Type.MOUNTAIN);
		deep.maxYLevel = 15.0f;
		
		Iterator<ItemStack> it = FlowerManager.plainFlowers.iterator();
		while(it.hasNext())
		{
			ItemStack item = it.next();
			deep.flowers.add(item + ":" + item.getItemDamage());
		}
	}

	public static void generateOblivionHive()
	{
		oblivion = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 5);
		
		oblivion.requiredCanSeeSky = false;
		oblivion.biomeTypes.add(Type.END);
		oblivion.requiredSubstrate = Blocks.end_stone + ":0";
		oblivion.defaultSpawnBonus = -40;
	}

	public static void generateInfernalHive()
	{
		infernal = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 4);
		
		infernal.requiredCanSeeSky = false;
		infernal.biomeTypes.add(Type.NETHER);
		infernal.maxYLevel = 15.0f;
		infernal.requiredSubstrate = Blocks.netherrack + ":0";
		oblivion.defaultSpawnBonus = -40;
	}

}
