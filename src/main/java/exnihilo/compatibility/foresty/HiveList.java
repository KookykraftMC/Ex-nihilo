package exnihilo.compatibility.foresty;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fluids.FluidRegistry;
import exnihilo.ExNihilo;

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
		Block forHives = GameRegistry.findBlock("Forestry", "beehives");
		
		if (forHives != null)
		{
			beehives = new ItemStack(GameRegistry.findBlock("Forestry", "beehives"));
		}
		
		if (beehives != null){
			generateForestHive();
			generateMeadowHive();
			generateDesertHive();
			generateJungleHive();
			generateEndHive();
			generateSnowHive();
			generateSwampHive();

			ExNihilo.log.info("Compatibility OK!: Forestry Bees");
			
			return true;
		}else{
			ExNihilo.log.info("Compatibility FAIL!: Forestry Bees");
			return false;
		}
	}

	public static boolean generateExtraBeesHives()
	{
		Block ebHives = GameRegistry.findBlock("ExtraBees", "hive");;

		if (ebHives != null)
		{
			extraBeesHives = new ItemStack(ebHives, 1, 0);

			generateWaterHive();
			generateRockHive();
			generateNetherHive();
			
			ExNihilo.log.info("Compatibility OK!: Extra Bees");
			
			return true;
		}
		else
		{
			ExNihilo.log.info("Compatibility FAIL!: Extra Bees");
		}
		
		return false;
	}
	
	
	public static boolean generateMagicBeesHives()
	{
		Block magicHives = GameRegistry.findBlock("ExtraBees", "hive");

		if (magicHives != null)
		{
			magicBeesHives = new ItemStack(magicHives, 1, 0);
			
			generateCuriousHive();
			generateResonatingHive();
			generateUnusualHive();
			generateDeepHive();
			generateOblivionHive();
			generateInfernalHive();
			
			ExNihilo.log.info("Compatibility OK!: Magic Bees");
			
			return true;
		}
		else
		{
			ExNihilo.log.info("Compatibility FAIL!: Magic Bees");
		}
		
		return false;
	}

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
		meadow.flowers = FlowerType.Normal;
		forest.defaultSpawnBonus = 20;
	}

	private static void generateDesertHive()
	{
		desert = new Hive(Block.getBlockFromItem(beehives.getItem()), 3);

		desert.requiredCanSeeSky = true;

		desert.biomeTypes.add(Type.SANDY);

		desert.flowers = FlowerType.Cactus;
	}

	public static void generateJungleHive()
	{
		jungle = new Hive(Block.getBlockFromItem(beehives.getItem()), 4);

		jungle.requiredCanSeeSky = true;
		jungle.requiresTree = true;

		jungle.biomeTypes.add(Type.JUNGLE);
		jungle.flowers = FlowerType.Jungle;
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

		snow.biomeTypes.add(Type.COLD);
	}

	public static void generateSwampHive()
	{
		swamp = new Hive(Block.getBlockFromItem(beehives.getItem()), 7);

		swamp.requiredCanSeeSky = true;

		swamp.biomeTypes.add(Type.SWAMP);
		swamp.flowers = FlowerType.Mushroom;
	}

	//EXTRA BEES!
	public static void generateWaterHive()
	{
		water = new Hive(Block.getBlockFromItem(extraBeesHives.getItem()), 0);

		water.biomeTypes.add(Type.WATER);
		water.requiredSubstrate = FluidRegistry.WATER.getBlock() + ":0";
		water.requiresBlockAbove = FluidRegistry.WATER.getBlock() + ":0";
		water.flowers = FlowerType.Water;
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
		nether.flowers = FlowerType.Nether;
	}

	//MAGIC BEES!
	public static void generateCuriousHive()
	{
		curious = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 0);
		
		curious.requiredCanSeeSky = true;
		curious.biomeTypes.add(Type.FOREST);
		
		curious.requiresTree = true;
		curious.flowers = FlowerType.Gourd;
	}

	public static void generateResonatingHive()
	{
		resonating = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 2);
		
		resonating.requiredCanSeeSky = true;
		resonating.biomeTypes.add(Type.SANDY);
		
		resonating.flowers = FlowerType.Gourd;
	}

	public static void generateUnusualHive()
	{
		unusual = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 1);
		
		unusual.requiredCanSeeSky = true;
		unusual.biomeTypes.add(Type.JUNGLE);
		
		unusual.flowers = FlowerType.Gourd;
	}

	public static void generateDeepHive()
	{
		deep = new Hive(Block.getBlockFromItem(magicBeesHives.getItem()), 3);
		
		deep.requiredCanSeeSky = false;
		deep.biomeTypes.add(Type.MOUNTAIN);
		deep.maxYLevel = 15.0f;
		desert.defaultSpawnBonus = -40;
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
