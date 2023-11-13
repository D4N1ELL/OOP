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

public class TextInfo {
    protected String getCreatedDate(Path path) {
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime creationTime = attributes.creationTime();
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(creationTime.toMillis()));
        } catch (IOException e) {
            return "N/A";
        }
    }


    protected int getLineCount(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            return lineCount;
        } catch (Exception e) {
            return 0;
        }
    }

    protected int getWordCount(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int wordCount = 0;
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            return wordCount;
        } catch (Exception e) {
            return 0;
        }
    }

    protected int getCharacterCount(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int characterCount = 0;
            while (scanner.hasNext()) {
                String word = scanner.next();
                characterCount += word.length();
            }
            return characterCount;
        } catch (Exception e) {
            return 0;
        }
    }
}
