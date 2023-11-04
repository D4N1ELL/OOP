package Lab2;
import java.io.File;
import java.util.Date;

public class CommitAction extends FileAction {
    private Date snapshotTime;

    public CommitAction() {
        snapshotTime = new Date();
    }

    @Override
    public void execute(String[] args) {
        snapshotTime = new Date();
        System.out.println("Snapshot time updated to: " + snapshotTime);
    }

    public Date getSnapshotTime() {
        return snapshotTime;
    }
}