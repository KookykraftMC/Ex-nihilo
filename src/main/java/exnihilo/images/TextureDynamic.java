package exnihilo.images;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import exnihilo.ExNihilo;
import exnihilo.data.ModData;
import exnihilo.registries.helpers.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

public class TextureDynamic extends TextureAtlasSprite {

  private ResourceLocation template;
  private ResourceLocation base;
  private Color color;

  public TextureDynamic(String name, ResourceLocation base, ResourceLocation template, Color color) {
    super(name);
    
    this.template = template;
    this.base = base;
    this.color = color;
  }
  
  public static String getTextureName(String name) {
    return ModData.ID + ":" + name;
  }

  @Override
  public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location) {
    //ExNihilo.log.info("Attempt to load: " + location);
    
    try 
    {
      manager.getResource(location);
    } 
    catch (Exception e) 
    {
      return true;
    }

    ExNihilo.log.info("Icon: " + template + " was overwritten by a texturepack or embedded resource.");
    return false;
  }

  // converts texture name to resource location
  public static ResourceLocation getBlockTextureLocation(String source, String name) 
  {
    int ind = name.indexOf(58);

    if (ind >= 0) {
      if (ind > 1) {
        source = name.substring(0, ind);
      }

      name = name.substring(ind + 1, name.length());
    }

    source = source.toLowerCase();
    name = "textures/blocks/" + name + ".png";
    
    return new ResourceLocation(source, name);
  }
  
//converts texture name to resource location
 public static ResourceLocation getItemTextureLocation(String source, String name) 
 {
   int ind = name.indexOf(58);

   if (ind >= 0) {
     if (ind > 1) {
       source = name.substring(0, ind);
     }

     name = name.substring(ind + 1, name.length());
   }

   source = source.toLowerCase();
   name = "textures/items/" + name + ".png";
   
   return new ResourceLocation(source, name);
 }

  // creates the textures
  // originally based on code from DenseOres, but refactored down to what you see here.
  @Override
  public boolean load(IResourceManager manager, ResourceLocation location) {
    // get mipmapping levels
    int mipmapLevels = Minecraft.getMinecraft().gameSettings.mipmapLevels;

    try {
      BufferedImage[] imgFinal = new BufferedImage[1 + mipmapLevels];
      imgFinal[0] = tryLoadImage(manager, template);
      
      if (color != null)
      {
        imgFinal[0] = ImageManipulator.Recolor(imgFinal[0], color);
      }
      
      if (this.base != null)
      {
        BufferedImage imgBase = tryLoadImage(manager, base);
        
        if (imgBase != null)
        {
          imgFinal[0] = ImageManipulator.Composite(imgBase, imgFinal[0]);
        }
      }

      // load the texture (note the null is where animation data would normally go)
      this.loadSprite(imgFinal, null, (float)Minecraft.getMinecraft().gameSettings.anisotropicFiltering > 1.0F);
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
      return true;
    }

    //ExNihilo.log.info("Succesfully generated texture for '" + this.getIconName() + "'. Place " + this.getIconName() + ".png in the assets folder to override.");
    return false;
  }
  
  //Loads an image into memory.
  private BufferedImage tryLoadImage(IResourceManager manager, ResourceLocation location)
  {
    try
    {
      IResource res = manager.getResource(location);
      BufferedImage imgOutput = ImageIO.read(res.getInputStream());
      
      return imgOutput;
    }
    catch (Exception e)
    {
      ExNihilo.log.error("Failed to load image: " + location.toString());
      return null;
    }
  }
}
