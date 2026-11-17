package yehor.lab4;

import yehor.lab4.controller.UniversityCreator;
import yehor.lab4.json.JsonManager;
import yehor.lab4.model.Faculty;
import yehor.lab4.model.University;

import java.io.File;
import java.io.IOException;

/**
 * Лабораторна робота №4. Запис університету у JSON-файл, зчитування
 * та порівняння відновленого об'єкта з початковим.
 */
public class Run {

    private static final String UNIVERSITY_NAME =
            "Національний технічний університет «Дніпровська політехніка»";
    private static final File JSON_FILE = new File("university.json");

    public static void main(String[] args) throws IOException {
        JsonManager jsonManager = new JsonManager();
        University oldUniversity = createTypicalUniversity();

        jsonManager.writeToFile(oldUniversity, JSON_FILE);
        System.out.println("Збережено у файл: " + JSON_FILE.getAbsolutePath()
                + " (" + JSON_FILE.length() + " байт)");

        University newUniversity = jsonManager.readFromFile(JSON_FILE);
        System.out.println("Відновлено університет: " + newUniversity.getName());
        for (Faculty faculty : newUniversity.getFaculties()) {
            System.out.println("  " + faculty.getName() + ": кафедр - "
                    + faculty.getDepartments().size());
        }

        System.out.println("Фрагмент JSON:");
        String json = jsonManager.toJson(newUniversity);
        System.out.println(json.substring(0, Math.min(json.length(), 600)) + "\n...");

        System.out.println("oldUniversity.equals(newUniversity): "
                + oldUniversity.equals(newUniversity));
    }

    public static University createTypicalUniversity() {
        return new UniversityCreator(2, 2, 2, 3).create(UNIVERSITY_NAME);
    }
}
