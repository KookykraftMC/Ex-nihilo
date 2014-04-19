package exnihilo.compatibility.foresty;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.server.MinecraftServer;

public class Surrounding {
	public Map<String, Integer> blocks = new HashMap<String, Integer>();
	public int leafCount;
	public String blockAbove;
	
	public void addBlock(int blockID, int meta)
	{
		Block block = Block.blocksList[blockID];
		
		if (block != null && block.isLeaves(MinecraftServer.getServer().worldServers[0], 0, 0, 0))
		{
			leafCount++;
		}
		
		String key = blockID + ":" + meta;
		
		if (blocks.containsKey(key))
		{
			int count = blocks.get(key);
			
			blocks.put(key, count + 1);
		}else
		{
			blocks.put(key, 1);
		}
	}
	
	public void setBlockAbove(int blockID, int meta)
	{
		this.blockAbove = blockID + ":" + meta;
	}
}
