package exnihilo.blocks.ores;

import java.awt.image.BufferedImage;

import exnihilo.registries.helpers.Color;


public class ImageManipulator
{
  //Recolors an image based on the input color
  public static BufferedImage Recolor(BufferedImage template, exnihilo.registries.helpers.Color color)
  {
    //TODO
    //Actually perform the color blending. Probably using HSV color model.
    //For now, just pass the unmolested template on for further processing.
    return template;
  }
  
  //Combines two images and returns the composite.
  public static BufferedImage Composite(BufferedImage imgBackground, BufferedImage imgForeground)
  {
    int w = imgBackground.getWidth();
    int h = imgBackground.getHeight();

    // create an output image that we will use to override
    BufferedImage imgOutput = new BufferedImage(w, h, imgBackground.getType());

    int[] backgroundData = new int[w * h];
    int[] foregroundData = new int[w * h];
    int[] outputData = new int[w * h];

    // read the rgb color data into our array
    imgBackground.getRGB(0, 0, w, h, backgroundData, 0, w);
    imgForeground.getRGB(0, 0, w, h, foregroundData, 0, w);
    
    // 'over' blend each pixel
    for (int i = 0; i < backgroundData.length; i++) {
      Color colorBackground = new Color(backgroundData[i]);
      Color colorForeground = new Color(foregroundData[i], false);
      
      //Debug code!
      //System.out.println("Background pixel r:" + colorBackground.r + ", g:" +  colorBackground.g + ", b:" + colorBackground.b + ", a:" +  colorBackground.a);
      //System.out.println("Foreground pixel r:" + colorForeground.r + ", g:" +  colorForeground.g + ", b:" + colorForeground.b + ", a:" +  colorForeground.a);

      outputData[i] = backgroundData[i];
      
      if (colorForeground.a > 0)
      {
        float alpha = colorForeground.a;
        
        float a = colorBackground.a;
        float r = (colorForeground.r * alpha) + (colorBackground.r) * (1.0f - alpha);
        float g = (colorForeground.g * alpha) + (colorBackground.g) * (1.0f - alpha);
        float b = (colorForeground.b * alpha) + (colorBackground.b) * (1.0f - alpha);
        
        //System.out.println("Blended pixel r:" + r + ", g:" +  g + ", b:" + b + ", a:" +  a);
        outputData[i] = (new Color(r, g, b, a).toInt());
      }else
      {
        outputData[i] = backgroundData[i];
      }
    }

    // write the new image data to the output image buffer
    imgOutput.setRGB(0, 0, w, h, outputData, 0, w);
    
    return imgOutput;
  }
}
