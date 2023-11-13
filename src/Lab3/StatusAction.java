package Lab3;

import Lab3.FileAction;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class StatusAction implements FileAction {
    private Date lastSnapshotTime;
    private Set<String> lastSnapshotFiles;

    public StatusAction(Date lastSnapshotTime, Set<String> lastSnapshotFiles) {
        this.lastSnapshotTime = lastSnapshotTime;
        this.lastSnapshotFiles = lastSnapshotFiles;
    }

    @Override
    public void execute(String[] args) {
        String folderPath = "C:\\Users\\danie\\Desktop\\java projects\\OOPlabs\\src\\Lab3\\Test";
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                System.out.println("Created Snapshot at: " + lastSnapshotTime);

                Set<String> currentFiles = new HashSet<>();
                for (File file : files) {
                    Date lastModifiedTime = new Date(file.lastModified());
                    String status = "No Change";

                    if (lastModifiedTime.after(lastSnapshotTime)) {
                        status = "Changed";
                    }

                    currentFiles.add(file.getName());

                    if (!lastSnapshotFiles.contains(file.getName())) {
                        status = "New File";
                    }

                    System.out.println(file.getName() + " - " + status);
                }

                for (String fileName : lastSnapshotFiles) {
                    if (!currentFiles.contains(fileName)) {
                        System.out.println(fileName + " - Deleted File");
                    }
                }
            }
        }
    }
}
