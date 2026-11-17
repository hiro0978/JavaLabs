package yehor.lab5;

import yehor.lab5.controller.MonthSearchController;
import yehor.lab5.dao.JdbcStudentRepository;
import yehor.lab5.db.ConnectionFactory;
import yehor.lab5.db.SchemaInitializer;
import yehor.lab5.service.StudentService;
import yehor.lab5.view.ConsoleView;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Лабораторна робота №5. Пошук студентів за місяцем народження (JDBC + H2).
 */
public class Run {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ConsoleView view = new ConsoleView();
        StudentService service =
                new StudentService(new JdbcStudentRepository(connectionFactory));
        try {
            new SchemaInitializer(connectionFactory).run();
            view.showGreeting(connectionFactory.getUrl(), service.countAll());
        } catch (SQLException e) {
            view.showMessage("Не вдалося підключитися до бази даних: " + e.getMessage());
            return;
        }
        new MonthSearchController(service, view, new Scanner(System.in)).start();
    }
}
