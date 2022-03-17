package ch.supsi.assignment2.view;

import ch.supsi.assignment2.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    boolean existsByEmail(String email);
    Student findByEmail(String email);
}
