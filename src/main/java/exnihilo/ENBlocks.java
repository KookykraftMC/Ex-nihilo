package exnihilo;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.blocks.BlockBarrel;
import exnihilo.blocks.BlockBarrelStone;
import exnihilo.blocks.BlockBeeTrap;
import exnihilo.blocks.BlockBeeTrapTreated;
import exnihilo.blocks.BlockCrucible;
import exnihilo.blocks.BlockCrucibleUnfired;
import exnihilo.blocks.BlockDust;
import exnihilo.blocks.BlockLeavesInfested;
import exnihilo.blocks.BlockSieve;
import exnihilo.blocks.itemBlocks.ItemBlockBarrel;
import exnihilo.blocks.itemBlocks.ItemBlockBarrelStone;
import exnihilo.blocks.itemBlocks.ItemBlockCrucible;
import exnihilo.blocks.itemBlocks.ItemBlockCrucibleUnfired;
import exnihilo.blocks.itemBlocks.ItemBlockLeavesInfested;
import exnihilo.blocks.itemBlocks.ItemBlockSieve;
import exnihilo.blocks.ores.BlockAluminumOre;
import exnihilo.blocks.ores.BlockCopperOre;
import exnihilo.blocks.ores.BlockGoldOre;
import exnihilo.blocks.ores.BlockIronOre;
import exnihilo.blocks.ores.BlockLeadOre;
import exnihilo.blocks.ores.BlockNickelOre;
import exnihilo.blocks.ores.BlockOre;
import exnihilo.blocks.ores.BlockOreFactory;
import exnihilo.blocks.ores.BlockOsmiumOre;
import exnihilo.blocks.ores.BlockPlatinumOre;
import exnihilo.blocks.ores.BlockSilverOre;
import exnihilo.blocks.ores.BlockTinOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockAluminumOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockCopperOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockGoldOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockIronOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockLeadOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockNickelOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockOsmiumOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockPlatinumOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockSilverOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockTinOre;
import exnihilo.data.BlockData;
import exnihilo.registries.helpers.Color;

public class ENBlocks {
	public static Block Barrel;
	public static Block BarrelStone;
	public static Block Crucible;
	public static Block CrucibleUnfired;
	public static Block Dust;
	public static Block LeavesInfested;
	public static Block Sieve;
	public static Block BeeTrap;
	public static Block BeeTrapTreated;

	public static Block IronOre;
	public static Block GoldOre;
	//public static Block CopperOre;
	public static Block TinOre;
	public static Block SilverOre;
	public static Block LeadOre;
	public static Block OsmiumOre;
	public static Block NickelOre;
	public static Block PlatinumOre;
	public static Block AluminumOre;

	public static void registerBlocks()
	{
	  //Testing Ore Generation;
	  //CreateOreBlocks("Testium", new Color("3423CC"));
	  //CreateOreBlocks("Reversium", new Color("FFB940"));
	  //CreateOreBlocks("Teslasium", new Color("40FF66"));
	  //CreateOreBlocks("Redrium", new Color("FF5050"));
	  //CreateOreBlocks("Pinkium", new Color("FF9999"));
	  
		Barrel = new BlockBarrel();
		GameRegistry.registerBlock(Barrel, ItemBlockBarrel.class, BlockData.BARREL_KEY);

		BarrelStone = new BlockBarrelStone();
		GameRegistry.registerBlock(BarrelStone, ItemBlockBarrelStone.class, BlockData.BARREL_STONE_KEY);

		Crucible = new BlockCrucible();
		GameRegistry.registerBlock(Crucible, ItemBlockCrucible.class, BlockData.CRUCIBLE_KEY);

		CrucibleUnfired = new BlockCrucibleUnfired();
		GameRegistry.registerBlock(CrucibleUnfired, ItemBlockCrucibleUnfired.class, BlockData.CRUCIBLE_UNFIRED_KEY);

		Dust = new BlockDust();
		GameRegistry.registerBlock(Dust, BlockData.DUST_KEY);

		LeavesInfested = new BlockLeavesInfested();
		GameRegistry.registerBlock(LeavesInfested, ItemBlockLeavesInfested.class, BlockData.LEAVES_INFESTED_KEY);

		Sieve = new BlockSieve();
		GameRegistry.registerBlock(Sieve, ItemBlockSieve.class, BlockData.SIEVE_KEY);

		BeeTrap = new BlockBeeTrap();
		GameRegistry.registerBlock(BeeTrap, BlockData.BEE_TRAP_KEY);
		BeeTrapTreated = new BlockBeeTrapTreated();
		GameRegistry.registerBlock(BeeTrapTreated, BlockData.BEE_TRAP_TREATED_KEY);

		IronOre = new BlockIronOre();
		GameRegistry.registerBlock(IronOre, ItemBlockIronOre.class, BlockData.IRON_ORE_KEY);

		GoldOre = new BlockGoldOre();
		GameRegistry.registerBlock(GoldOre, ItemBlockGoldOre.class, BlockData.GOLD_ORE_KEY);

		//CopperOre = new BlockCopperOre();
		//GameRegistry.registerBlock(CopperOre, ItemBlockCopperOre.class, BlockData.COPPER_ORE_KEY);

		TinOre = new BlockTinOre();
		GameRegistry.registerBlock(TinOre, ItemBlockTinOre.class, BlockData.TIN_ORE_KEY);

		SilverOre = new BlockSilverOre();
		GameRegistry.registerBlock(SilverOre, ItemBlockSilverOre.class, BlockData.SILVER_ORE_KEY);

		LeadOre = new BlockLeadOre();
		GameRegistry.registerBlock(LeadOre, ItemBlockLeadOre.class, BlockData.LEAD_ORE_KEY);

		OsmiumOre = new BlockOsmiumOre();
		GameRegistry.registerBlock(OsmiumOre, ItemBlockOsmiumOre.class, BlockData.OSMIUM_ORE_KEY);

		NickelOre = new BlockNickelOre();
		GameRegistry.registerBlock(NickelOre, ItemBlockNickelOre.class, BlockData.NICKEL_ORE_KEY);

		PlatinumOre = new BlockPlatinumOre();
		GameRegistry.registerBlock(PlatinumOre, ItemBlockPlatinumOre.class, BlockData.PLATINUM_ORE_KEY);

		AluminumOre = new BlockAluminumOre();
		GameRegistry.registerBlock(AluminumOre, ItemBlockAluminumOre.class, BlockData.ALUMINUM_ORE_KEY);
	}
	
	public static void CreateOreBlocks(String name, Color color)
	{
	//TODO Create a key,value pair registry that maps ore names to blocks;
    BlockOre[] TestOre = BlockOreFactory.MakeOverworldOres(name, color);
    
    for (BlockOre b : TestOre)
    {
      //TODO Don't create the same ore block twice!
      GameRegistry.registerBlock(b, b.getName());
    }
	}
}
