package yehor.lab5.controller;

import yehor.lab5.service.StudentService;
import yehor.lab5.view.ConsoleView;

import java.sql.SQLException;
import java.time.Month;
import java.util.Scanner;

/**
 * Діалог з користувачем: зчитує номер місяця і показує студентів.
 */
public class MonthSearchController {

    private static final int EXIT = 0;

    private final StudentService service;
    private final ConsoleView view;
    private final Scanner scanner;

    public MonthSearchController(StudentService service, ConsoleView view, Scanner scanner) {
        this.service = service;
        this.view = view;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            view.askMonth();
            if (!scanner.hasNextLine()) {
                return;
            }
            String input = scanner.nextLine().trim();
            int number;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                view.showMessage("Помилка: потрібно ввести ціле число.");
                continue;
            }
            if (number == EXIT) {
                view.showMessage("Роботу програми завершено.");
                return;
            }
            if (number < 1 || number > 12) {
                view.showMessage("Місяць має бути від 1 до 12.");
                continue;
            }
            search(Month.of(number));
        }
    }

    private void search(Month month) {
        try {
            view.showStudents(month, service.findBornIn(month));
        } catch (SQLException e) {
            view.showMessage("Помилка запиту до БД: " + e.getMessage());
        }
    }
}
