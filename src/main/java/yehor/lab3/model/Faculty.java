package yehor.lab3.model;

import java.util.ArrayList;
import java.util.List;

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
}
