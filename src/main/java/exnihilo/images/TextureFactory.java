package exnihilo.images;

import exnihilo.blocks.ores.BlockOre;
import exnihilo.items.ores.ItemOre;
import exnihilo.registries.helpers.Color;
import net.minecraft.util.ResourceLocation;

public class TextureFactory
{
  public static void makeTexture(BlockOre block, String name, ResourceLocation base, ResourceLocation template, Color color)
  {
    TextureDynamic texture = new TextureDynamic(name, base, template, color);
    
    block.setTexture(texture);
  }
  
  public static void makeTexture(ItemOre item, String name, ResourceLocation base, ResourceLocation template, Color color)
  {
    TextureDynamic texture = new TextureDynamic(name, base, template, color);
    
    item.setTexture(texture);
  }
}
