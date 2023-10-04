package Lab2;

import java.util.Scanner;

public class Program {

    private Scanner scanner;
    private University university;
    private String command;

    public Program() {
        this.scanner = new Scanner(System.in);
        this.university = new University();
        this.command = "";
    }

    public void run() {
        System.out.println("Welcome to UTM student system!!");
        System.out.println("Insert one of the specified combinations for needed task or q to quit");
        System.out.println("*-----------------------------Faculty operations-----------------------------*");
        System.out.println("|1. Create Student - ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>.<month>.<year> |");
        System.out.println("|2. Graduate Student - gs/<email>                                            |");
        System.out.println("|3. Display enrolled students - ds/<faculty abbreviation>                    |");
        System.out.println("|4. Display graduates - dg/<faculty abbreviation>                            |");
        System.out.println("|5. Check if student belongs to faculty - bf/‹faculty abbreviation>/<email>  |");
        System.out.println("*-----------------------------General operations-----------------------------*");
        System.out.println("|6. Create Faculty - nf/<faculty name>/faculty abbreviation>/<field>         |");
        System.out.println("|7. search student and show faculty - ss/<student email>                     |");
        System.out.println("|8. Display Faculties - df                                                   |");
        System.out.println("|9. display all faculties of a field - dff/<field>                           |");
        System.out.println("*----------------------------------------------------------------------------*");

        while (!this.command.equals("q") ) {
            this.command = takeUserInput();

            String[] commandsList = this.command.split("/");
            switch (commandsList[0]) {
                case "nf":
                    handleFacultyCreate(commandsList);
                    break;
                case "df":
                    printFaculties();
                    break;
                case "ns":
                    handleStudentCreate(commandsList);
                    break;
                case "ds":
                    printStudents();
                    break;
                case "as":
                    assignStudentToFaculty(commandsList);
                    break;
                case "gs":
                    graduateStatus(commandsList);
                    break;
                case "dg":
                    printGraduates();
                    break;
                case "bf":
                    isBelongToFaculty(commandsList);
                    break;
                case "edit this please":
                    belongToFaculty(commandsList);
                    break;
                case "dff":
                    facultyField(commandsList);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
        scanner.close();
    }

    private String takeUserInput() {

        System.out.print("Input: ");
        return scanner.nextLine();
    }

    private void handleFacultyCreate(String[] commands) {
        if(commands.length == 4) {
            addFaculty(commands);
        } else {
            System.out.println("Input error");
        }
    }
    private void addFaculty(String[] arguments) {

        Faculty faculty = new Faculty(arguments[1], arguments[2], Studyfield.valueOf(arguments[3].toUpperCase()));
        this.university.addFaculty(faculty);
    }

    private void printFaculties() {
        System.out.println(university.toStringFaculties());
    }

    private void addStudent(String[] arguments) {
        Student student = new Student(arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]);
        this.university.addStudent(student);
    }

    private void handleStudentCreate(String[] commands) {
        if (commands.length == 6) {
            addStudent(commands);
        } else {
            System.out.println("Input error");
            return;
        }
    }

    private void printStudents(){
        System.out.println(university.toStringStudents());
    }

    private void assignStudentToFaculty(String[] arguments) {
        university.assignStudentToFaculty(arguments[1], arguments[2]);
    }

    private void graduateStatus(String[] arguments){
        university.graduateStatus(arguments[1], Boolean.valueOf(arguments[2]));
    }

    private void printGraduates(){
        System.out.println(university.toStringGraduates());
    }

    private void isBelongToFaculty(String[] arguments){
        university.isBelongToFaculty(arguments[1], arguments[2]);
    }

    private void belongToFaculty(String[] arguments) {
        university.belongToFaculty(arguments[1]);
    }

    private void facultyField(String[] arguments) {
        university.facultyField(Studyfield.valueOf(arguments[1]));
    }

}

