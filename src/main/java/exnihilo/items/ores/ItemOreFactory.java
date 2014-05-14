package exnihilo.items.ores;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import exnihilo.images.TextureDynamic;
import exnihilo.registries.helpers.Color;

public class ItemOreFactory
{
  public static ItemOre[] MakeOverworldOreItems(String name, Color color)
  {
    List<ItemOre> items = new ArrayList<ItemOre>();
    
    //Make gravel;
    ItemOre broken = MakeOverworldBrokenOre(name, color);
    items.add(broken);
    
    //Make sand;
    ItemOre crushed = MakeCrushedOre(name, color);
    items.add(crushed);
    
    //Make dust;
    ItemOre pulverized = MakePulverizedOre(name, color);
    items.add(pulverized);
    
    //Make dust;
    ItemOre ingot = MakeIngot(name, color);
    items.add(ingot);
    
    ItemOre[] itemArray = new ItemOre[items.size()];
    items.toArray(itemArray);
    
    return items.toArray(itemArray);
  }
  
  public static ItemOre MakeOverworldBrokenOre(String name, Color color)
  {
    String texture_name = "ItemBroken" + formatName(name);
    String item_name = "ore_broken_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureDynamic.getItemTextureLocation("exnihilo", "ItemBrokenBase");
    ResourceLocation templateTexture = TextureDynamic.getItemTextureLocation("exnihilo", "ItemBrokenTemplate");
    
    TextureDynamic texture = new TextureDynamic(texture_name, baseTexture, templateTexture, color);
    ItemOre broken = new ItemOre(item_name, texture);
    
    return broken;
  }
  
  public static ItemOre MakeCrushedOre(String name, Color color)
  {
    String texture_name = "ItemCrushed" + formatName(name);
    String item_name = "ore_crushed_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureDynamic.getItemTextureLocation("exnihilo", "ItemCrushedBase");
    ResourceLocation templateTexture = TextureDynamic.getItemTextureLocation("exnihilo", "ItemCrushedTemplate");
    
    TextureDynamic texture = new TextureDynamic(texture_name, baseTexture, templateTexture, color);
    ItemOre crushed = new ItemOre(item_name, texture);
    
    return crushed;
  }
  
  public static ItemOre MakePulverizedOre(String name, Color color)
  {
    String texture_name = "ItemPowdered" + formatName(name);
    String item_name = "ore_powdered_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureDynamic.getItemTextureLocation("exnihilo", "ItemPowderedBase");
    ResourceLocation templateTexture = TextureDynamic.getItemTextureLocation("exnihilo", "ItemPowderedTemplate");
    
    TextureDynamic texture = new TextureDynamic(texture_name, baseTexture, templateTexture, color);
    ItemOre pulverized = new ItemOre(item_name, texture);
    
    return pulverized;
  }
  
  public static ItemOre MakeIngot(String name, Color color)
  {
    String texture_name = "ItemIngot" + formatName(name);
    String item_name = "ore_ingot_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureDynamic.getItemTextureLocation("exnihilo", "ItemIngotBase");
    ResourceLocation templateTexture = TextureDynamic.getItemTextureLocation("exnihilo", "ItemIngotTemplate");
    
    TextureDynamic texture = new TextureDynamic(texture_name, baseTexture, templateTexture, color);
    ItemOre ingot = new ItemOre(item_name, texture);
    
    return ingot;
  }
  
  private static String formatName(String input)
  {
    String lcase = input.toLowerCase();
    
    String output = lcase.substring(0, 1).toUpperCase() + lcase.substring(1);
    
    return output;
  }
}
