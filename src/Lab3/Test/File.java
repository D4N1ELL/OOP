package Lab3.Test;

public interface File {
    int getLineCount(java.io.File file);
    int getWordCount(java.io.File file);
    int getCharacterCount(java.io.File file);
    int getClassCount(java.io.File file);
    int getMethodCount(java.io.File file);
    String getImageDimensions(java.io.File file);
}
