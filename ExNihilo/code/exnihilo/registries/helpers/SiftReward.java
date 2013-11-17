package exnihilo.registries.helpers;

public class SiftReward {
	public int sourceID;
	public int sourceMeta;
	public int id;
	public int meta;
	public int rarity;
	
	public SiftReward(int sourceID, int sourceMeta, int id, int meta, int rarity)
	{
		this.sourceID = sourceID;
		this.sourceMeta = sourceMeta;
		this.id = id;
		this.meta = meta;
		this.rarity = rarity;
	}
}
