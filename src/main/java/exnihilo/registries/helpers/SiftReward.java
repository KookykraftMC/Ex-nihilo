package exnihilo.registries.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class SiftReward {
	public Block source;
	public int sourceMeta;
	public boolean ignoreMeta;
	public Item item;
	public int meta;
	public int rarity;
	
	public SiftReward(Block source, int sourceMeta, Item item, int meta, int rarity)
	{
		this.source = source;
		this.sourceMeta = sourceMeta;
		this.ignoreMeta = false;
		this.item = item;
		this.meta = meta;
		this.rarity = rarity;
	}
	
	public SiftReward(Block source, Item item, int meta, int rarity)
	{
		this.source = source;
		this.sourceMeta = 0;
		this.ignoreMeta = true;
		this.item = item;
		this.meta = meta;
		this.rarity = rarity;
	}
}
