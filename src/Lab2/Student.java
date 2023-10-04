package Lab2;
import java.util.Date;
public class Student {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
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

