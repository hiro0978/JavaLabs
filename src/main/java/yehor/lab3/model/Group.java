package yehor.lab3.model;

import java.util.ArrayList;
import java.util.List;

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
}
