//package exnihilo.compatibility.foresty;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import net.minecraft.block.Block;
//import net.minecraft.world.biome.BiomeGenBase;
//import net.minecraftforge.common.BiomeDictionary;
//import net.minecraftforge.common.BiomeDictionary.Type;
//
//public class Hive {
//	public BiomeGenBase requiredBiome = null;
//	public Float minTemperature = null;
//	public Float maxTemperature = null;
//	public Float minRainfall = null;
//	public Float maxRainfall = null;
//	public Float minYLevel = null;
//	public Float maxYLevel = null;
//	public int defaultSpawnBonus = 0;
//
//	public String requiredSubstrate = null;
//	private static int REQUIRED_SUBSTRATE_COUNT = 15;
//
//	public Boolean requiredCanSeeSky = null;
//	public Boolean requiresTree = null;
//	public String requiresBlockAbove = null;
//
//	public List<String> flowers = new ArrayList<String>(); 
//	public List<Type> biomeTypes = new ArrayList<Type>();
//	public int blockID;
//	public int meta;
//	
//	public Hive(int blockID, int meta)
//	{
//		this.blockID = blockID;
//		this.meta = meta;
//	}
//
//	public boolean areAllRequirementsMet(BiomeGenBase biome, Surrounding local, boolean canSeeSky, int height)
//	{
//		if (
//				(requiredBiome != null && biome.biomeID != requiredBiome.biomeID) ||
//				(minTemperature != null && biome.temperature < minTemperature) ||
//				(maxTemperature != null && biome.temperature > maxTemperature) ||
//				(minRainfall != null && biome.rainfall < minRainfall) ||
//				(maxRainfall != null && biome.rainfall > maxRainfall) ||
//				(minYLevel != null && height < minYLevel) ||
//				(maxYLevel != null && height > maxYLevel) ||
//				(requiredCanSeeSky != null && canSeeSky != requiredCanSeeSky.booleanValue())
//				)
//		{
//			//System.out.println("HIVE: Missing basic requirements");
//			return false;
//		}
//		
//		if(requiresBlockAbove != null && !requiresBlockAbove.equals(local.blockAbove))
//		{
//			//System.out.println("HIVE: The block above needs to be " + local.blockAbove);
//			return false;
//		}
//		
//		if(requiresTree != null && requiresTree.booleanValue() == true && local.leafCount < 20)
//		{
//			//System.out.println("HIVE: Needs to be in a tree");
//			return false;
//		}
//
//		if(requiredSubstrate != null)
//		{
//			int substrateCount = 0;
//			if (local.blocks.containsKey(requiredSubstrate))
//			{
//				substrateCount = local.blocks.get(requiredSubstrate);
//			}
//
//			if (substrateCount < REQUIRED_SUBSTRATE_COUNT)
//			{
//				//System.out.println("HIVE: Missing substrate. Required:" + REQUIRED_SUBSTRATE_COUNT + " of block " + requiredSubstrate + ", Found:" + substrateCount);
//				return false;
//			}
//		}
//
//		if (!biomeTypes.isEmpty())
//		{
//			Type[] types = BiomeDictionary.getTypesForBiome(biome);
//			
//			Iterator<Type> it = biomeTypes.iterator();
//			
//			while (it.hasNext()) {
//				boolean found = false;
//				Type currentType =it.next();
//				
//				for(int j = 0; j < types.length; j++)
//				{
//					if (types[j] == currentType)
//					{
//						found = true;
//					}
//				}
//				
//				if (!found)
//				{
//					//System.out.println("HIVE: Wrong biome type");
//					return false;
//				}
//			}
//		}
//		
//		if (!flowers.isEmpty())
//		{
//			Iterator<String> it = flowers.iterator();
//			boolean found = false;
//			
//			while (it.hasNext()) {
//				if (local.blocks.containsKey(it.next()))
//				{
//					found = true;
//					break;
//				}
//			}
//			
//			if (!found)
//			{
//				//System.out.println("HIVE: Missing flowers");
//				return false;
//			}
//		}
//
//		return true;
//	}
//
//	public int getSpawnChanceModifier(Surrounding local)
//	{
//		int flowerCount = 0;
//		
//		if (!flowers.isEmpty())
//		{
//			Iterator<String> it = flowers.iterator();
//			boolean found = false;
//			
//			while (it.hasNext()) {
//				String key = it.next();
//				
//				if (local.blocks.containsKey(key))
//				{
//					flowerCount += local.blocks.get(key);
//				}
//			}
//		}
//		
//		return defaultSpawnBonus + flowerCount;
//	}
//}
