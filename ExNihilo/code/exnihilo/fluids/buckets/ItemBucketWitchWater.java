package exnihilo.fluids.buckets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.FluidData;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;

public class ItemBucketWitchWater extends ItemBucket {

    private String iconName;

    public ItemBucketWitchWater(int i, int blockId) {
            super(i, blockId);
            setCreativeTab(CreativeTabs.tabMisc);
            setContainerItem(Item.bucketEmpty);
    }

    @Override
    public String getItemDisplayName(ItemStack itemstack) {
            return FluidData.BUCKET_WITCHWATER_NAME;
    }

	@Override
	public String getUnlocalizedName()
	{
		return FluidData.BUCKET_WITCHWATER_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return FluidData.BUCKET_WITCHWATER_UNLOCALIZED_NAME;
	}

    @Override
    @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemBucketWitchWater");
	}
}
