package repository;

import domain.entity.Segment;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SegmentRepository {
    Segment getById(Integer id);
    Collection<Segment> getAllSegmentOfCourse(Integer course_id);
    int save(Segment segment);
    int removeById(Integer id);
}
