package exnihilo.blocks.renderers;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.BlockBarrel;
import exnihilo.blocks.models.ModelBarrel;
import exnihilo.blocks.models.ModelBarrelInternal;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RenderBarrel extends TileEntitySpecialRenderer{
	private ModelBarrel barrel;
	private ModelBarrelInternal internal;

	public RenderBarrel(ModelBarrel model)
	{
		this.barrel = model;
		internal = new ModelBarrelInternal();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) 
	{
		drawBarrel(tileentity, x, y, z, f);
		drawBarrelContents(tileentity, x, y, z, f);
	}


	private void drawBarrel(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F,(float)y + 1.5F,(float)z + 0.5F);
		GL11.glScalef(-0.8F, -1F, 0.8F);

		bindBarrelTexture(tileentity.getBlockType().blockID, tileentity.getBlockMetadata());
		barrel.simpleRender(0.0625F);

		GL11.glPopMatrix();
	}

	private void drawBarrelContents(TileEntity tileentity, double x, double y, double z, float f)
	{
		TileEntityBarrel barrel = (TileEntityBarrel)tileentity;

		if (barrel.mode != BarrelMode.EMPTY)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float)y + barrel.getAdjustedVolume(),(float)z + 0.5F);
			GL11.glScalef(0.8f, 1.0f, 0.8f);

			bindInternalTexture();

			Fluid content = barrel.fluid.getFluid();
			Icon icon = content.getIcon();
			Color color = barrel.color;
			boolean transparency = false;
			boolean clouds = false;

			switch (barrel.mode)
			{
			case COMPOST:
				icon = BlockBarrel.iconCompost;
				break;

			case FLUID:
				color = new Color(content.getColor());
				transparency = true;
				break;

			case DIRT:
				icon = Block.dirt.getIcon(0, 0);
				break;

			case CLAY:
				icon = Block.blockClay.getIcon(0, 0);
				break;

			case SPORED:
				clouds = true;
				transparency = true;
				break;	

			case SLIME:
				clouds = true;
				transparency = true;
				break;

			case NETHERRACK:
				icon = Block.netherrack.getIcon(0, 0);
				break;

			case ENDSTONE:
				icon = Block.whiteStone.getIcon(0, 0);
				break;

			case MILKED:
				transparency = true;
				clouds = true;
				break;

			case WITCHY:
				transparency = true;
				clouds = true;
				break;

			case SOULSAND:
				icon = Block.slowSand.getIcon(0, 0);
				break;
				
			case OBSIDIAN:
				icon = Block.obsidian.getIcon(0, 0);
				break;
				
			case COBBLESTONE:
				icon = Block.cobblestone.getIcon(0, 0);
				break;

			default:
				break;
			}

			if (clouds)
			{
				internal.render(ColorRegistry.color("black"), BlockBarrel.iconClouds, transparency);
			}
			
			GL11.glTranslatef(0,0.0001f,0);
			
			internal.render(color, icon, transparency);
			GL11.glPopMatrix();
		}


	}

	public void bindBarrelTexture(int blockID, int meta)
	{
		if (meta >= 0)
		{
			bindTexture(barrel.getBarrelTexture(blockID, meta));
		}
	}

	public void bindInternalTexture()
	{
		ResourceLocation fluidTexture = TextureMap.locationBlocksTexture;
		bindTexture(fluidTexture);
	}




}
