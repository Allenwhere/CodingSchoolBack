package repository;

import domain.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface CourseRepository {
    Course getById(Integer id);
    Collection<Course> getAll();
    int save(Course course);
    int removeById(Integer id);
}
