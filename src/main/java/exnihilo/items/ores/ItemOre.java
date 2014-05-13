package exnihilo.items.ores;

import exnihilo.data.ModData;
import exnihilo.images.TextureDynamic;
import exnihilo.registries.helpers.Color;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemOre extends Item
{
  private String name;
  private ResourceLocation base;
  private ResourceLocation template;
  private Color color;
  
  public ItemOre(String name, ResourceLocation base, ResourceLocation template, Color color) {
    super();
    this.name = name;
    this.base = base;
    this.template = template;
    this.color = color;
    
    setCreativeTab(CreativeTabs.tabMaterials);
  }
  
  @Override
  public String getUnlocalizedName()
  {
    return ModData.ID + "." + name;
  }
  
  @Override
  public String getUnlocalizedName(ItemStack item)
  {
    return ModData.ID + "." + name;
  }
  
  @Override
  public void registerIcons(IIconRegister register)
  {
    if (this.base != null && this.template != null)
    {
        TextureMap map = (TextureMap) register;

        TextureAtlasSprite existing = map.getTextureExtry(name);
        if (existing == null)
        {
          TextureDynamic texture = new TextureDynamic(name, base, template, color);
          
          boolean success = map.setTextureEntry(name, texture);
          if (success)
          {
            //System.out.println("Registered icon successfully: " + name);
            this.itemIcon = map.getTextureExtry(name);
          }
        }
    }else
    {
      this.itemIcon = Items.coal.getIconFromDamage(0);
    }
  }
}
