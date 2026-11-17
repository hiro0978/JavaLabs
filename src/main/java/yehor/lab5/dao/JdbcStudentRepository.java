package yehor.lab5.dao;

import yehor.lab5.db.ConnectionFactory;
import yehor.lab5.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Читає всіх студентів з таблиці student за допомогою JDBC.
 */
public class JdbcStudentRepository implements StudentRepository {

    private static final String SELECT_ALL = "SELECT id, last_name, first_name, middle_name, "
            + "birth_date, grade_book_number FROM student ORDER BY last_name";

    private final ConnectionFactory connectionFactory;

    public JdbcStudentRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> result = new ArrayList<>();
        try (Connection connection = connectionFactory.open();
             Statement statement = connection.createStatement();
             ResultSet rows = statement.executeQuery(SELECT_ALL)) {
            while (rows.next()) {
                result.add(new Student(
                        rows.getInt("id"),
                        rows.getString("last_name"),
                        rows.getString("first_name"),
                        rows.getString("middle_name"),
                        rows.getDate("birth_date").toLocalDate(),
                        rows.getString("grade_book_number")));
            }
        }
        return result;
    }
}
