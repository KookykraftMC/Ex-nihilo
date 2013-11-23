package exnihilo.items.dolls;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemDoll extends Item {

	public ItemDoll(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.DOLL_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.DOLL_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemDoll");
	}
}
