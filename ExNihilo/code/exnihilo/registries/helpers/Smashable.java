package exnihilo.registries.helpers;

public class Smashable {
	public int sourceID;
	public int sourceMeta;
	public int id;
	public int meta;
	public float chance;
	public float luckMultiplier;
	
	public Smashable(int sourceID, int sourceMeta, int id, int meta, float chance, float luckMultiplier)
	{
		this.sourceID = sourceID;
		this.sourceMeta = sourceMeta;
		this.id = id;
		this.meta = meta;
		this.chance = chance;
		this.luckMultiplier = luckMultiplier;
	}
}
