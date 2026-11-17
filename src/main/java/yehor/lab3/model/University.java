package yehor.lab3.model;

import java.util.ArrayList;
import java.util.List;

public class University extends AcademicUnit {

    private List<Faculty> faculties = new ArrayList<>();

    public University() {
    }

    public University(String name, Human head) {
        super(name, head);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String getHeadTitle() {
        return "ректор";
    }
}
