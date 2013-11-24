package exnihilo.compatibility.foresty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class Hive {
	public BiomeGenBase requiredBiome = null;
	public Float minTemperature = null;
	public Float maxTemperature = null;
	public Float minRainfall = null;
	public Float maxRainfall = null;

	public String requiredSubstrate = null;
	private static int REQUIRED_SUBSTRATE_COUNT = 20;

	public Boolean requiredCanSeeSky = null;

	public List<String> flowers = new ArrayList<String>(); 
	public List<Type> biomeTypes = new ArrayList<Type>();
	public int blockID;
	public int meta;
	
	public Hive(int blockID, int meta)
	{
		this.blockID = blockID;
		this.meta = meta;
	}

	public boolean areAllRequirementsMet(BiomeGenBase biome, Surrounding local, boolean canSeeSky)
	{
		if (
				(requiredBiome != null && biome.biomeID != requiredBiome.biomeID) ||
				(minTemperature != null && biome.temperature < minTemperature) ||
				(maxTemperature != null && biome.temperature > maxTemperature) ||
				(minRainfall != null && biome.rainfall < minRainfall) ||
				(maxRainfall != null && biome.rainfall > maxRainfall) ||
				(requiredCanSeeSky != null && canSeeSky != requiredCanSeeSky)
				)
		{
			return false;
		}

		if(requiredSubstrate != null)
		{
			int substrateCount = 0;
			if (local.blocks.containsKey(requiredSubstrate))
			{
				substrateCount = local.blocks.get(requiredSubstrate);
			}

			if (substrateCount < REQUIRED_SUBSTRATE_COUNT)
			{
				return false;
			}
		}

		if (!biomeTypes.isEmpty())
		{
			Type[] types = BiomeDictionary.getTypesForBiome(biome);
			
			Iterator<Type> it = biomeTypes.iterator();
			
			while (it.hasNext()) {
				boolean found = false;
				
				for(int j = 0; j < types.length; j++)
				{
					if (types[j] == it.next())
					{
						found = true;
					}
				}
				
				if (!found)
				{
					return false;
				}
			}
		}
		
		if (!flowers.isEmpty())
		{
			Iterator<String> it = flowers.iterator();
			boolean found = false;
			
			while (it.hasNext()) {
				if (local.blocks.containsKey(it.next()))
				{
					found = true;
					break;
				}
			}
		}

		return true;
	}

	public float getSpawnChance(Surrounding local)
	{
		return 1.0f;
	}
}
