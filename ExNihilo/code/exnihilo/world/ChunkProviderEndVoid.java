package exnihilo.world;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderEnd;

public class ChunkProviderEndVoid extends ChunkProviderEnd{
	public ChunkProviderEndVoid(World par1World, long par2) {
		super(par1World, par2);
	}

    @Override
    public void generateTerrain(int par1, int par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase)
    {
    	//Do nothing.
    }

    @Override
    public void replaceBlocksForBiome(int par1, int par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase)
    {
    	//Do nothing.
    }
}
