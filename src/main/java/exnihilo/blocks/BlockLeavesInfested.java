package exnihilo.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.blocks.tileentities.TileEntityLeavesInfested;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.registries.ColorRegistry;

public class BlockLeavesInfested extends BlockLeaves implements ITileEntityProvider
{
	public BlockLeavesInfested() {
		super();
		this.isBlockContainer = true;

		setHardness(0.4f);
		setLightOpacity(1);
		setStepSound(soundTypeGrass);
		Blocks.fire.setFireInfo(this, 5,150);

		setBlockName(ModData.ID + "." + BlockData.LEAVES_INFESTED_KEY);
		GameRegistry.registerTileEntity(TileEntityLeavesInfested.class, this.getUnlocalizedName());
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = Blocks.leaves.getIcon(0, 0);
	}

	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7)
	{
		//Don't drop anything. This is to override the base chance to drop saplings. 
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		TileEntityLeavesInfested leaves = (TileEntityLeavesInfested) world.getTileEntity(x, y, z);
		
		if (leaves != null)
		{
			return leaves.color.toInt();
		}else
		{
			return ColorRegistry.color("white").toInt();
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
    {
        return blockIcon;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderColor(int par1)
    {
        return ColorRegistry.color("white").toInt();
    }

	public int damageDropped(int par1)
	{
		return 0;
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean hasTileEntity()
	{
		return true;
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
	}

	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			TileEntityLeavesInfested leaves = (TileEntityLeavesInfested) world.getTileEntity(x, y, z);

			if (leaves != null)
			{
				if (world.rand.nextFloat() < leaves.getProgress() * (float)ModData.SILKWORM_STRING_PROBABILITY)
				{
					this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.string, 1, 0));
				}

				if (world.rand.nextFloat() < leaves.getProgress() * (float)(ModData.SILKWORM_STRING_PROBABILITY / 4.0d))
				{
					this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.string, 1, 0));
				}
			}
		}

		return world.setBlockToAir(x, y, z);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
	{
		super.breakBlock(world, x, y, z, par5, par6);
		world.removeTileEntity(x, y, z);
	}

	@Override
	public boolean onBlockEventReceived(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		super.onBlockEventReceived(par1World, par2, par3, par4, par5, par6);
		TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
		return tileentity != null ? tileentity.receiveClientEvent(par5, par6) : false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityLeavesInfested();
	}

	@Override
	public String[] func_150125_e() {
		// TODO Auto-generated method stub
		return new String[] {"infested"};
	}
}
