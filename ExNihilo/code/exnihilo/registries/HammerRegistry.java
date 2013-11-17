package exnihilo.registries;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.Configuration;
import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.registries.helpers.Smashable;

public class HammerRegistry {
public static ArrayList<Smashable> rewards = new ArrayList<Smashable>();
	
	public static void register(int sourceID, int sourceMeta, int outputID, int outputMeta, float chance, float luckMultiplier)
	{
		Smashable entry = new Smashable(sourceID, sourceMeta, outputID, outputMeta, chance, luckMultiplier);
		rewards.add(entry);
	}
	
	public static ArrayList<Smashable> getRewards(int id, int meta)
	{
		ArrayList<Smashable> rewardList = new ArrayList();

		Iterator<Smashable> it = rewards.iterator();
		while(it.hasNext())
		{
			Smashable reward = it.next();

			if (reward.sourceID == id && reward.sourceMeta == meta)
			{
				rewardList.add(reward);
			}
		}
		
		return rewardList;
	}
	
	public static Block[] getBlocks()
	{
		ArrayList<Block> blocks = new ArrayList();

		Iterator<Smashable> it = rewards.iterator();
		while(it.hasNext())
		{
			Smashable reward = it.next();

			if (!blocks.contains(Block.blocksList[reward.sourceID]))
			{
				blocks.add(Block.blocksList[reward.sourceID]);
			}
		}
		
		return blocks.toArray(new Block[blocks.size()]);
	}
	
	public static void load(Configuration config)
	{
		//TODO: Load all the vanilla smashables!
	}
	
	public static void registerSmashables()
	{		
		register(Block.stone.blockID, 0, Items.Stones.itemID, 0, 1.00f, 0.0f);
		register(Block.stone.blockID, 0, Items.Stones.itemID, 0, 0.75f, 0.1f);
		register(Block.stone.blockID, 0, Items.Stones.itemID, 0, 0.50f, 0.1f);
		register(Block.stone.blockID, 0, Items.Stones.itemID, 0, 0.25f, 0.1f);
		register(Block.stone.blockID, 0, Items.Stones.itemID, 0, 0.05f, 0.1f);
		
		register(Block.cobblestone.blockID, 0, Block.gravel.blockID, 0, 1.0f, 0.0f);
		register(Block.gravel.blockID, 0, Block.sand.blockID, 0, 1.0f, 0.0f);
		register(Block.sand.blockID, 0, Blocks.Dust.blockID, 0, 1.0f, 0.0f);
		
		register(Block.sandStone.blockID, 0, Block.sand.blockID, 0, 1.0f, 0.0f);
		register(Block.sandStone.blockID, 1, Block.sand.blockID, 0, 1.0f, 0.0f);
		register(Block.sandStone.blockID, 2, Block.sand.blockID, 0, 1.0f, 0.0f);
		
		
		registerIronOres();
		registerGoldOres();
		registerCopperOres();
		registerTinOres();
		registerSilverOres();
		registerLeadOres();
	}
	
	
	public static void registerOre(int oreID, int oreMeta, int rewardID, int rewardMeta)
	{
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 0.5f, 0.1f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 0.05f, 0.1f);
		HammerRegistry.register(oreID, oreMeta, rewardID, rewardMeta, 0.0f, 0.05f);
	}
	
	private static void registerIronOres()
	{
		register(Block.oreIron.blockID, 0, Items.IronGravel.itemID, 0, 1.0f, 0.0f);
		register(Block.oreIron.blockID, 0, Items.IronGravel.itemID, 0, 1.0f, 0.0f);
		register(Block.oreIron.blockID, 0, Items.IronGravel.itemID, 0, 1.0f, 0.0f);
		register(Block.oreIron.blockID, 0, Items.IronGravel.itemID, 0, 1.0f, 0.0f);
		register(Block.oreIron.blockID, 0, Items.IronGravel.itemID, 0, 0.5f, 0.1f);
		register(Block.oreIron.blockID, 0, Items.IronGravel.itemID, 0, 0.05f, 0.1f);
		register(Block.oreIron.blockID, 0, Items.IronGravel.itemID, 0, 0.0f, 0.05f);
		
		register(Blocks.IronOre.blockID, 0, Items.IronSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.IronOre.blockID, 0, Items.IronSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.IronOre.blockID, 0, Items.IronSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.IronOre.blockID, 0, Items.IronSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.IronOre.blockID, 0, Items.IronSand.itemID, 0, 0.5f, 0.1f);
		register(Blocks.IronOre.blockID, 0, Items.IronSand.itemID, 0, 0.05f, 0.1f);
		register(Blocks.IronOre.blockID, 0, Items.IronSand.itemID, 0, 0.0f, 0.05f);
		
		register(Blocks.IronOre.blockID, 1, Items.IronDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.IronOre.blockID, 1, Items.IronDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.IronOre.blockID, 1, Items.IronDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.IronOre.blockID, 1, Items.IronDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.IronOre.blockID, 1, Items.IronDust.itemID, 0, 0.5f, 0.1f);
		register(Blocks.IronOre.blockID, 1, Items.IronDust.itemID, 0, 0.05f, 0.1f);
		register(Blocks.IronOre.blockID, 1, Items.IronDust.itemID, 0, 0.0f, 0.05f);
	}
	
	private static void registerGoldOres()
	{
		register(Block.oreGold.blockID, 0, Items.GoldGravel.itemID, 0, 1.0f, 0.0f);
		register(Block.oreGold.blockID, 0, Items.GoldGravel.itemID, 0, 1.0f, 0.0f);
		register(Block.oreGold.blockID, 0, Items.GoldGravel.itemID, 0, 1.0f, 0.0f);
		register(Block.oreGold.blockID, 0, Items.GoldGravel.itemID, 0, 1.0f, 0.0f);
		register(Block.oreGold.blockID, 0, Items.GoldGravel.itemID, 0, 0.5f, 0.1f);
		register(Block.oreGold.blockID, 0, Items.GoldGravel.itemID, 0, 0.05f, 0.1f);
		register(Block.oreGold.blockID, 0, Items.GoldGravel.itemID, 0, 0.0f, 0.05f);
		
		register(Blocks.GoldOre.blockID, 0, Items.GoldSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.GoldOre.blockID, 0, Items.GoldSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.GoldOre.blockID, 0, Items.GoldSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.GoldOre.blockID, 0, Items.GoldSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.GoldOre.blockID, 0, Items.GoldSand.itemID, 0, 0.5f, 0.1f);
		register(Blocks.GoldOre.blockID, 0, Items.GoldSand.itemID, 0, 0.05f, 0.1f);
		register(Blocks.GoldOre.blockID, 0, Items.GoldSand.itemID, 0, 0.0f, 0.05f);
		
		register(Blocks.GoldOre.blockID, 1, Items.GoldDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.GoldOre.blockID, 1, Items.GoldDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.GoldOre.blockID, 1, Items.GoldDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.GoldOre.blockID, 1, Items.GoldDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.GoldOre.blockID, 1, Items.GoldDust.itemID, 0, 0.5f, 0.1f);
		register(Blocks.GoldOre.blockID, 1, Items.GoldDust.itemID, 0, 0.05f, 0.1f);
		register(Blocks.GoldOre.blockID, 1, Items.GoldDust.itemID, 0, 0.0f, 0.05f);
	}
	
	private static void registerCopperOres()
	{
		register(Blocks.CopperOre.blockID, 0, Items.CopperSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.CopperOre.blockID, 0, Items.CopperSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.CopperOre.blockID, 0, Items.CopperSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.CopperOre.blockID, 0, Items.CopperSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.CopperOre.blockID, 0, Items.CopperSand.itemID, 0, 0.5f, 0.1f);
		register(Blocks.CopperOre.blockID, 0, Items.CopperSand.itemID, 0, 0.05f, 0.1f);
		register(Blocks.CopperOre.blockID, 0, Items.CopperSand.itemID, 0, 0.0f, 0.05f);
		
		register(Blocks.CopperOre.blockID, 1, Items.CopperDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.CopperOre.blockID, 1, Items.CopperDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.CopperOre.blockID, 1, Items.CopperDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.CopperOre.blockID, 1, Items.CopperDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.CopperOre.blockID, 1, Items.CopperDust.itemID, 0, 0.5f, 0.1f);
		register(Blocks.CopperOre.blockID, 1, Items.CopperDust.itemID, 0, 0.05f, 0.1f);
		register(Blocks.CopperOre.blockID, 1, Items.CopperDust.itemID, 0, 0.0f, 0.05f);
	}
	
	private static void registerTinOres()
	{
		register(Blocks.TinOre.blockID, 0, Items.TinSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.TinOre.blockID, 0, Items.TinSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.TinOre.blockID, 0, Items.TinSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.TinOre.blockID, 0, Items.TinSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.TinOre.blockID, 0, Items.TinSand.itemID, 0, 0.5f, 0.1f);
		register(Blocks.TinOre.blockID, 0, Items.TinSand.itemID, 0, 0.05f, 0.1f);
		register(Blocks.TinOre.blockID, 0, Items.TinSand.itemID, 0, 0.0f, 0.05f);
		
		register(Blocks.TinOre.blockID, 1, Items.TinDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.TinOre.blockID, 1, Items.TinDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.TinOre.blockID, 1, Items.TinDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.TinOre.blockID, 1, Items.TinDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.TinOre.blockID, 1, Items.TinDust.itemID, 0, 0.5f, 0.1f);
		register(Blocks.TinOre.blockID, 1, Items.TinDust.itemID, 0, 0.05f, 0.1f);
		register(Blocks.TinOre.blockID, 1, Items.TinDust.itemID, 0, 0.0f, 0.05f);
	}
	
	private static void registerSilverOres()
	{
		register(Blocks.SilverOre.blockID, 0, Items.SilverSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.SilverOre.blockID, 0, Items.SilverSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.SilverOre.blockID, 0, Items.SilverSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.SilverOre.blockID, 0, Items.SilverSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.SilverOre.blockID, 0, Items.SilverSand.itemID, 0, 0.5f, 0.1f);
		register(Blocks.SilverOre.blockID, 0, Items.SilverSand.itemID, 0, 0.05f, 0.1f);
		register(Blocks.SilverOre.blockID, 0, Items.SilverSand.itemID, 0, 0.0f, 0.05f);
		
		register(Blocks.SilverOre.blockID, 1, Items.SilverDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.SilverOre.blockID, 1, Items.SilverDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.SilverOre.blockID, 1, Items.SilverDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.SilverOre.blockID, 1, Items.SilverDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.SilverOre.blockID, 1, Items.SilverDust.itemID, 0, 0.5f, 0.1f);
		register(Blocks.SilverOre.blockID, 1, Items.SilverDust.itemID, 0, 0.05f, 0.1f);
		register(Blocks.SilverOre.blockID, 1, Items.SilverDust.itemID, 0, 0.0f, 0.05f);
	}
	
	private static void registerLeadOres()
	{
		register(Blocks.LeadOre.blockID, 0, Items.LeadSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.LeadOre.blockID, 0, Items.LeadSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.LeadOre.blockID, 0, Items.LeadSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.LeadOre.blockID, 0, Items.LeadSand.itemID, 0, 1.0f, 0.0f);
		register(Blocks.LeadOre.blockID, 0, Items.LeadSand.itemID, 0, 0.5f, 0.1f);
		register(Blocks.LeadOre.blockID, 0, Items.LeadSand.itemID, 0, 0.05f, 0.1f);
		register(Blocks.LeadOre.blockID, 0, Items.LeadSand.itemID, 0, 0.0f, 0.05f);
		
		register(Blocks.LeadOre.blockID, 1, Items.LeadDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.LeadOre.blockID, 1, Items.LeadDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.LeadOre.blockID, 1, Items.LeadDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.LeadOre.blockID, 1, Items.LeadDust.itemID, 0, 1.0f, 0.0f);
		register(Blocks.LeadOre.blockID, 1, Items.LeadDust.itemID, 0, 0.5f, 0.1f);
		register(Blocks.LeadOre.blockID, 1, Items.LeadDust.itemID, 0, 0.05f, 0.1f);
		register(Blocks.LeadOre.blockID, 1, Items.LeadDust.itemID, 0, 0.0f, 0.05f);
	}
}
