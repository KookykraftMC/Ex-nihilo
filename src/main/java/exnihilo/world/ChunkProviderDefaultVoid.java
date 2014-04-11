package exnihilo.world;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class ChunkProviderDefaultVoid extends ChunkProviderGenerate
{
    public ChunkProviderDefaultVoid(World par1World, long par2, boolean par4) {
		super(par1World, par2, par4);
	}

    @Override
	public void generateTerrain(int par1, int par2, byte[] par3ArrayOfByte)
    {
    	//Do nothing.
    }

    @Override
    public void replaceBlocksForBiome(int par1, int par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase)
    {
    	//Do nothing.
    }
}
