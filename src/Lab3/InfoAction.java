package Lab3;

import Lab3.Snapshot;
import Lab3.TextInfo;
import Lab3.PhotoInfo;
import Lab3.CodeInfo;
import Lab3.FileInfo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InfoAction implements FileAction {
    private final String folderPath = "C:\\Users\\danie\\Desktop\\java projects\\OOPlabs\\src\\Lab3\\Test";

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Use: info <filename>");
            return;
        }

        String filename = args[1];
        File file = new File(folderPath + File.separator + filename);

        if (file.exists()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String extension = filename.substring(filename.lastIndexOf('.') + 1);

            System.out.println("File Name: " + file.getName());
            System.out.println("Extension: " + extension);
            String createdDate = FileInfo.getCreatedDate(Path.of(folderPath));
            System.out.println("Created Date: " + createdDate);
            System.out.println("Last Modified Date: " + dateFormat.format(new Date(file.lastModified())));

            if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")) {
                String imageSize = PhotoInfo.getImageDimensions(file);
                System.out.println("Image Size: " + imageSize);
            } else if (extension.equals("txt")) {
                int lineCount = TextInfo.getLineCount(file);
                int wordCount = TextInfo.getWordCount(file);
                int characterCount = TextInfo.getCharacterCount(file);
                System.out.println("Line Count: " + lineCount);
                System.out.println("Word Count: " + wordCount);
                System.out.println("Character Count: " + characterCount);
            } else if (extension.equals("py") || extension.equals("java")) {
                int lineCount = CodeInfo.getLineCount(file);
                int classCount = CodeInfo.getClassCount(file);
                int methodCount = CodeInfo.getMethodCount(file);
                System.out.println("Line Count: " + lineCount);
                System.out.println("Class Count: " + classCount);
                System.out.println("Method Count: " + methodCount);
            }
        } else {
            System.out.println("File not found: " + filename);
        }
    }

}