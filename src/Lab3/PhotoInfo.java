package Lab3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PhotoInfo {
    protected static String getImageDimensions(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            return width + "x" + height;
        } catch (IOException e) {
            return "N/A";
        }
    }

    protected static int getImageSize(File file) {
        return (int) file.length();
    }
}
