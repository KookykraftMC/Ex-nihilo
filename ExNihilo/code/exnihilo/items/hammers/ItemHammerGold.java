package exnihilo.items.hammers;

import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemHammerGold extends ItemHammerBase{

	public ItemHammerGold(int id) {
		super(id, EnumToolMaterial.GOLD);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.HAMMER_UNLOCALIZED_NAMES[3];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.HAMMER_UNLOCALIZED_NAMES[3];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerGold");
	}
}
