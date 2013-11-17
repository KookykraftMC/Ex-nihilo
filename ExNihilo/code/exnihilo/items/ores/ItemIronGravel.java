package exnihilo.items.ores;

import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemIronGravel extends Item{

	public ItemIronGravel(int id) {
		super(id);
		
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.IRON_ORE_UNLOCALIZED_NAMES[0];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.IRON_ORE_UNLOCALIZED_NAMES[0];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemIronGravel");
	}
}
