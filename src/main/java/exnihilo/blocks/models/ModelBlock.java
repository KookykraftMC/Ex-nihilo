package exnihilo.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;

import exnihilo.registries.helpers.Color;

public class ModelBlock extends ModelBase{

	public void render(Color color, IIcon icon, int brightness, boolean blend)
	{
		Tessellator tessellator = Tessellator.instance;

		GL11.glDisable(GL11.GL_LIGHTING);
		
		if (blend == true)
		{
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		}

		double minU = (double)icon.getMinU();
		double maxU = (double)icon.getMaxU();
		double minV = (double)icon.getMinV();
		double maxV = (double)icon.getMaxV();

		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(color.r, color.g, color.b, color.a);
		
		DrawTop(tessellator, minU, maxU, minV, maxV, brightness);
		DrawSide1(tessellator, minU, maxU, minV, maxV, brightness);
		DrawSide2(tessellator, minU, maxU, minV, maxV, brightness);
		DrawSide3(tessellator, minU, maxU, minV, maxV, brightness);
		DrawSide4(tessellator, minU, maxU, minV, maxV, brightness);
		DrawBottom(tessellator, minU, maxU, minV, maxV, brightness);
		
		tessellator.draw();
		
		if (blend == true)
		{
			GL11.glDisable(GL11.GL_BLEND);
		}
		
		GL11.glEnable(GL11.GL_LIGHTING);
	}
	
	public void DrawTop(Tessellator tessellator, double minU, double maxU, double minV, double maxV, int brightness)
	{
		tessellator.setBrightness(brightness);
		tessellator.addVertexWithUV(0, 1, 0, minU, minV);
		tessellator.addVertexWithUV(0, 1, 1, minU, maxV);
		tessellator.addVertexWithUV(1, 1, 1, maxU, maxV);
		tessellator.addVertexWithUV(1, 1, 0, maxU, minV);
	}
	
	public void DrawSide1(Tessellator tessellator, double minU, double maxU, double minV, double maxV, int brightness)
	{
		tessellator.setBrightness(brightness);
		tessellator.addVertexWithUV(0, 0, 0, maxU, maxV);
		tessellator.addVertexWithUV(0, 1, 0, maxU, minV);
		tessellator.addVertexWithUV(1, 1, 0, minU, minV);
		tessellator.addVertexWithUV(1, 0, 0, minU, maxV);
	}
	
	public void DrawSide2(Tessellator tessellator, double minU, double maxU, double minV, double maxV, int brightness)
	{
		tessellator.setBrightness(brightness);		
		tessellator.addVertexWithUV(1, 0, 0, maxU, maxV);
		tessellator.addVertexWithUV(1, 1, 0, maxU, minV);
		tessellator.addVertexWithUV(1, 1, 1, minU, minV);
		tessellator.addVertexWithUV(1, 0, 1, minU, maxV);
	}
	
	public void DrawSide3(Tessellator tessellator, double minU, double maxU, double minV, double maxV, int brightness)
	{
		tessellator.setBrightness(brightness);
		tessellator.addVertexWithUV(1, 0, 1, maxU, maxV);
		tessellator.addVertexWithUV(1, 1, 1, maxU, minV);
		tessellator.addVertexWithUV(0, 1, 1, minU, minV);
		tessellator.addVertexWithUV(0, 0, 1, minU, maxV);
	}
	
	public void DrawSide4(Tessellator tessellator, double minU, double maxU, double minV, double maxV, int brightness)
	{
		tessellator.setBrightness(brightness);
		tessellator.addVertexWithUV(0, 0, 1, maxU, maxV);
		tessellator.addVertexWithUV(0, 1, 1, maxU, minV);
		tessellator.addVertexWithUV(0, 1, 0, minU, minV);
		tessellator.addVertexWithUV(0, 0, 0, minU, maxV);
	}
	
	public void DrawBottom(Tessellator tessellator, double minU, double maxU, double minV, double maxV, int brightness)
	{
		tessellator.setBrightness(brightness);		
		tessellator.addVertexWithUV(0, 0, 1, minU, maxV);
		tessellator.addVertexWithUV(0, 0, 0, minU, minV);
		tessellator.addVertexWithUV(1, 0, 0, maxU, minV);
		tessellator.addVertexWithUV(1, 0, 1, maxU, maxV);
	}
}
