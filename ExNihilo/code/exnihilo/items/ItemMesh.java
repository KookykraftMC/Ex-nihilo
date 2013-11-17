package exnihilo.items;

import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMesh extends Item {

	public ItemMesh(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.MESH_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.MESH_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconMesh");
	}
}
