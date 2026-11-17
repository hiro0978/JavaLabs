package yehor.lab3.model;

import java.util.ArrayList;
import java.util.List;

public class Department extends AcademicUnit {

    private List<Group> groups = new ArrayList<>();

    public Department() {
    }

    public Department(String name, Human head) {
        super(name, head);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String getHeadTitle() {
        return "завідувач";
    }
}
