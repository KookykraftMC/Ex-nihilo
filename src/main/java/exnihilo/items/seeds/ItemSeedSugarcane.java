package exnihilo.items.seeds;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemSeedSugarcane extends ItemSeedBase{

	public ItemSeedSugarcane() {
		super(Block.getBlockFromItem(Items.reeds), Blocks.dirt);
	}
	
    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return Block.getBlockFromItem(Items.reeds);
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Beach;
    }
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.SEED_SUGAR_CANE_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.SEED_SUGAR_CANE_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemSeedSugarcane");
	}

}