package exnihilo.items.seeds;

import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class ItemSeedOak extends ItemSeedBase{

	public ItemSeedOak(int id) {
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
    	//0: Oak
        return 0;
    }
    
    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return EnumPlantType.Plains;
    }
	
	@Override
	public String getUnlocalizedName()
	{
		return ItemData.SEED_OAK_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.SEED_OAK_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemSeedOak");
	}

}
