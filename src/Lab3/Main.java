package Lab3;

import Lab3.Snapshot;

import java.io.File;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CommitAction commitAction = new CommitAction();
        Set<String> lastSnapshotFiles = new HashSet<>();

        String folderPath = "C:\\Users\\danie\\Desktop\\java projects\\OOPlabs\\src\\Lab3\\Test";
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("*---------Git Actions---------*");
        System.out.println("|1. commit                    |");
        System.out.println("|2. info <filename>           |");
        System.out.println("|3. status                    |");
        System.out.println("|4. quit                      |");
        System.out.println("*-----------------------------*");

        while (running) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "commit":
                    commitAction.execute(parts);
                    lastSnapshotFiles = Snapshot.getSnapshotFiles(folder);
                    break;
                case "info":
                    InfoAction infoAction = new InfoAction();
                    infoAction.execute(parts);
                    break;
                case "status":
                    StatusAction statusAction = new StatusAction(commitAction.getSnapshotTime(), lastSnapshotFiles);
                    statusAction.execute(parts);
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}