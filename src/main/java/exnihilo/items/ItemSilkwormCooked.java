package exnihilo.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemSilkwormCooked extends ItemFood {

	public ItemSilkwormCooked() {
		super(2, 10.0f, false);
		setCreativeTab(CreativeTabs.tabFood);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.SILKWORM_COOKED_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.SILKWORM_COOKED_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":SilkwormCooked");
	}
}
