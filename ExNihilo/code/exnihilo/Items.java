package exnihilo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import exnihilo.blocks.BlockBarrel;
import exnihilo.blocks.itemBlocks.ItemBlockBarrel;
import exnihilo.data.ItemData;
import exnihilo.items.ItemCrook;
import exnihilo.items.ItemGrassSeeds;
import exnihilo.items.ItemMesh;
import exnihilo.items.ItemPorcelainBall;
import exnihilo.items.ItemSilkworm;
import exnihilo.items.ItemSilkwormCooked;
import exnihilo.items.ItemSpores;
import exnihilo.items.ItemStone;
import exnihilo.items.hammers.ItemHammerBase;
import exnihilo.items.hammers.ItemHammerDiamond;
import exnihilo.items.hammers.ItemHammerGold;
import exnihilo.items.hammers.ItemHammerIron;
import exnihilo.items.hammers.ItemHammerStone;
import exnihilo.items.hammers.ItemHammerWood;
import exnihilo.items.ores.ItemCopperDust;
import exnihilo.items.ores.ItemCopperGravel;
import exnihilo.items.ores.ItemCopperIngot;
import exnihilo.items.ores.ItemCopperSand;
import exnihilo.items.ores.ItemGoldDust;
import exnihilo.items.ores.ItemGoldGravel;
import exnihilo.items.ores.ItemGoldSand;
import exnihilo.items.ores.ItemIronDust;
import exnihilo.items.ores.ItemIronGravel;
import exnihilo.items.ores.ItemIronSand;
import exnihilo.items.ores.ItemLeadDust;
import exnihilo.items.ores.ItemLeadGravel;
import exnihilo.items.ores.ItemLeadIngot;
import exnihilo.items.ores.ItemLeadSand;
import exnihilo.items.ores.ItemOsmiumDust;
import exnihilo.items.ores.ItemOsmiumGravel;
import exnihilo.items.ores.ItemOsmiumSand;
import exnihilo.items.ores.ItemSilverDust;
import exnihilo.items.ores.ItemSilverGravel;
import exnihilo.items.ores.ItemSilverIngot;
import exnihilo.items.ores.ItemSilverSand;
import exnihilo.items.ores.ItemTinDust;
import exnihilo.items.ores.ItemTinGravel;
import exnihilo.items.ores.ItemTinIngot;
import exnihilo.items.ores.ItemTinSand;
import exnihilo.items.seeds.ItemSeedBirch;
import exnihilo.items.seeds.ItemSeedCactus;
import exnihilo.items.seeds.ItemSeedCarrot;
import exnihilo.items.seeds.ItemSeedJungle;
import exnihilo.items.seeds.ItemSeedOak;
import exnihilo.items.seeds.ItemSeedPotato;
import exnihilo.items.seeds.ItemSeedRubber;
import exnihilo.items.seeds.ItemSeedSpruce;
import exnihilo.items.seeds.ItemSeedSugarcane;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class Items {
	public static Item HammerWood;
	public static Item HammerStone;
	public static Item HammerIron;
	public static Item HammerGold;
	public static Item HammerDiamond;
	public static Item Crook;
	public static Item Silkworm;
	public static Item SilkwormCooked;
	public static Item Mesh;
	public static Item Stones;
	public static Item Porcelain;

	//Seeds
	public static Item Spores;
	public static Item GrassSeeds;
	public static Item SeedsOak;
	public static Item SeedsSpruce;
	public static Item SeedsBirch;
	public static Item SeedsJungle;
	public static Item SeedsCactus;
	public static Item SeedsSugarcane;
	public static Item SeedsCarrot;
	public static Item SeedsPotato;
	
	public static Item SeedsRubber;

	//Iron Ore
	public static Item IronGravel;
	public static Item IronSand;
	public static Item IronDust;

	//Gold Ore
	public static Item GoldGravel;
	public static Item GoldSand;
	public static Item GoldDust;

	//Copper Ore
	public static Item CopperGravel;
	public static Item CopperSand;
	public static Item CopperDust;
	public static Item CopperIngot;

	//Tin Ore
	public static Item TinGravel;
	public static Item TinSand;
	public static Item TinDust;
	public static Item TinIngot;

	//Silver Ore
	public static Item SilverGravel;
	public static Item SilverSand;
	public static Item SilverDust;
	public static Item SilverIngot;

	//Lead Ore
	public static Item LeadGravel;
	public static Item LeadSand;
	public static Item LeadDust;
	public static Item LeadIngot;
	
	//Osmium Ore
	public static Item OsmiumGravel;
	public static Item OsmiumSand;
	public static Item OsmiumDust;

	public static void registerItems()
	{
		HammerWood = new ItemHammerWood(ItemData.HAMMER_IDS[0]);
		GameRegistry.registerItem(HammerWood, ItemData.HAMMER_UNLOCALIZED_NAMES[0]);

		HammerStone = new ItemHammerStone(ItemData.HAMMER_IDS[1]);
		GameRegistry.registerItem(HammerWood, ItemData.HAMMER_UNLOCALIZED_NAMES[1]);

		HammerIron = new ItemHammerIron(ItemData.HAMMER_IDS[2]);
		GameRegistry.registerItem(HammerIron, ItemData.HAMMER_UNLOCALIZED_NAMES[2]);

		HammerGold = new ItemHammerGold(ItemData.HAMMER_IDS[3]);
		GameRegistry.registerItem(HammerGold, ItemData.HAMMER_UNLOCALIZED_NAMES[3]);

		HammerDiamond = new ItemHammerDiamond(ItemData.HAMMER_IDS[4]);
		GameRegistry.registerItem(HammerDiamond, ItemData.HAMMER_UNLOCALIZED_NAMES[4]);

		Crook = new ItemCrook(ItemData.CROOK_ID);
		GameRegistry.registerItem(Crook, ItemData.CROOK_UNLOCALIZED_NAME);

		Silkworm = new ItemSilkworm(ItemData.SILKWORM_ID);
		GameRegistry.registerItem(Silkworm, ItemData.SILKWORM_UNLOCALIZED_NAME);

		Mesh = new ItemMesh(ItemData.MESH_ID);
		GameRegistry.registerItem(Mesh, ItemData.MESH_UNLOCALIZED_NAME);

		Spores = new ItemSpores(ItemData.SPORES_ID);
		GameRegistry.registerItem(Spores, ItemData.SPORES_UNLOCALIZED_NAME);

		GrassSeeds = new ItemGrassSeeds(ItemData.SEED_GRASS_ID);
		GameRegistry.registerItem(GrassSeeds, ItemData.SEED_GRASS_UNLOCALIZED_NAME);

		Stones = new ItemStone(ItemData.STONES_ID);
		GameRegistry.registerItem(Stones, ItemData.STONES_UNLOCALIZED_NAME);

		Porcelain = new ItemPorcelainBall(ItemData.PORCELAIN_ID);
		GameRegistry.registerItem(Porcelain, ItemData.PORCELAIN_UNLOCALIZED_NAME);

		SilkwormCooked = new ItemSilkwormCooked(ItemData.SILKWORM_COOKED_ID);
		GameRegistry.registerItem(SilkwormCooked, ItemData.SILKWORM_COOKED_UNLOCALIZED_NAME);

		SeedsOak = new ItemSeedOak(ItemData.SEED_OAK_ID);
		GameRegistry.registerItem(SeedsOak, ItemData.SEED_OAK_UNLOCALIZED_NAME);
		SeedsSpruce = new ItemSeedSpruce(ItemData.SEED_SPRUCE_ID);
		GameRegistry.registerItem(SeedsSpruce, ItemData.SEED_SPRUCE_UNLOCALIZED_NAME);
		SeedsBirch = new ItemSeedBirch(ItemData.SEED_BIRCH_ID);
		GameRegistry.registerItem(SeedsBirch, ItemData.SEED_BIRCH_UNLOCALIZED_NAME);
		SeedsJungle = new ItemSeedJungle(ItemData.SEED_JUNGLE_ID);
		GameRegistry.registerItem(SeedsJungle, ItemData.SEED_JUNGLE_UNLOCALIZED_NAME);
		SeedsCactus = new ItemSeedCactus(ItemData.SEED_CACTUS_ID);
		GameRegistry.registerItem(SeedsCactus, ItemData.SEED_CACTUS_UNLOCALIZED_NAME);
		SeedsSugarcane = new ItemSeedSugarcane(ItemData.SEED_SUGAR_CANE_ID);
		GameRegistry.registerItem(SeedsSugarcane, ItemData.SEED_SUGAR_CANE_UNLOCALIZED_NAME);
		SeedsCarrot = new ItemSeedCarrot(ItemData.SEED_CARROT_ID);
		GameRegistry.registerItem(SeedsCarrot, ItemData.SEED_CARROT_UNLOCALIZED_NAME);
		SeedsPotato = new ItemSeedPotato(ItemData.SEED_POTATO_ID);
		GameRegistry.registerItem(SeedsPotato, ItemData.SEED_POTATO_UNLOCALIZED_NAME);

		SeedsRubber = new ItemSeedRubber(ItemData.SEED_RUBBER_ID);
		GameRegistry.registerItem(SeedsRubber, ItemData.SEED_RUBBER_UNLOCALIZED_NAME);
		
		//Iron Ore
		IronGravel = new ItemIronGravel(ItemData.IRON_ORE_IDS[0]);
		GameRegistry.registerItem(IronGravel, ItemData.IRON_ORE_UNLOCALIZED_NAMES[0]);
		IronSand = new ItemIronSand(ItemData.IRON_ORE_IDS[1]);
		GameRegistry.registerItem(IronSand, ItemData.IRON_ORE_UNLOCALIZED_NAMES[1]);
		IronDust = new ItemIronDust(ItemData.IRON_ORE_IDS[2]);
		GameRegistry.registerItem(IronDust, ItemData.IRON_ORE_UNLOCALIZED_NAMES[2]);

		//Gold Ore
		GoldGravel = new ItemGoldGravel(ItemData.GOLD_ORE_IDS[0]);
		GameRegistry.registerItem(GoldGravel, ItemData.GOLD_ORE_UNLOCALIZED_NAMES[0]);
		GoldSand = new ItemGoldSand(ItemData.GOLD_ORE_IDS[1]);
		GameRegistry.registerItem(GoldSand, ItemData.GOLD_ORE_UNLOCALIZED_NAMES[1]);
		GoldDust = new ItemGoldDust(ItemData.GOLD_ORE_IDS[2]);
		GameRegistry.registerItem(GoldDust, ItemData.GOLD_ORE_UNLOCALIZED_NAMES[2]);

		//Copper Ore
		CopperGravel = new ItemCopperGravel(ItemData.COPPER_ORE_IDS[0]);
		GameRegistry.registerItem(CopperGravel, ItemData.COPPER_ORE_UNLOCALIZED_NAMES[0]);
		CopperSand = new ItemCopperSand(ItemData.COPPER_ORE_IDS[1]);
		GameRegistry.registerItem(CopperSand, ItemData.COPPER_ORE_UNLOCALIZED_NAMES[1]);
		CopperDust = new ItemCopperDust(ItemData.COPPER_ORE_IDS[2]);
		GameRegistry.registerItem(CopperDust, ItemData.COPPER_ORE_UNLOCALIZED_NAMES[2]);
		CopperIngot = new ItemCopperIngot(ItemData.COPPER_INGOT_ID);
		GameRegistry.registerItem(CopperIngot, ItemData.COPPER_ORE_UNLOCALIZED_NAMES[3]);
		
		//Tin Ore
		TinGravel = new ItemTinGravel(ItemData.TIN_ORE_IDS[0]);
		GameRegistry.registerItem(TinGravel, ItemData.TIN_ORE_UNLOCALIZED_NAMES[0]);
		TinSand = new ItemTinSand(ItemData.TIN_ORE_IDS[1]);
		GameRegistry.registerItem(TinSand, ItemData.TIN_ORE_UNLOCALIZED_NAMES[1]);
		TinDust = new ItemTinDust(ItemData.TIN_ORE_IDS[2]);
		GameRegistry.registerItem(TinDust, ItemData.TIN_ORE_UNLOCALIZED_NAMES[2]);
		TinIngot = new ItemTinIngot(ItemData.TIN_INGOT_ID);
		GameRegistry.registerItem(TinIngot, ItemData.TIN_ORE_UNLOCALIZED_NAMES[3]);
		
		//Silver Ore
		SilverGravel = new ItemSilverGravel(ItemData.SILVER_ORE_IDS[0]);
		GameRegistry.registerItem(SilverGravel, ItemData.SILVER_ORE_UNLOCALIZED_NAMES[0]);
		SilverSand = new ItemSilverSand(ItemData.SILVER_ORE_IDS[1]);
		GameRegistry.registerItem(SilverSand, ItemData.SILVER_ORE_UNLOCALIZED_NAMES[1]);
		SilverDust = new ItemSilverDust(ItemData.SILVER_ORE_IDS[2]);
		GameRegistry.registerItem(SilverDust, ItemData.SILVER_ORE_UNLOCALIZED_NAMES[2]);
		SilverIngot = new ItemSilverIngot(ItemData.SILVER_INGOT_ID);
		GameRegistry.registerItem(SilverIngot, ItemData.SILVER_ORE_UNLOCALIZED_NAMES[3]);
		
		//Lead Ore
		LeadGravel = new ItemLeadGravel(ItemData.LEAD_ORE_IDS[0]);
		GameRegistry.registerItem(LeadGravel, ItemData.LEAD_ORE_UNLOCALIZED_NAMES[0]);
		LeadSand = new ItemLeadSand(ItemData.LEAD_ORE_IDS[1]);
		GameRegistry.registerItem(LeadSand, ItemData.LEAD_ORE_UNLOCALIZED_NAMES[1]);
		LeadDust = new ItemLeadDust(ItemData.LEAD_ORE_IDS[2]);
		GameRegistry.registerItem(LeadDust, ItemData.LEAD_ORE_UNLOCALIZED_NAMES[2]);
		LeadIngot = new ItemLeadIngot(ItemData.LEAD_INGOT_ID);
		GameRegistry.registerItem(LeadIngot, ItemData.LEAD_ORE_UNLOCALIZED_NAMES[3]);
		
		//Osmium Ore
		OsmiumGravel = new ItemOsmiumGravel(ItemData.OSMIUM_ORE_IDS[0]);
		GameRegistry.registerItem(OsmiumGravel, ItemData.OSMIUM_ORE_UNLOCALIZED_NAMES[0]);
		OsmiumSand = new ItemOsmiumSand(ItemData.OSMIUM_ORE_IDS[1]);
		GameRegistry.registerItem(OsmiumSand, ItemData.OSMIUM_ORE_UNLOCALIZED_NAMES[1]);
		OsmiumDust = new ItemOsmiumDust(ItemData.OSMIUM_ORE_IDS[2]);
		GameRegistry.registerItem(OsmiumDust, ItemData.OSMIUM_ORE_UNLOCALIZED_NAMES[2]);
	}

	public static void registerNames()
	{
		//Hammers!
		LanguageRegistry.addName(HammerWood, ItemData.HAMMER_NAMES[0]);
		LanguageRegistry.addName(HammerStone, ItemData.HAMMER_NAMES[1]);
		LanguageRegistry.addName(HammerIron, ItemData.HAMMER_NAMES[2]);
		LanguageRegistry.addName(HammerGold, ItemData.HAMMER_NAMES[3]);
		LanguageRegistry.addName(HammerDiamond, ItemData.HAMMER_NAMES[4]);

		LanguageRegistry.addName(Silkworm, ItemData.SILKWORM_NAME);
		LanguageRegistry.addName(SilkwormCooked, ItemData.SILKWORM_COOKED_NAME);
		LanguageRegistry.addName(Crook, ItemData.CROOK_NAME);
		LanguageRegistry.addName(Mesh, ItemData.MESH_NAME);
		LanguageRegistry.addName(Spores, ItemData.SPORES_NAME);
		LanguageRegistry.addName(GrassSeeds, ItemData.SEED_GRASS_NAME);
		LanguageRegistry.addName(Stones, ItemData.STONES_NAME);
		LanguageRegistry.addName(Porcelain, ItemData.PORCELAIN_NAME);

		LanguageRegistry.addName(SeedsOak, ItemData.SEED_OAK_NAME);
		LanguageRegistry.addName(SeedsSpruce, ItemData.SEED_SPRUCE_NAME);
		LanguageRegistry.addName(SeedsBirch, ItemData.SEED_BIRCH_NAME);
		LanguageRegistry.addName(SeedsJungle, ItemData.SEED_JUNGLE_NAME);

		LanguageRegistry.addName(SeedsCactus, ItemData.SEED_CACTUS_NAME);
		LanguageRegistry.addName(SeedsSugarcane, ItemData.SEED_SUGAR_CANE_NAME);

		LanguageRegistry.addName(SeedsCarrot, ItemData.SEED_CARROT_NAME);
		LanguageRegistry.addName(SeedsPotato, ItemData.SEED_POTATO_NAME);
		
		LanguageRegistry.addName(SeedsRubber, ItemData.SEED_RUBBER_NAME);

		LanguageRegistry.addName(IronGravel, ItemData.IRON_ORE_NAMES[0]);
		LanguageRegistry.addName(IronSand, ItemData.IRON_ORE_NAMES[1]);
		LanguageRegistry.addName(IronDust, ItemData.IRON_ORE_NAMES[2]);

		LanguageRegistry.addName(GoldGravel, ItemData.GOLD_ORE_NAMES[0]);
		LanguageRegistry.addName(GoldSand, ItemData.GOLD_ORE_NAMES[1]);
		LanguageRegistry.addName(GoldDust, ItemData.GOLD_ORE_NAMES[2]);
		
		LanguageRegistry.addName(CopperGravel, ItemData.COPPER_ORE_NAMES[0]);
		LanguageRegistry.addName(CopperSand, ItemData.COPPER_ORE_NAMES[1]);
		LanguageRegistry.addName(CopperDust, ItemData.COPPER_ORE_NAMES[2]);
		LanguageRegistry.addName(CopperIngot, ItemData.COPPER_ORE_NAMES[3]);
		
		LanguageRegistry.addName(TinGravel, ItemData.TIN_ORE_NAMES[0]);
		LanguageRegistry.addName(TinSand, ItemData.TIN_ORE_NAMES[1]);
		LanguageRegistry.addName(TinDust, ItemData.TIN_ORE_NAMES[2]);
		LanguageRegistry.addName(TinIngot, ItemData.TIN_ORE_NAMES[3]);
		
		LanguageRegistry.addName(SilverGravel, ItemData.SILVER_ORE_NAMES[0]);
		LanguageRegistry.addName(SilverSand, ItemData.SILVER_ORE_NAMES[1]);
		LanguageRegistry.addName(SilverDust, ItemData.SILVER_ORE_NAMES[2]);
		LanguageRegistry.addName(SilverIngot, ItemData.SILVER_ORE_NAMES[3]);
		
		LanguageRegistry.addName(LeadGravel, ItemData.LEAD_ORE_NAMES[0]);
		LanguageRegistry.addName(LeadSand, ItemData.LEAD_ORE_NAMES[1]);
		LanguageRegistry.addName(LeadDust, ItemData.LEAD_ORE_NAMES[2]);
		LanguageRegistry.addName(LeadIngot, ItemData.LEAD_ORE_NAMES[3]);
		
		LanguageRegistry.addName(OsmiumGravel, ItemData.OSMIUM_ORE_NAMES[0]);
		LanguageRegistry.addName(OsmiumSand, ItemData.OSMIUM_ORE_NAMES[1]);
		LanguageRegistry.addName(OsmiumDust, ItemData.OSMIUM_ORE_NAMES[2]);
	}
}