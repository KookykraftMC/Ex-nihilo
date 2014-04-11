package exnihilo.items.hammers;

import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemHammerStone extends ItemHammerBase{

	public ItemHammerStone(int id) {
		super(id, EnumToolMaterial.STONE);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.HAMMER_UNLOCALIZED_NAMES[1];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.HAMMER_UNLOCALIZED_NAMES[1];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerStone");
	}
}
