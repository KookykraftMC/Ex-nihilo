package exnihilo;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.data.ItemData;
import exnihilo.items.ItemCrook;
import exnihilo.items.ItemCrookBone;
import exnihilo.items.ItemGrassSeeds;
import exnihilo.items.ItemMesh;
import exnihilo.items.ItemPorcelainBall;
import exnihilo.items.ItemSilkworm;
import exnihilo.items.ItemSilkwormCooked;
import exnihilo.items.ItemSpores;
import exnihilo.items.ItemStone;
import exnihilo.items.dolls.ItemDoll;
import exnihilo.items.dolls.ItemDollAngry;
import exnihilo.items.dolls.ItemDollCreepy;
import exnihilo.items.hammers.ItemHammerDiamond;
import exnihilo.items.hammers.ItemHammerGold;
import exnihilo.items.hammers.ItemHammerIron;
import exnihilo.items.hammers.ItemHammerStone;
import exnihilo.items.hammers.ItemHammerWood;
import exnihilo.items.seeds.ItemSeedAcacia;
import exnihilo.items.seeds.ItemSeedBirch;
import exnihilo.items.seeds.ItemSeedCactus;
import exnihilo.items.seeds.ItemSeedCarrot;
import exnihilo.items.seeds.ItemSeedJungle;
import exnihilo.items.seeds.ItemSeedOak;
import exnihilo.items.seeds.ItemSeedPotato;
import exnihilo.items.seeds.ItemSeedRubber;
import exnihilo.items.seeds.ItemSeedSpruce;
import exnihilo.items.seeds.ItemSeedSugarcane;

public class ENItems {
	public static Item HammerWood;
	public static Item HammerStone;
	public static Item HammerIron;
	public static Item HammerGold;
	public static Item HammerDiamond;
	public static Item Crook;
	public static Item CrookBone;
	public static Item Silkworm;
	public static Item SilkwormCooked;
	public static Item Mesh;
	public static Item Stones;
	public static Item Porcelain;

	public static Item Doll;
	public static Item DollAngry;
	public static Item DollCreepy;

	//Seeds
	public static Item Spores;
	public static Item GrassSeeds;
	public static Item SeedsOak;
	public static Item SeedsAcacia;
	public static Item SeedsSpruce;
	public static Item SeedsBirch;
	public static Item SeedsJungle;
	public static Item SeedsCactus;
	public static Item SeedsSugarcane;
	public static Item SeedsCarrot;
	public static Item SeedsPotato;
	public static Item SeedsRubber;

	public static void registerItems()
	{
		HammerWood = new ItemHammerWood();
		GameRegistry.registerItem(HammerWood, ItemData.HAMMER_UNLOCALIZED_NAMES[0]);

		HammerStone = new ItemHammerStone();
		GameRegistry.registerItem(HammerStone, ItemData.HAMMER_UNLOCALIZED_NAMES[1]);

		HammerIron = new ItemHammerIron();
		GameRegistry.registerItem(HammerIron, ItemData.HAMMER_UNLOCALIZED_NAMES[2]);

		HammerGold = new ItemHammerGold();
		GameRegistry.registerItem(HammerGold, ItemData.HAMMER_UNLOCALIZED_NAMES[3]);

		HammerDiamond = new ItemHammerDiamond();
		GameRegistry.registerItem(HammerDiamond, ItemData.HAMMER_UNLOCALIZED_NAMES[4]);

		Crook = new ItemCrook();
		GameRegistry.registerItem(Crook, ItemData.CROOK_UNLOCALIZED_NAME);
		CrookBone = new ItemCrookBone();
		GameRegistry.registerItem(CrookBone, ItemData.CROOK_BONE_UNLOCALIZED_NAME);
		
		Silkworm = new ItemSilkworm();
		GameRegistry.registerItem(Silkworm, ItemData.SILKWORM_UNLOCALIZED_NAME);

		Mesh = new ItemMesh();
		GameRegistry.registerItem(Mesh, ItemData.MESH_UNLOCALIZED_NAME);

		Spores = new ItemSpores();
		GameRegistry.registerItem(Spores, ItemData.SPORES_UNLOCALIZED_NAME);

		GrassSeeds = new ItemGrassSeeds();
		GameRegistry.registerItem(GrassSeeds, ItemData.SEED_GRASS_UNLOCALIZED_NAME);

		Stones = new ItemStone();
		GameRegistry.registerItem(Stones, ItemData.STONES_UNLOCALIZED_NAME);

		Porcelain = new ItemPorcelainBall();
		GameRegistry.registerItem(Porcelain, ItemData.PORCELAIN_UNLOCALIZED_NAME);

		Doll = new ItemDoll();
		GameRegistry.registerItem(Doll, ItemData.DOLL_UNLOCALIZED_NAME);
		DollAngry = new ItemDollAngry();
		GameRegistry.registerItem(DollAngry, ItemData.ANGRY_DOLL_UNLOCALIZED_NAME);
		DollCreepy = new ItemDollCreepy();
		GameRegistry.registerItem(DollCreepy, ItemData.CREEPY_DOLL_UNLOCALIZED_NAME);

		SilkwormCooked = new ItemSilkwormCooked();
		GameRegistry.registerItem(SilkwormCooked, ItemData.SILKWORM_COOKED_UNLOCALIZED_NAME);

		SeedsOak = new ItemSeedOak();
		GameRegistry.registerItem(SeedsOak, ItemData.SEED_OAK_UNLOCALIZED_NAME);
		SeedsAcacia = new ItemSeedAcacia();
		GameRegistry.registerItem(SeedsAcacia, ItemData.SEED_ACACIA_UNLOCALIZED_NAME);
		SeedsSpruce = new ItemSeedSpruce();
		GameRegistry.registerItem(SeedsSpruce, ItemData.SEED_SPRUCE_UNLOCALIZED_NAME);
		SeedsBirch = new ItemSeedBirch();
		GameRegistry.registerItem(SeedsBirch, ItemData.SEED_BIRCH_UNLOCALIZED_NAME);
		SeedsJungle = new ItemSeedJungle();
		GameRegistry.registerItem(SeedsJungle, ItemData.SEED_JUNGLE_UNLOCALIZED_NAME);
		SeedsCactus = new ItemSeedCactus();
		GameRegistry.registerItem(SeedsCactus, ItemData.SEED_CACTUS_UNLOCALIZED_NAME);
		SeedsSugarcane = new ItemSeedSugarcane();
		GameRegistry.registerItem(SeedsSugarcane, ItemData.SEED_SUGAR_CANE_UNLOCALIZED_NAME);
		SeedsCarrot = new ItemSeedCarrot();
		GameRegistry.registerItem(SeedsCarrot, ItemData.SEED_CARROT_UNLOCALIZED_NAME);
		SeedsPotato = new ItemSeedPotato();
		GameRegistry.registerItem(SeedsPotato, ItemData.SEED_POTATO_UNLOCALIZED_NAME);

		SeedsRubber = new ItemSeedRubber();
		GameRegistry.registerItem(SeedsRubber, ItemData.SEED_RUBBER_UNLOCALIZED_NAME);
	}
}