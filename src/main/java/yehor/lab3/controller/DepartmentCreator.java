package yehor.lab3.controller;

import yehor.lab3.model.Department;

public class DepartmentCreator implements UnitCreator<Department> {

    private static final String ADMISSION_YEAR = "23";

    private final HumanCreator humanCreator;
    private final GroupCreator groupCreator;
    private final int groupsCount;

    public DepartmentCreator(HumanCreator humanCreator, int groupsCount, int studentsCount) {
        this.humanCreator = humanCreator;
        this.groupCreator = new GroupCreator(humanCreator, studentsCount);
        this.groupsCount = groupsCount;
    }

    @Override
    public Department create(String name) {
        return create(name, "000");
    }

    /**
     * Створює кафедру, групи якої називаються за шифром спеціальності,
     * наприклад 124-23-1, 124-23-2.
     */
    public Department create(String name, String specialtyCode) {
        Department department = new Department(name, humanCreator.create());
        for (int i = 1; i <= groupsCount; i++) {
            String groupName = specialtyCode + "-" + ADMISSION_YEAR + "-" + i;
            department.addGroup(groupCreator.create(groupName));
        }
        return department;
    }
}
