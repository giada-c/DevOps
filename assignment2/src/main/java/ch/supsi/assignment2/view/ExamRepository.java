package ch.supsi.assignment2.view;

import ch.supsi.assignment2.model.Exam;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Long> {
}
