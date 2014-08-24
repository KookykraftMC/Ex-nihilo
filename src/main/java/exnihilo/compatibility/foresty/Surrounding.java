package exnihilo.compatibility.foresty;

import java.util.HashMap;
import java.util.Map;

import forestry.api.genetics.IIndividual;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class Surrounding {
	public Map<String, Integer> blocks = new HashMap<String, Integer>();
	public Map<String, Integer> flowers = new HashMap<String, Integer>();
	public int leafCount;

	public String blockAbove;
	
	public void addBlock(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
	    int meta = world.getBlockMetadata(x, y, z);
		
		if (block != null && block.isLeaves(world, x, y, z))
		{
			leafCount++;
		}
		
		String key = block + ":" + meta;
		
		if (blocks.containsKey(key))
		{
			int count = blocks.get(key);
			
			blocks.put(key, count + 1);
		}else
		{
			blocks.put(key, 1);
		}
		
		tryAddFlower(world, null, x, y, z);
	}
	
	public void setBlockAbove(Block block, int meta)
	{
		this.blockAbove = block + ":" + meta;
	}
	
	public void tryAddFlower(World world, IIndividual individual, int x, int y, int z)
	{
		if (HiveRegistry.Flowers.isAcceptedFlower(world, individual, x, y, z))
			addFlower(FlowerType.Normal);
		
		if (HiveRegistry.FlowersNether.isAcceptedFlower(world, individual, x, y, z))
			addFlower(FlowerType.Nether);
		
		if (HiveRegistry.FlowersEnd.isAcceptedFlower(world, individual, x, y, z))
			addFlower(FlowerType.End);
		
		if (HiveRegistry.FlowersJungle.isAcceptedFlower(world, individual, x, y, z))
			addFlower(FlowerType.Jungle);
		
		if (HiveRegistry.FlowersMushroom.isAcceptedFlower(world, individual, x, y, z))
			addFlower(FlowerType.Mushroom);
		
		if (HiveRegistry.FlowersDesert.isAcceptedFlower(world, individual, x, y, z))
			addFlower(FlowerType.Cactus);
		
		if (HiveRegistry.FlowersGourd.isAcceptedFlower(world, individual, x, y, z))
			addFlower(FlowerType.Gourd);
		
		if (world.getBlock(x, y, z) == Blocks.waterlily)
			addFlower(FlowerType.Water);
	}
	
	private void addFlower(FlowerType type)
	{
		String key = type.name();
		
		if (flowers.containsKey(key))
		{
			int count = flowers.get(key);
			
			flowers.put(key, count + 1);
		}else
		{
			flowers.put(key, 1);
		}
	}
	
	public int getFlowerCount(FlowerType type)
	{
		String key = type.name();
		
		switch (type)
		{
		case None:
			return 0;
		
		default:
			if (flowers.containsKey(key))
			{
				return flowers.get(key);
			}
			else
			{
				return 0;
			}
		}
	}
}
