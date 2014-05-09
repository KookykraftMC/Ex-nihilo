package exnihilo.blocks.ores;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import exnihilo.ExNihilo;
import exnihilo.data.ModData;
import exnihilo.registries.helpers.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

///This class has been copied from DenseOres which in turn was mostly copied from the 
/// vanilla class TextureAtlasSprite. Thats why there are all these incredibly short variable names.
/// Refactoring to commence ASAP. - Crowley
public class TextureOre extends TextureAtlasSprite {

  private String template;
  private String base;
  private Color color;

  public TextureOre(String template, String base, Color color) {
    super(getTextureName(template));
    
    this.template = template;
    this.base = base;
    this.color = color;
  }
  
  public static String getTextureName(String blockName) {
    return ModData.ID + ":" + blockName + "_texture";
  }

  @Override
  public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location) {
    try 
    {
      manager.getResource(location);
    } 
    catch (Exception e) 
    {
      return true;
    }

    ExNihilo.log.info("Ore icon: " + template + " was overwritten by a texturepack or embedded resource.");
    return false;
  }

  // converts texture name to resource location
  public ResourceLocation getTextureLocation(String s2) {
    String s1 = "minecraft";

    int ind = s2.indexOf(58);

    if (ind >= 0) {
      if (ind > 1) {
        s1 = s2.substring(0, ind);
      }

      s2 = s2.substring(ind + 1, s2.length());
    }

    s1 = s1.toLowerCase();
    s2 = "textures/blocks/" + s2 + ".png";
    
    return new ResourceLocation(s1, s2);
  }

  // loads the textures
  // originally based on code from DenseOres, but refactored down to what you see here.
  @Override
  public boolean load(IResourceManager manager, ResourceLocation location) {
    // get mipmapping levels
    int mipmapLevels = Minecraft.getMinecraft().gameSettings.mipmapLevels;

    try {
      IResource resTemplate = manager.getResource(getTextureLocation(template));

      BufferedImage[] imgFinal = new BufferedImage[1 + mipmapLevels];
      BufferedImage imgTemplate = ImageIO.read(resTemplate.getInputStream());
      
      imgFinal[0] = ImageManipulator.Recolor(imgTemplate, color);
      
      if (this.base != null)
      {
        IResource resBase = manager.getResource(getTextureLocation(base));
        BufferedImage imgBase = ImageIO.read(resBase.getInputStream());
        
        if (imgBase != null)
        {
          imgFinal[0] = ImageManipulator.Composite(imgBase, imgFinal[0]);
        }
      }

      // load the texture (note the null is where animation data would normally go)
      this.loadSprite(imgFinal, null, (float) Minecraft.getMinecraft().gameSettings.anisotropicFiltering > 1.0F);
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
      return true;
    }

    ExNihilo.log.info("ExNihilo: Succesfully generated ore texture for '" + template + "' with background '" + base + "'. Place " + template + "_texture.png in the assets folder to override.");
    return false;
  }
}
