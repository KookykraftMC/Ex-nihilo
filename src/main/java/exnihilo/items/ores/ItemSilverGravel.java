package exnihilo.items.ores;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemSilverGravel extends Item{

	public ItemSilverGravel() {
		super();
		
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.SILVER_ORE_UNLOCALIZED_NAMES[0];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.SILVER_ORE_UNLOCALIZED_NAMES[0];
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemSilverGravel");
	}
}
