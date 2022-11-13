package service.impl;

import domain.dto.CourseDTO;
import domain.entity.Course;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.impl.CourseRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CourseService implements service.CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDTO getById(Integer id) {
        Course c = courseRepository.getById(id);
        if(c == null) {
            throw new ResourceNotFoundException("Course for the specific id=" + id + " not found.");
        }
        return new CourseDTO(c);
    }

    @Override
    public Collection<CourseDTO> getAll() {
        return courseRepository.getAll()
                .stream()
                .map(CourseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public int save(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    @Override
    public int removeById(Integer id) {
        int result = courseRepository.removeById(id);
        if(id == -1) {
            throw new ResourceNotFoundException("Course for the specific id=" + id + " not found.");
        }
        return result;
    }
}
