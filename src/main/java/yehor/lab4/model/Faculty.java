package yehor.lab4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty extends AcademicUnit {

    private List<Department> departments = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public String getHeadTitle() {
        return "декан";
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other)
                && Objects.equals(departments, ((Faculty) other).departments);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(departments);
    }
}
