package yehor.lab4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        return super.equals(other)
                && Objects.equals(groups, ((Department) other).groups);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(groups);
    }
}
