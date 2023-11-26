package Lab3.Test;

import Lab2.Student;
import Lab2.Studyfield;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Faculty implements Serializable{
    private String name;
    private String abbreviation;
    private List<Student> students;
    private Studyfield studyField;

    public Faculty(String name, String abbreviation, Studyfield studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", students=" + students +
                ", studyField=" + studyField +
                '}';
    }

    public void addStudent(Student student){
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Studyfield getStudyField() {
        return studyField;
    }
}
