package Lab3;

public class StandartFile {
    String fileName;
    String extension;
    String createdDate;
    String lastModifiedDate;

    public StandartFile(String fileName, String extension, String createdDate, String lastModifiedDate) {
        this.fileName = fileName;
        this.extension = extension;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


