package exnihilo.world;

import exnihilo.data.WorldData;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;

public class ChunkProviderHellVoid extends ChunkProviderHell{
	public ChunkProviderHellVoid(World par1World, long par2) {
		super(par1World, par2);
	}

    @Override
    public void generateNetherTerrain(int par1, int par2, byte[] par3ArrayOfByte)
    {
    	//Do nothing.
    }

    @Override
    public void replaceBlocksForBiome(int par1, int par2, byte[] par3ArrayOfByte)
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
