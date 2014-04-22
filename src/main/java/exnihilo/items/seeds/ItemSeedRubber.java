package exnihilo.items.seeds;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import exnihilo.proxies.Proxy;

public class ItemSeedRubber extends ItemSeedBase{

	public static ArrayList<Block> saplings = new ArrayList<Block>();
	EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
	
	public ItemSeedRubber() {
		super(Blocks.sapling, Blocks.dirt);
	}

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
    	World worldRand = Proxy.getProxy().getWorld();
    	if (saplings.size() > 0)
    	{
    		int rand = worldRand.rand.nextInt(saplings.size());
    		
    		return saplings.get(rand);
    	}
    	
        return Blocks.sapling;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Plains;
    }
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.SEED_RUBBER_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.SEED_RUBBER_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemSeedRubber");
	}
}
