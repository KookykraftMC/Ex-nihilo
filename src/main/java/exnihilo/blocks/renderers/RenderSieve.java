package exnihilo.blocks.renderers;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.BlockSieve;
import exnihilo.blocks.models.ModelSieve;
import exnihilo.blocks.models.ModelSieveContents;
import exnihilo.blocks.models.ModelSieveMesh;
import exnihilo.blocks.tileentities.TileEntitySieve;
import exnihilo.blocks.tileentities.TileEntitySieve.SieveMode;

public class RenderSieve extends TileEntitySpecialRenderer{
	private ModelSieve model;
	private ModelSieveMesh mesh;
	private ModelSieveContents contents;
	
	public RenderSieve(ModelSieve model, ModelSieveMesh mesh)
	{
		this.model = model;
		this.mesh = mesh;
		this.contents = new ModelSieveContents();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		renderTable(tileentity, x, y, z, f);
		renderMesh(tileentity, x, y, z, f);
		renderContents(tileentity, x, y, z, f);
	}

	
	private void renderTable(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F,(float)y + 1.5F,(float)z + 0.5F);
		GL11.glScalef(-1F, -1F, 1F);
		
		bindSieveTexture(tileentity.getBlockMetadata());
		model.simpleRender(0.0625F);
		
		GL11.glPopMatrix();
	}
	
	private void renderMesh(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F,(float)y + 0.69F,(float)z + 0.5F);
		//GL11.glScalef(-1F, -1F, 1F);
		
		bindTexture(TextureMap.locationBlocksTexture);
		mesh.render(BlockSieve.meshIcon);
		
		GL11.glPopMatrix();
	}

	private void renderContents(TileEntity tileentity, double x, double y, double z, float f)
	{
		TileEntitySieve sieve = (TileEntitySieve)tileentity;
		IIcon icon = null;
		
		switch (sieve.mode)
		{
		case FILLED:
			icon = sieve.content.getIcon(0, sieve.contentMeta);
			break;
		default:
			break;
		}

		if (sieve.mode != SieveMode.EMPTY)
		{
			bindTexture(TextureMap.locationBlocksTexture);
			
			//TOP!
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float)y + sieve.getAdjustedVolume(),(float)z + 0.5F);

			contents.renderTop(icon);

			GL11.glPopMatrix();
			
			//BOTTOM!
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float)y + 0.70f,(float)z + 0.5F);

			contents.renderBottom(icon);

			GL11.glPopMatrix();
		}
	}

	public void bindSieveTexture(int meta)
	{
		if (meta >= 0)
		{
			bindTexture(ModelSieve.textures[meta]);
		}
	}
}
