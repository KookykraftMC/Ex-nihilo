package exnihilo.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemCrookBone extends ItemCrook
{
	public ItemCrookBone() {
		super(ToolMaterial.STONE);
		
		this.setMaxDamage((int)((float)this.getMaxDamage() * 3.1f));
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.CROOK_BONE_UNLOCALIZED_NAME;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.CROOK_BONE_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":CrookBone");
	}
}
