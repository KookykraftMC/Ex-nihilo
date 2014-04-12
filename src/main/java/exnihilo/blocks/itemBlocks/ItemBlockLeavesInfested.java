package exnihilo.blocks.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class ItemBlockLeavesInfested extends ItemBlock{

	public ItemBlockLeavesInfested(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.LEAVES_INFESTED_UNLOCALIZED_NAMES[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
