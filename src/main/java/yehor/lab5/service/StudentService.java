package yehor.lab5.service;

import yehor.lab5.dao.StudentRepository;
import yehor.lab5.model.Student;

import java.sql.SQLException;
import java.time.Month;
import java.util.Comparator;
import java.util.List;

/**
 * Бізнес-логіка: з повного списку студентів, отриманого з БД,
 * на стороні Java відбираються ті, хто народився у вказаному місяці.
 */
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findBornIn(Month month) throws SQLException {
        return repository.findAll().stream()
                .filter(student -> student.birthDate().getMonth() == month)
                .sorted(Comparator.comparingInt(student -> student.birthDate().getDayOfMonth()))
                .toList();
    }

    public int countAll() throws SQLException {
        return repository.findAll().size();
    }
}
