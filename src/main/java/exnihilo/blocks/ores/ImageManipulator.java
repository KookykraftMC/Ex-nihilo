package exnihilo.blocks.ores;

import java.awt.image.BufferedImage;

import exnihilo.registries.helpers.Color;

public class ImageManipulator
{
  //Recolors an image based on the input color
  public static BufferedImage Recolor(BufferedImage template, Color color)
  {
    
    
    return null;
  }
  
  //Combines two images and returns the composite.
  public static BufferedImage Composite(BufferedImage layer0, BufferedImage layer1)
  {
    int w = layer0.getWidth();

    // create an output image that we will use to override
    BufferedImage imgOutput = new BufferedImage(w, w, layer0.getType());

    int[] layer0Data = new int[w * w];
    int[] layer1Data = new int[w * w];
    int[] outputData = new int[w * w];

    // read the rgb color data into our array
    layer0.getRGB(0, 0, w, w, layer0Data, 0, layer0.getWidth());
    layer1.getRGB(0, 0, imgOutput.getWidth(), imgOutput.getWidth(), layer1Data, 0, imgOutput.getWidth());

    // check to see which pixels are different
    boolean[] same = new boolean[w * w];
    for (int i = 0; i < layer1Data.length; i += 1) {
      same[i] = layer1Data[i] == layer0Data[i];
      outputData[i] = layer1Data[i];
    }

    int dx[] = new int[] { -1, 2, 3 };
    int dy[] = new int[] { -1, 0, 1 };

    // where the magic happens
    for (int i = 0; i < layer1Data.length; i += 1) {
      int x = (i % w);
      int y = (i - x) / w;

      // if a pixel is part of the stone texture it should change if
      // possible
      boolean shouldChange = same[i];

      // compare the pixel to its shifted counterparts and change it
      // if the rotated pixel
      // is 'different' from the stone texture and is either brighter
      // or the original pixel
      // was marked as 'shouldChange'.

      for (int j = 0; j < dx.length; j++) {
        if ((x + dx[j]) >= 0 && (x + dx[j]) < w && (y + dy[j]) >= 0 && (y + dy[j]) < w)
          if (!same[(x + dx[j]) + (y + dy[j]) * w] && (shouldChange
              // || lum(new_data[i]) > lum(ore_data[(x +
              // dx[j]) + (y +
              // dy[j]) * w])
              )) {
            shouldChange = false;
            outputData[i] = layer1Data[(x + dx[j]) + (y + dy[j]) * w];
          }
      }

    }

    // write the new image data to the output image buffer
    imgOutput.setRGB(0, 0, imgOutput.getWidth(), imgOutput.getHeight(), outputData, 0, imgOutput.getWidth());
    
    return imgOutput;
  }
}
