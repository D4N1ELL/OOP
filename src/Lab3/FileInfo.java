package Lab3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileInfo {
    private final String folderPath = "C:\\Users\\danie\\Desktop\\java projects\\OOPlabs\\src\\Lab3\\Test";

    public File getFile(String filename) {
        return new File(folderPath + File.separator + filename);
    }

    public String getCreatedDate(Path path) {
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime creationTime = attributes.creationTime();
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(creationTime.toMillis()));
        } catch (IOException e) {
            return "N/A";
        }
    }

}