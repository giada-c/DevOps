package ch.supsi.assignment2.view;

import ch.supsi.assignment2.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
