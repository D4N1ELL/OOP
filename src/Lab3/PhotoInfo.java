package Lab3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PhotoInfo extends StandartFile{
    private final FileInfo fileInfo = new FileInfo();
    File file = fileInfo.getFile(fileName);
    String dimension;

    protected String getImageDimensions() {
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            return width + "x" + height;
        } catch (IOException e) {
            return "N/A";
        }
    }

    public PhotoInfo(String imageName, String extension, String createdDate, String lastModifiedDate) {
        super(imageName, extension, createdDate, lastModifiedDate);
        this.dimension = getImageDimensions();
    }


    @Override
    public String toString() {
        return "Image name: " + fileName + "\n" +
                "Extension: " + extension + "\n" +
                "Created date: " + createdDate + "\n" +
                "Last modified date: " + lastModifiedDate + "\n" +
                "Dimension: " + dimension + "\n";
    }
}
