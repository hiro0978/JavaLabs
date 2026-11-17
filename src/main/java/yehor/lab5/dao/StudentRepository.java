package yehor.lab5.dao;

import yehor.lab5.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {

    List<Student> findAll() throws SQLException;
}
