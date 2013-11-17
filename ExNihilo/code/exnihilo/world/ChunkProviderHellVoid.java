package exnihilo.world;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
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
}
