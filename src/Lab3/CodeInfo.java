package Lab3;

import java.io.File;
import java.util.Scanner;

public class CodeInfo {
    protected static int getLineCount(File file) {
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


    protected static int getClassCount(File file) {
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

    protected static int getMethodCount(File file) {
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
