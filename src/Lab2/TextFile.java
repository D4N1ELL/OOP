package Lab2;
import Lab2.University;
import java.io.*;

public class TextFile {

    public void saveUniversityToFile(University university) {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/Lab2/Data/Catalog.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(university);
            out.close();
            fileOut.close();
            System.out.println("Saved");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("NO FILE FOUND");
        } catch (IOException ioException) {
            System.out.println("IO EXCEPTION");
        }
    }
    public University getUniversityFromFile() {
        University university = new University();
        try {
            FileInputStream fileIn = new FileInputStream("src/Lab2/Data/Catalog.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            university = (University) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("File Loaded Successfully");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("University Class NOT FOUND");
        } catch (IOException ioException) {
            System.out.println("IO EXCEPTION");
        }
        return university;
    }
}
