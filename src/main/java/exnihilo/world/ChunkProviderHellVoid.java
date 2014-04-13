package exnihilo.world;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;
import exnihilo.data.WorldData;

public class ChunkProviderHellVoid extends ChunkProviderHell{
	public ChunkProviderHellVoid(World par1World, long par2) {
		super(par1World, par2);
	}

    @Override
    public void func_147419_a(int par1, int par2, Block[] par3ArrayOfBlock)
    {
    	//Do nothing.
    }

    @Override
    public void func_147418_b(int par1, int par2, Block[] par3ArrayOfBlock)
    {
    	//Do nothing.
    }
    
    @Override
    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
    {
    	if (WorldData.allowNetherFortresses)
    	{
    		super.populate(par1IChunkProvider, par2, par3);
    	}
    }
}
