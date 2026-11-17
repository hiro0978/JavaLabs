package yehor.lab4.controller;

import yehor.lab4.model.Group;

public class GroupCreator implements UnitCreator<Group> {

    private final HumanCreator humanCreator;
    private final StudentCreator studentCreator;
    private final int studentsCount;

    public GroupCreator(HumanCreator humanCreator, int studentsCount) {
        this.humanCreator = humanCreator;
        this.studentCreator = new StudentCreator(humanCreator);
        this.studentsCount = studentsCount;
    }

    @Override
    public Group create(String name) {
        Group group = new Group(name, humanCreator.create());
        for (int i = 1; i <= studentsCount; i++) {
            group.addStudent(studentCreator.create(name, i));
        }
        return group;
    }
}
