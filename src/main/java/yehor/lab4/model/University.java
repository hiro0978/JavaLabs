package yehor.lab4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        return super.equals(other)
                && Objects.equals(faculties, ((University) other).faculties);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(faculties);
    }
}
