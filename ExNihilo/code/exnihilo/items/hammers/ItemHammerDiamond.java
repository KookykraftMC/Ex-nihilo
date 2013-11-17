package exnihilo.items.hammers;

import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemHammerDiamond extends ItemHammerBase{

	public ItemHammerDiamond(int id) {
		super(id, EnumToolMaterial.EMERALD);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.HAMMER_UNLOCALIZED_NAMES[4];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.HAMMER_UNLOCALIZED_NAMES[4];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerDiamond");
	}
}
