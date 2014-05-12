package exnihilo.blocks.ores;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.registries.helpers.Color;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class BlockOre
    extends BlockSand
{
  private String name;
  private IIcon icon;
  private ResourceLocation base;
  private ResourceLocation template;
  private Color color;

  public BlockOre(String name, TextureOre texture)
  {
    super();
    this.name = name;
  }

  public BlockOre(String name, ResourceLocation base, ResourceLocation template, Color color)
  {
    super();
    this.name = name;

    this.base = base;
    this.template = template;
    this.color = color;
  }

  @SuppressWarnings({
      "unchecked", "rawtypes"
  })
  @Override
  @SideOnly(Side.CLIENT)
  public void getSubBlocks(Item item, CreativeTabs tabs, List items)
  {
    items.add(new ItemStack(item, 1, 0));
  }

  @SideOnly(Side.CLIENT)
  @Override
  public void registerBlockIcons(IIconRegister register)
  {
    if (this.base != null && this.template != null)
    {
        TextureMap map = (TextureMap) register;

        TextureAtlasSprite existing = map.getTextureExtry(name);
        if (existing == null)
        {
          TextureOre texture = new TextureOre(name, base, template, color);
          
          boolean success = map.setTextureEntry(name, texture);
          if (success)
          {
            System.out.println("Registered icon successfully: " + name);
            this.icon = map.getTextureExtry(name);
          }
        }
    }
  }

  @SideOnly(Side.CLIENT)
  @Override
  public IIcon getIcon(int id, int meta)
  {
    if (this.icon != null)
    {
      return this.icon;
    }

    return Blocks.stone.getIcon(id, meta);
  }

  public String getName()
  {
    return name;
  }
}
