package Lab3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CodeInfo {
    protected String getCreatedDate(Path path) {
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime creationTime = attributes.creationTime();
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(creationTime.toMillis()));
        } catch (IOException e) {
            return "N/A";
        }
    }

    protected int getClassCount(File file) {
        int classCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.contains("public class ")) {
                    classCount++;
                }
            }
        } catch (Exception e) {
            classCount = 0;
        }
        return classCount;
    }

    protected int getMethodCount(File file) {
        int methodCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("def ") || line.startsWith("public void ")) {
                    methodCount++;
                }
            }
        } catch (Exception e) {
            methodCount = 0;
        }
        return methodCount;
    }
}
