package exnihilo.items.seeds;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemSeedCarrot extends ItemSeedBase{

	public ItemSeedCarrot(int id) {
		super(id, Block.carrot.blockID, Block.dirt.blockID);
	}
	
    @Override
    public int getPlantID(World world, int x, int y, int z)
    {
        return Block.carrot.blockID;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z)
    {
        return 0;
    }
    
    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return EnumPlantType.Crop;
    }
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.SEED_CARROT_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.SEED_CARROT_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemSeedCarrot");
	}
}
