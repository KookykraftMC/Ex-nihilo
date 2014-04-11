package exnihilo.items.seeds;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemSeedSpruce extends ItemSeedBase{

	public ItemSeedSpruce(int id) {
		super(id, Block.sapling.blockID, Block.dirt.blockID);
	}
	
    @Override
    public int getPlantID(World world, int x, int y, int z)
    {
        return Block.sapling.blockID;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z)
    {
    	//1: Spruce
        return 1;
    }
    
    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return EnumPlantType.Plains;
    }
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.SEED_SPRUCE_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.SEED_SPRUCE_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemSeedSpruce");
	}

}
