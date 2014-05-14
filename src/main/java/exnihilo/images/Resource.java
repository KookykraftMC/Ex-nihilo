package exnihilo.images;

import net.minecraft.util.ResourceLocation;

public class Resource
{
  
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
}
