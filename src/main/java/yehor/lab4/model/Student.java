package yehor.lab4.model;

import java.util.Objects;

public class Student extends Human {

    private String gradeBookNumber;

    public Student() {
    }

    public Student(Human person, String gradeBookNumber) {
        super(person.getFirstName(), person.getLastName(), person.getMiddleName(),
                person.getSex());
        this.gradeBookNumber = gradeBookNumber;
    }

    public String getGradeBookNumber() {
        return gradeBookNumber;
    }

    public void setGradeBookNumber(String gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other)
                && Objects.equals(gradeBookNumber, ((Student) other).gradeBookNumber);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(gradeBookNumber);
    }
    @Override
    public String toString() {
        return super.toString() + ", залікова книжка " + gradeBookNumber;
    }
}
