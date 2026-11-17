package yehor.lab3.controller;

import yehor.lab3.model.Student;

/**
 * Створює студентів. Номер залікової книжки формується з назви групи
 * та порядкового номера студента в ній.
 */
public class StudentCreator {

    private final HumanCreator humanCreator;

    public StudentCreator(HumanCreator humanCreator) {
        this.humanCreator = humanCreator;
    }

    public Student create(String groupName, int numberInGroup) {
        String gradeBookNumber = groupName + "/" + String.format("%02d", numberInGroup);
        return new Student(humanCreator.create(), gradeBookNumber);
    }
}
