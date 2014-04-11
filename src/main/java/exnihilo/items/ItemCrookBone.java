package exnihilo.items;

import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ItemCrookBone extends ItemCrook
{
	public ItemCrookBone(int id) {
		super(id, EnumToolMaterial.STONE);
		
		this.setMaxDamage((int)((float)this.getMaxDamage() * 3.1f));
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.CROOK_BONE_UNLOCALIZED_NAME;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.CROOK_BONE_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":CrookBone");
	}
}
