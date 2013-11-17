package exnihilo.blocks.renderers;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.models.ModelBlock;
import exnihilo.blocks.tileentities.TileEntityLeavesInfested;
import exnihilo.registries.helpers.Color;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

public class RenderLeaves extends TileEntitySpecialRenderer{
	private ModelBlock model;
	
	public RenderLeaves(ModelBlock model)
	{
		this.model = model;
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) 
	{
		TileEntityLeavesInfested leaves = (TileEntityLeavesInfested) tileentity;
		
		GL11.glPushMatrix();
		GL11.glTranslated(x,y,z);
		
		bindTexture(TextureMap.locationBlocksTexture);
		int brightness = Block.leaves.getMixedBrightnessForBlock(tileentity.worldObj, tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
		
		model.render(leaves.getRenderColor(), Block.leaves.getIcon(0, leaves.getBlockMetadata()), Block.leaves, brightness, true);

		GL11.glPopMatrix();
	}
}
