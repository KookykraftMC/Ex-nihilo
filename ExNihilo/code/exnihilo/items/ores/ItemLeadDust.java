package exnihilo.items.ores;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemLeadDust extends Item{

	public ItemLeadDust(int id) {
		super(id);
		
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.LEAD_ORE_UNLOCALIZED_NAMES[2];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.LEAD_ORE_UNLOCALIZED_NAMES[2];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemLeadDust");
	}
}
