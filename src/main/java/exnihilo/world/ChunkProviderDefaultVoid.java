package exnihilo.world;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class ChunkProviderDefaultVoid extends ChunkProviderGenerate
{
    public ChunkProviderDefaultVoid(World par1World, long par2, boolean par4) {
		super(par1World, par2, par4);
	}

    @Override
	public void func_147424_a(int par1, int par2, Block[] par3ArrayOfBlock)
    {
    	//Do nothing.
    }

    @Override
    public void replaceBlocksForBiome(int par1, int par2, Block[] par3ArrayOfBlock, byte[] par4ArrayofBytes, BiomeGenBase[] par4ArrayOfBiomeGenBase)
    {
    	//Do nothing.
    }
}
