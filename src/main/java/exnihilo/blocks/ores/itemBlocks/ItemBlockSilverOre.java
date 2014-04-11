package exnihilo.blocks.ores.itemBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import exnihilo.ENBlocks;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class ItemBlockSilverOre extends ItemBlock
{
	public ItemBlockSilverOre() {
		super(ENBlocks.SilverOre);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.SILVER_ORE_UNLOCALIZED_NAMES[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
