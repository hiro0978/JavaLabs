package yehor.lab4.controller;

import yehor.lab4.model.Faculty;

public class FacultyCreator implements UnitCreator<Faculty> {

    /** Назви кафедр та шифри спеціальностей, які вони випускають. */
    private static final String[][] DEPARTMENTS = {
        {"Кафедра системного аналізу та управління", "124"},
        {"Кафедра програмного забезпечення комп'ютерних систем", "121"},
        {"Кафедра безпеки інформації та телекомунікацій", "125"},
        {"Кафедра інформаційних технологій та комп'ютерної інженерії", "123"},
        {"Кафедра прикладної математики", "113"},
        {"Кафедра економічної кібернетики", "051"}
    };

    private final HumanCreator humanCreator;
    private final DepartmentCreator departmentCreator;
    private final int departmentsCount;
    private int nextDepartment;

    public FacultyCreator(HumanCreator humanCreator, int departmentsCount, int groupsCount,
                          int studentsCount) {
        this.humanCreator = humanCreator;
        this.departmentCreator =
                new DepartmentCreator(humanCreator, groupsCount, studentsCount);
        this.departmentsCount = departmentsCount;
    }

    @Override
    public Faculty create(String name) {
        Faculty faculty = new Faculty(name, humanCreator.create());
        for (int i = 0; i < departmentsCount; i++) {
            String[] department = DEPARTMENTS[nextDepartment++ % DEPARTMENTS.length];
            faculty.addDepartment(departmentCreator.create(department[0], department[1]));
        }
        return faculty;
    }
}
