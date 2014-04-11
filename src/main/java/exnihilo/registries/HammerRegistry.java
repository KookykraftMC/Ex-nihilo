package exnihilo.registries;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.registries.helpers.Smashable;

public class HammerRegistry {
public static ArrayList<Smashable> rewards = new ArrayList<Smashable>();
	
	public static void register(int sourceID, int sourceMeta, int outputID, int outputMeta, float chance, float luckMultiplier)
	{
		Smashable entry = new Smashable(sourceID, sourceMeta, outputID, outputMeta, chance, luckMultiplier);
		rewards.add(entry);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Smashable> getRewards(int id, int meta)
	{
		ArrayList<Smashable> rewardList = new ArrayList();

		Iterator<Smashable> it = rewards.iterator();
		while(it.hasNext())
		{
			Smashable reward = it.next();

			if (reward.sourceID == id && reward.sourceMeta == meta && reward.id != 0)
			{
				rewardList.add(reward);
			}
		}
		
		return rewardList;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Block[] getBlocks()
	{
		ArrayList<Block> blocks = new ArrayList();

		Iterator<Smashable> it = rewards.iterator();
		while(it.hasNext())
		{
			Smashable reward = it.next();

			if (!blocks.contains(Block.blockRegistry.getObjectById(reward.sourceID)))
			{
				blocks.add((Block)Block.blockRegistry.getObjectById(reward.sourceID));
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
		register(Block.getIdFromBlock(Blocks.stone), 0, Item.getIdFromItem(ENItems.Stones), 0, 1.00f, 0.0f);
		register(Block.getIdFromBlock(Blocks.stone), 0, Item.getIdFromItem(ENItems.Stones), 0, 0.75f, 0.1f);
		register(Block.getIdFromBlock(Blocks.stone), 0, Item.getIdFromItem(ENItems.Stones), 0, 0.75f, 0.1f);
		register(Block.getIdFromBlock(Blocks.stone), 0, Item.getIdFromItem(ENItems.Stones), 0, 0.50f, 0.1f);
		register(Block.getIdFromBlock(Blocks.stone), 0, Item.getIdFromItem(ENItems.Stones), 0, 0.25f, 0.1f);
		register(Block.getIdFromBlock(Blocks.stone), 0, Item.getIdFromItem(ENItems.Stones), 0, 0.05f, 0.1f);
		
		register(Block.getIdFromBlock(Blocks.cobblestone), 0, Block.getIdFromBlock(Blocks.gravel), 0, 1.0f, 0.0f);
		register(Block.getIdFromBlock(Blocks.gravel), 0, Block.getIdFromBlock(Blocks.sand), 0, 1.0f, 0.0f);
		register(Block.getIdFromBlock(Blocks.sand), 0, Block.getIdFromBlock(ENBlocks.Dust), 0, 1.0f, 0.0f);
		
		register(Block.getIdFromBlock(Blocks.sandstone), 0, Block.getIdFromBlock(Blocks.sand), 0, 1.0f, 0.0f);
		register(Block.getIdFromBlock(Blocks.sandstone), 1, Block.getIdFromBlock(Blocks.sand), 0, 1.0f, 0.0f);
		register(Block.getIdFromBlock(Blocks.sandstone), 2, Block.getIdFromBlock(Blocks.sand), 0, 1.0f, 0.0f);
		
		register(Block.getIdFromBlock(Blocks.stonebrick), 0, Block.getIdFromBlock(Blocks.stonebrick), 2, 1.0f, 0.0f);
		
		register(Block.getIdFromBlock(Blocks.stonebrick), 2, Item.getIdFromItem(ENItems.Stones), 0, 1.00f, 0.0f);
		register(Block.getIdFromBlock(Blocks.stonebrick), 2, Item.getIdFromItem(ENItems.Stones), 0, 0.75f, 0.1f);
		register(Block.getIdFromBlock(Blocks.stonebrick), 2, Item.getIdFromItem(ENItems.Stones), 0, 0.75f, 0.1f);
		register(Block.getIdFromBlock(Blocks.stonebrick), 2, Item.getIdFromItem(ENItems.Stones), 0, 0.50f, 0.1f);
		register(Block.getIdFromBlock(Blocks.stonebrick), 2, Item.getIdFromItem(ENItems.Stones), 0, 0.25f, 0.1f);
		register(Block.getIdFromBlock(Blocks.stonebrick), 2, Item.getIdFromItem(ENItems.Stones), 0, 0.05f, 0.1f);
		
		registerIronOres();
		registerGoldOres();
		
	}
	
	
	public static void registerOre(int oreID, int oreMeta, int rewardID, int rewardMeta)
	{
		register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		register(oreID, oreMeta, rewardID, rewardMeta, 1.0f, 0.0f);
		register(oreID, oreMeta, rewardID, rewardMeta, 0.5f, 0.1f);
		register(oreID, oreMeta, rewardID, rewardMeta, 0.05f, 0.1f);
		register(oreID, oreMeta, rewardID, rewardMeta, 0.0f, 0.05f);
	}
	
	private static void registerIronOres()
	{
		registerOre(Block.getIdFromBlock(Blocks.iron_ore), 0, Item.getIdFromItem(ENItems.IronGravel), 0);
		registerOre(Block.getIdFromBlock(ENBlocks.IronOre), 0, Item.getIdFromItem(ENItems.IronSand), 0);
		registerOre(Block.getIdFromBlock(ENBlocks.IronOre), 1, Item.getIdFromItem(ENItems.IronDust), 0);
	}
	
	private static void registerGoldOres()
	{
		registerOre(Block.getIdFromBlock(Blocks.gold_ore), 0, Item.getIdFromItem(ENItems.GoldGravel), 0);
		registerOre(Block.getIdFromBlock(ENBlocks.GoldOre), 0, Item.getIdFromItem(ENItems.GoldSand), 0);
		registerOre(Block.getIdFromBlock(ENBlocks.GoldOre), 1, Item.getIdFromItem(ENItems.GoldDust), 0);
	}
}
