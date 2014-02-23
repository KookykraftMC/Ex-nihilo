package exnihilo.items.seeds;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import exnihilo.registries.helpers.SiftReward;

public class ItemSeedRubber extends ItemSeedBase{

	public static ArrayList<Block> saplings = new ArrayList<Block>();
	
	public ItemSeedRubber(int id) {
		super(id, Block.sapling.blockID, Block.dirt.blockID);
	}

    @Override
    public int getPlantID(World world, int x, int y, int z)
    {
    	if (saplings.size() > 0)
    	{
    		int rand = world.rand.nextInt(saplings.size());
    		
    		return saplings.get(rand).blockID;
    	}
    	
        return Block.sapling.blockID;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z)
    {
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
		return ItemData.SEED_RUBBER_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.SEED_RUBBER_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemSeedRubber");
	}
}
