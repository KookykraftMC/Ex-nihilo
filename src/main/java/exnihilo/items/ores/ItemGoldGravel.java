package exnihilo.items.ores;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemGoldGravel extends Item{

	public ItemGoldGravel(int id) {
		super(id);
		
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.GOLD_ORE_UNLOCALIZED_NAMES[0];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.GOLD_ORE_UNLOCALIZED_NAMES[0];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemGoldGravel");
	}
}
