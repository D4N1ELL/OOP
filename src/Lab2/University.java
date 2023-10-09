package Lab2;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class University implements Serializable{
    private List<Faculty> faculties = new ArrayList<>();
    private List<Student> students = new ArrayList<>();


    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public String toStringFaculties() {
        return "University{" +
                "faculties=" + faculties +
                '}';
    }

    public String toStringStudents() {
        StringBuilder text = new StringBuilder();
        for (Student student : this.students) {
            if (!student.isGraduated()) {
                text.append(student).append("\n");
            }
        }

        return text.toString();
    }

    public String toStringGraduates() {
        StringBuilder text = new StringBuilder();
        for (Student student : this.students) {
            if (student.isGraduated()) {
                text.append(student).append("\n");
            }
        }

        return text.toString();
    }

    public void assignStudentToFaculty(String email, String abbreviation) {
        for (Student student : students){
            if (student.getEmail().equals(email)) {
                for (Faculty faculty : faculties){
                    if (faculty.getAbbreviation().equals(abbreviation)) {
                        faculty.addStudent(student);
                    }
                }
            }
        }
    }

    public void graduateStatus(String email, Boolean val){
        for (Student student: students) {
            if (student.getEmail().equals(email)){
                student.setGraduated(val);
            }
        }
    }

    public void isBelongToFaculty(String email, String abbreviation) {
        for (Student student : students){
            if (student.getEmail().equals(email)){
                for (Faculty faculty : faculties){
                    if (faculty.getAbbreviation().equals(abbreviation)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    return;
                }
            }
        }
        System.out.println("No such email");
    }

    public void belongToFaculty(String email) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    System.out.println(faculty.getAbbreviation());
                }
            }
        }
    }

    public void facultyField(Studyfield field) {
        for (Faculty faculty : faculties) {
            if (faculty.getStudyField() == field) {
                System.out.println(faculty.getAbbreviation());
            }
        }
    }
}
