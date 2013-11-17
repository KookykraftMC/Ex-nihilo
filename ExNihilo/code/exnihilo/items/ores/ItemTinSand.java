package exnihilo.items.ores;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemTinSand extends Item{

	public ItemTinSand(int id) {
		super(id);
		
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.TIN_ORE_UNLOCALIZED_NAMES[1];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.TIN_ORE_UNLOCALIZED_NAMES[1];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemTinSand");
	}
}
