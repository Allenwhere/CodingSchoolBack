package service;

import domain.dto.SegmentDTO;
import domain.entity.Segment;

import java.util.Collection;

public interface SegmentService {
    SegmentDTO getById(Integer id);
    Collection<SegmentDTO> getAllSegmentOfCourse(Integer course_id);
    int save(Segment segment);
    int removeById(Integer id);
}
