package exnihilo.items.ores;

import exnihilo.data.ModData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemOre extends Item
{
  private String name;
  private TextureAtlasSprite texture;
  
  public ItemOre(String name, TextureAtlasSprite texture) {
    super();
    this.name = name;
    this.texture = texture;
    
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
    if(this.texture != null)
    {
      TextureMap map = (TextureMap) register;

      TextureAtlasSprite existing = map.getTextureExtry(texture.getIconName());
      if (existing == null)
      {
        boolean success = map.setTextureEntry(texture.getIconName(), texture);
        if (success)
        {
          //System.out.println("Registered icon successfully: " + texture.getIconName());
          this.itemIcon = map.getTextureExtry(texture.getIconName());
        }else
        {
          this.itemIcon = Items.coal.getIconFromDamage(0);
        }
      }
    }
  }
}
