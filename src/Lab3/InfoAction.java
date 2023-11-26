package Lab3;

import Lab3.Snapshot;
import Lab3.TextInfo;
import Lab3.PhotoInfo;
import Lab3.CodeInfo;
import Lab3.FileInfo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoAction implements FileAction {

    private final FileInfo fileInfo = new FileInfo();

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Use: info <filename>");
            return;
        }

        String filename = args[1];
        File file = fileInfo.getFile(filename);

        if (file.exists()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String extension = filename.substring(filename.lastIndexOf('.') + 1);
            String createdDate = fileInfo.getCreatedDate(file.toPath());
            String lastModifiedDate = dateFormat.format(new Date(file.lastModified()));

            if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")) {
                PhotoInfo image = new PhotoInfo(file.getName(), extension, createdDate, lastModifiedDate);
                System.out.println(image);
            } else if (extension.equals("txt")) {
                TextInfo text = new TextInfo(file.getName(), extension, createdDate, lastModifiedDate);
                System.out.println(text);
            } else if (extension.equals("py") || extension.equals("java")) {
                CodeInfo code = new CodeInfo(file.getName(), extension, createdDate, lastModifiedDate);
                System.out.println(code);
            }
        } else {
            System.out.println("File not found: " + filename);
        }

    }

}