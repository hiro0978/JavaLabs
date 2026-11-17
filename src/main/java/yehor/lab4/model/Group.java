package yehor.lab4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group extends AcademicUnit {

    private List<Student> students = new ArrayList<>();

    public Group() {
    }

    public Group(String name, Human head) {
        super(name, head);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String getHeadTitle() {
        return "куратор";
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other)
                && Objects.equals(students, ((Group) other).students);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(students);
    }
}
