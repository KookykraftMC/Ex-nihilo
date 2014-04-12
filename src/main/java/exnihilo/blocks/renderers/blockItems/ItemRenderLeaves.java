package exnihilo.blocks.renderers.blockItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.models.ModelBlock;
import exnihilo.registries.helpers.Color;

public class ItemRenderLeaves implements IItemRenderer{
	private ModelBlock model;

	public ItemRenderLeaves(ModelBlock model)
	{
		this.model = model;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type)
		{
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		//case FIRST_PERSON_HOLDING:
			//System.out.println("HOLDING");
			//return false;
		case FIRST_PERSON_MAP:
			//System.out.println("MAP");
			return false;
		case INVENTORY:
			break;
		}
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (type)
		{
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		//case FIRST_PERSON_HOLDING:
			//System.out.println("HOLDING");
			//return false;
		case FIRST_PERSON_MAP:
			//System.out.println("MAP");
			return false;
		case INVENTORY:
			break;
		}
		
		switch (helper)
		{
		case BLOCK_3D:
			break;
		case ENTITY_BOBBING:
			break;
		case ENTITY_ROTATION:
			break;
		case EQUIPPED_BLOCK:
			break;
//		case HOLD_BACKGROUND:
//			return false;
//		case HOLD_HANDS:
//			return false;
//			//break;
		case INVENTORY_BLOCK:
			break;
		default:
			break;
		
		}
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		boolean blend = false;
		
		GL11.glPushMatrix();
		//GL11.glScalef(-1F, -1F, 1F);
		
		switch (type)
		{
		case EQUIPPED:
			//GL11.glTranslatef(-0.5F, -1.5F, 0.5F);
			break;
		
		case EQUIPPED_FIRST_PERSON:
			//GL11.glTranslatef(0F, -1.6F, 0.6F);
			break;
			
		case ENTITY:
			//GL11.glTranslatef(0F, -1.0F, 0F);
			break;
			
		case INVENTORY:
			//GL11.glTranslatef(0F, -1.0F, 0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			blend = true;
			break;
			
		default:
			GL11.glTranslatef(0F, 0F, 0F);
			break;
		}
		
		bindTexture();
		
		model.render(new Color(Blocks.leaves.getRenderColor(item.getItemDamage())),
				Blocks.leaves.getIcon(0, item.getItemDamage()),
				Integer.MAX_VALUE,
				blend);
		
		GL11.glPopMatrix();
	}
	
	protected void bindTexture()
    {
        TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();

        if (texturemanager != null)
        {
    			texturemanager.bindTexture(TextureMap.locationBlocksTexture);
        }
    }
}
