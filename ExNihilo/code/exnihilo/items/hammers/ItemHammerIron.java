package exnihilo.items.hammers;

import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemHammerIron extends ItemHammerBase {
	public ItemHammerIron(int id) {
		super(id, EnumToolMaterial.IRON);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.HAMMER_UNLOCALIZED_NAMES[2];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.HAMMER_UNLOCALIZED_NAMES[2];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerIron");
	}
}
