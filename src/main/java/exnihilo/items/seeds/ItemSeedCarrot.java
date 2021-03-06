package exnihilo.items.seeds;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemSeedCarrot extends ItemSeedBase{

	public ItemSeedCarrot() {
		super(Blocks.carrots, Blocks.dirt);
	}
	
    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return Blocks.carrots;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Crop;
    }
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.SEED_CARROT_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.SEED_CARROT_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemSeedCarrot");
	}
}
