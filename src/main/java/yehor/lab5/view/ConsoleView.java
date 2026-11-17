package yehor.lab5.view;

import yehor.lab5.model.Student;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class ConsoleView {

    private static final Locale UA = Locale.forLanguageTag("uk-UA");
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final String LINE = "-".repeat(72);

    public void showGreeting(String url, int studentsCount) {
        System.out.println("База даних: " + url);
        System.out.println("Студентів у таблиці: " + studentsCount);
    }

    public void askMonth() {
        System.out.print("\nНомер місяця народження (1-12, 0 - вихід): ");
    }

    public void showStudents(Month month, List<Student> students) {
        String monthName = month.getDisplayName(TextStyle.FULL_STANDALONE, UA);
        if (students.isEmpty()) {
            System.out.println("Немає студентів, народжених у місяці: " + monthName);
            return;
        }
        System.out.println("Народилися у місяці \"" + monthName + "\": " + students.size());
        System.out.println(LINE);
        System.out.printf("%-3s | %-36s | %-10s | %s%n", "№", "Прізвище, ім'я, по батькові",
                "Дата нар.", "Залікова");
        System.out.println(LINE);
        for (Student s : students) {
            System.out.printf("%-3d | %-36s | %-10s | %s%n", s.id(), s.fullName(),
                    s.birthDate().format(DATE), s.gradeBookNumber());
        }
        System.out.println(LINE);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
