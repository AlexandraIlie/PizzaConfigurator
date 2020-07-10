package de.hhn.mib.gpi2.blatt2.packageGuiSwing.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
    Class that draws the image
 */
public class ImagePanel {
    public static BufferedImage bufferedImage;

    public ImagePanel(){
        try {
            bufferedImage = ImageIO.read(new File("GpiAufgabe/src/images/pizzaboden.png"));
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(bufferedImage, 0, 0, null);
            g.dispose();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Could not find file ");
        }
    }
}
