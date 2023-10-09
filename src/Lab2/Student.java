package Lab2;
import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String enrollmentDate;
    private String dateOfBirth;
    private boolean isGraduated;

    public Student(String firstName, String lastName, String email, String enrollmentDate, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
        this.isGraduated = false;
    }

    public String getEmail() {
        return email;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    public void setGraduated(boolean graduated) {
        isGraduated = graduated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", isGraduated=" + isGraduated +
                '}';
    }
}
