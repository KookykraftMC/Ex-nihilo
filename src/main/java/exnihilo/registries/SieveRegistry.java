package exnihilo.registries;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.registries.helpers.SiftReward;

public class SieveRegistry {
	public static ArrayList<SiftReward> rewards = new ArrayList<SiftReward>();
	
	public static boolean dropCopper = false;
	public static boolean dropTin = false;
	public static boolean dropSilver = false;
	public static boolean dropLead = false;
	public static boolean dropNickel = false;
	public static boolean dropPlatinum = false;
	public static boolean dropAluminum = false;
	
	public static boolean dropRubberSeeds = false;
	
	public static void register(int sourceID, int sourceMeta, int outputID, int outputMeta, int rarity)
	{
		SiftReward entry = new SiftReward(sourceID, sourceMeta, outputID, outputMeta, rarity);
		
		if(Block.blockRegistry.getObjectById(sourceID) != null)
		{
			rewards.add(entry);
		}else
		{
			System.out.println("Ex Nihilo: An item was added to the SieveRegistry which was not a block");
		}
	}
	
	public static void register(int sourceID, int outputID, int outputMeta, int rarity)
	{
		SiftReward entry = new SiftReward(sourceID, outputID, outputMeta, rarity);
		
		if(Block.blockRegistry.getObjectById(sourceID) != null)
		{
			rewards.add(entry);
		}else
		{
			System.out.println("Ex Nihilo: An item was added to the SieveRegistry which was not a block");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<SiftReward> getRewards(int id, int meta)
	{
		ArrayList<SiftReward> rewardList = new ArrayList();

		Iterator<SiftReward> it = rewards.iterator();
		while(it.hasNext())
		{
			SiftReward reward = it.next();

			if (reward.sourceID == id && reward.sourceMeta == meta)
			{
				rewardList.add(reward);
			}
		}
		
		return rewardList;
	}
	
	public static boolean Contains(int id, int meta)
	{
		Iterator<SiftReward> it = rewards.iterator();
		while(it.hasNext())
		{
			SiftReward reward = it.next();

			if (reward.sourceID == id && (reward.sourceMeta == meta || reward.ignoreMeta == true))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean Contains(int id)
	{
		Iterator<SiftReward> it = rewards.iterator();
		while(it.hasNext())
		{
			SiftReward reward = it.next();

			if (reward.sourceID == id && reward.ignoreMeta == true)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static void load(Configuration config)
	{
		String CATEGORY_SIEVE_OPTIONS = "sieve options";
		
		dropCopper = config.get(CATEGORY_SIEVE_OPTIONS, "give copper", false, "Forces the sieve to give copper even if no mods are detected which require it.").getBoolean(false);
		dropTin = config.get(CATEGORY_SIEVE_OPTIONS, "give tin", false, "Forces the sieve to give tin even if no mods are detected which require it.").getBoolean(false);
		dropLead = config.get(CATEGORY_SIEVE_OPTIONS, "give lead", false, "Forces the sieve to give lead even if no mods are detected which require it.").getBoolean(false);
		dropSilver = config.get(CATEGORY_SIEVE_OPTIONS, "give silver", false, "Forces the sieve to give silver even if no mods are detected which require it.").getBoolean(false);
		dropNickel = config.get(CATEGORY_SIEVE_OPTIONS, "give nickel", false, "Forces the sieve to give nickel even if no mods are detected which require it.").getBoolean(false);
		dropPlatinum = config.get(CATEGORY_SIEVE_OPTIONS, "give platinum", false, "Forces the sieve to give platinum even if no mods are detected which require it.").getBoolean(false);
		dropAluminum = config.get(CATEGORY_SIEVE_OPTIONS, "give aluminum", false, "Forces the sieve to give aluminum even if no mods are detected which require it.").getBoolean(false);
	}
	
	public static void registerRewards()
	{
		//Dirt!
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.Stones), 0, 1);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.Stones), 0, 1);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.Stones), 0, 2);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.Stones), 0, 2);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.Stones), 0, 3);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.Stones), 0, 3);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(net.minecraft.init.Items.wheat_seeds), 0, 15);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.GrassSeeds), 0, 15);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(net.minecraft.init.Items.melon_seeds), 0, 32);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(net.minecraft.init.Items.pumpkin_seeds), 0, 32);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.SeedsSugarcane), 0, 32);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.SeedsCarrot), 0, 64);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.SeedsPotato), 0, 64);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.SeedsOak), 0, 64);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.SeedsSpruce), 0, 90);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.dirt), 0, Item.getIdFromItem(Items.SeedsBirch), 0, 90);

		//Gravel!
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(net.minecraft.init.Items.flint), 0, 4);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.IronGravel), 0, 5);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.GoldGravel), 0, 11);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(net.minecraft.init.Items.coal), 0, 8);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(net.minecraft.init.Items.dye), 4, 20); //Lapis Lazuli
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(net.minecraft.init.Items.diamond), 0, 128);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(net.minecraft.init.Items.emerald), 0, 150);
		
		//Sand!
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.IronSand), 0, 5);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.GoldSand), 0, 11);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(net.minecraft.init.Items.dye), 3, 32); //Cocoa beans
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.SeedsCactus), 0, 32);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.SeedsJungle), 0, 64);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.Spores), 0, 128);
				
		//Soul Sand!
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.soul_sand), 0, Item.getIdFromItem(net.minecraft.init.Items.quartz), 0, 1);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.soul_sand), 0, Item.getIdFromItem(net.minecraft.init.Items.quartz), 0, 3);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.soul_sand), 0, Item.getIdFromItem(net.minecraft.init.Items.nether_wart), 0, 20);
		register(Block.getIdFromBlock(net.minecraft.init.Blocks.soul_sand), 0, Item.getIdFromItem(net.minecraft.init.Items.ghast_tear), 0, 64);
		
		//Dust!
		register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.IronDust), 0, 5);
		register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.GoldDust), 0, 11);
		register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(net.minecraft.init.Items.dye), 15, 5); //Bone Meal
		register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(net.minecraft.init.Items.redstone), 0, 8);		
		register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(net.minecraft.init.Items.gunpowder), 0, 15);
		register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(net.minecraft.init.Items.glowstone_dust), 0, 16);
		register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(net.minecraft.init.Items.blaze_powder), 0, 20);
	}
	
	public static void RegisterOptionalOres()
	{
		if (dropCopper)
		{
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.CopperGravel), 0, 7);
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.CopperSand), 0, 7);
			register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.CopperDust), 0, 7);
		}
		
		if (dropTin)
		{
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.TinGravel), 0, 7);
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.TinSand), 0, 7);
			register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.TinDust), 0, 7);
		}
		
		if (dropSilver)
		{
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.SilverGravel), 0, 11);
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.SilverSand), 0, 11);
			register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.SilverDust), 0, 11);
		}
		
		if (dropLead)
		{
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.LeadGravel), 0, 9);
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.LeadSand), 0, 9);
			register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.LeadDust), 0, 9);
		}
		
		if (dropNickel)
		{
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.NickelGravel), 0, 11);
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.NickelSand), 0, 11);
			register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.NickelDust), 0, 11);
		}
		
		if (dropPlatinum)
		{
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.PlatinumGravel), 0, 32);
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.PlatinumSand), 0, 32);
			register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.PlatinumDust), 0, 32);
		}
		
		if (dropAluminum)
		{
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.gravel), 0, Item.getIdFromItem(Items.AluminumGravel), 0, 10);
			register(Block.getIdFromBlock(net.minecraft.init.Blocks.sand), 0, Item.getIdFromItem(Items.AluminumSand), 0, 10);
			register(Block.getIdFromBlock(Blocks.Dust), 0, Item.getIdFromItem(Items.AluminumDust), 0, 10);
		}
	}
}
