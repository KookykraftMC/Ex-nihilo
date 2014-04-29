package exnihilo.blocks.ores.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class ItemBlockGoldOre extends ItemBlock
{
	public ItemBlockGoldOre(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.GOLD_ORE_UNLOCALIZED_NAMES[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}