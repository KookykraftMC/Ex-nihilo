package exnihilo.blocks.itemBlocks;

import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSieve extends ItemBlock{

	public ItemBlockSieve(int par1) {
		super(par1);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.SIEVE_UNLOCALIZED_NAMES[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
