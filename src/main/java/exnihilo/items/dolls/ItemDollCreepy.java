package exnihilo.items.dolls;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemDollCreepy extends Item {

	public ItemDollCreepy() {
		super();
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.CREEPY_DOLL_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.CREEPY_DOLL_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemDollEnder");
	}
}
