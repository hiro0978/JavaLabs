package yehor.lab3;

import yehor.lab3.controller.UniversityCreator;
import yehor.lab3.model.AcademicUnit;
import yehor.lab3.model.Department;
import yehor.lab3.model.Faculty;
import yehor.lab3.model.Group;
import yehor.lab3.model.Student;
import yehor.lab3.model.University;

/**
 * Лабораторна робота №3. Точка входу: створення типового університету
 * та виведення його структури з відступами за рівнями.
 */
public class Run {

    private static final String INDENT = "    ";
    private static final String UNIVERSITY_NAME =
            "Національний технічний університет «Дніпровська політехніка»";

    public static void main(String[] args) {
        University university = createTypicalUniversity();
        printStructure(university);
    }

    public static University createTypicalUniversity() {
        int faculties = 2;
        int departmentsPerFaculty = 2;
        int groupsPerDepartment = 2;
        int studentsPerGroup = 3;
        UniversityCreator creator = new UniversityCreator(faculties, departmentsPerFaculty,
                groupsPerDepartment, studentsPerGroup);
        return creator.create(UNIVERSITY_NAME);
    }

    private static void printStructure(University university) {
        System.out.println("Університет: " + describe(university));
        for (Faculty faculty : university.getFaculties()) {
            System.out.println(INDENT + describe(faculty));
            for (Department department : faculty.getDepartments()) {
                System.out.println(INDENT.repeat(2) + describe(department));
                for (Group group : department.getGroups()) {
                    System.out.println(INDENT.repeat(3) + "Група: " + describe(group));
                    int number = 1;
                    for (Student student : group.getStudents()) {
                        System.out.println(INDENT.repeat(4) + number++ + ". " + student);
                    }
                }
            }
        }
    }

    private static String describe(AcademicUnit unit) {
        return unit.getName() + " [" + unit.getHeadTitle() + ": "
                + unit.getHead().getShortName() + "]";
    }
}
