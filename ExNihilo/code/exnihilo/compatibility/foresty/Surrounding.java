package exnihilo.compatibility.foresty;

import java.util.HashMap;
import java.util.Map;

public class Surrounding {
	public Map<String, Integer> blocks = new HashMap<String, Integer>();
	
	public void addBlock(int blockID, int meta)
	{
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
}
