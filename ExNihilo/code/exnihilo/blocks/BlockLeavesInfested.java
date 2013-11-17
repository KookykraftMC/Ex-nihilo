package exnihilo.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityLeavesInfested;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeavesInfested extends Block implements ITileEntityProvider
{
	public BlockLeavesInfested(int par1) {
		//super(par1);
		super(par1, Material.leaves);
		this.isBlockContainer = true;

		setHardness(0.4f);
		setLightOpacity(1);
		setStepSound(soundGrassFootstep);
		setBurnProperties(this.blockID, 5,150);

		setUnlocalizedName(ModData.ID + "." + BlockData.LEAVES_INFESTED_KEY);
		GameRegistry.registerTileEntity(TileEntityLeavesInfested.class, this.getUnlocalizedName());
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = Block.leaves.getIcon(0, 0);
	}

	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7)
	{
		//Don't drop anything. This is to override the base chance to drop saplings. 
	}

	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		TileEntityLeavesInfested leaves = (TileEntityLeavesInfested) world.getBlockTileEntity(x, y, z);
		Block mimic = Block.blocksList[leaves.blockID];
		Color color = new Color(mimic.colorMultiplier(world, x, y, z));
		
		return color.toInt();
	}

	public int getLeafColor(IBlockAccess world, int par2, int par3, int par4)
	{
		return super.colorMultiplier(world, par2, par3, par4);
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
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			TileEntityLeavesInfested leaves = (TileEntityLeavesInfested) world.getBlockTileEntity(x, y, z);

			if (leaves != null)
			{
				if (world.rand.nextFloat() < leaves.getProgress() * .3f)
				{
					this.dropBlockAsItem_do(world, x, y, z, new ItemStack(Item.silk.itemID, 1, 0));
				}

				if (world.rand.nextFloat() < leaves.getProgress() * .1f)
				{
					this.dropBlockAsItem_do(world, x, y, z, new ItemStack(Item.silk.itemID, 1, 0));
				}
			}
		}

		return world.setBlockToAir(x, y, z);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6)
	{
		super.breakBlock(world, x, y, z, par5, par6);
		world.removeBlockTileEntity(x, y, z);
	}

	@Override
	public boolean onBlockEventReceived(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		super.onBlockEventReceived(par1World, par2, par3, par4, par5, par6);
		TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		return tileentity != null ? tileentity.receiveClientEvent(par5, par6) : false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLeavesInfested();
	}
}
