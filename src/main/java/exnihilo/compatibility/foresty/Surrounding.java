package exnihilo.compatibility.foresty;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;

public class Surrounding {
	public Map<String, Integer> blocks = new HashMap<String, Integer>();
	public int leafCount;
	public String blockAbove;
	
	public void addBlock(Block par1Block, int meta)
	{
		Block block = par1Block;
		
		if (block != null && block.isLeaves(null, 0, 0, 0))
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
	}
	
	public void setBlockAbove(Block block, int meta)
	{
		this.blockAbove = block + ":" + meta;
	}
}
