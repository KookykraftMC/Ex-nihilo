package exnihilo.registries.helpers;

public class SiftReward {
	public int sourceID;
	public int sourceMeta;
	public boolean ignoreMeta;
	public int id;
	public int meta;
	public int rarity;
	
	public SiftReward(int sourceID, int sourceMeta, int id, int meta, int rarity)
	{
		this.sourceID = sourceID;
		this.sourceMeta = sourceMeta;
		this.ignoreMeta = false;
		this.id = id;
		this.meta = meta;
		this.rarity = rarity;
	}
	
	public SiftReward(int sourceID, int id, int meta, int rarity)
	{
		this.sourceID = sourceID;
		this.sourceMeta = 0;
		this.ignoreMeta = true;
		this.id = id;
		this.meta = meta;
		this.rarity = rarity;
	}
}
