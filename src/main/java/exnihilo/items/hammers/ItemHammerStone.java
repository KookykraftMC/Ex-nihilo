package exnihilo.items.hammers;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemHammerStone extends ItemHammerBase{

	public ItemHammerStone() {
		super(ToolMaterial.STONE);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.HAMMER_UNLOCALIZED_NAMES[1];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.HAMMER_UNLOCALIZED_NAMES[1];
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerStone");
	}
}
