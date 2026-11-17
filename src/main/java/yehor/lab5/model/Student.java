package yehor.lab5.model;

import java.time.LocalDate;

/**
 * Запис про студента з таблиці student.
 */
public record Student(int id, String lastName, String firstName, String middleName,
                      LocalDate birthDate, String gradeBookNumber) {

    public String fullName() {
        return lastName + " " + firstName + " " + middleName;
    }
}
