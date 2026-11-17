package yehor.lab3.model;

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
    public String toString() {
        return super.toString() + ", залікова книжка " + gradeBookNumber;
    }
}
