package yehor.lab3.controller;

import yehor.lab3.model.University;

import java.util.Random;

/**
 * Створювач найвищого рівня. Отримує кількість підрозділів на кожному рівні
 * та будує ланцюжок створювачів нижчих рівнів.
 */
public class UniversityCreator implements UnitCreator<University> {

    private static final String[] FACULTIES = {
        "Факультет інформаційних технологій",
        "Факультет природничих наук і технологій",
        "Механіко-машинобудівний факультет"
    };

    private final HumanCreator humanCreator;
    private final FacultyCreator facultyCreator;
    private final int facultiesCount;

    public UniversityCreator(int facultiesCount, int departmentsCount, int groupsCount,
                             int studentsCount) {
        this.humanCreator = new HumanCreator(new Random());
        this.facultyCreator = new FacultyCreator(humanCreator, departmentsCount, groupsCount,
                studentsCount);
        this.facultiesCount = facultiesCount;
    }

    @Override
    public University create(String name) {
        University university = new University(name, humanCreator.create());
        for (int i = 0; i < facultiesCount; i++) {
            university.addFaculty(facultyCreator.create(FACULTIES[i % FACULTIES.length]));
        }
        return university;
    }
}
