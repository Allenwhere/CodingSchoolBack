package service;

import domain.dto.CourseDTO;
import domain.entity.Course;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface CourseService {
    CourseDTO getById(Integer id);
    Collection<CourseDTO> getAll();
    int save(Course course);
    int removeById(Integer id);
}
