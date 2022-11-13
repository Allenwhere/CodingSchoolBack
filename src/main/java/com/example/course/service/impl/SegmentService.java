package service.impl;

import domain.dto.SegmentDTO;
import domain.entity.Segment;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.impl.SegmentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SegmentService implements service.SegmentService {
    private final SegmentRepository segmentRepository;

    @Autowired
    public SegmentService(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }


    @Override
    public SegmentDTO getById(Integer id) {
        Segment s = segmentRepository.getById(id);
        if(s != null) {
            return new SegmentDTO(s);
        } else {
            throw new ResourceNotFoundException("Segment for the specific id=" + id + " not found.");
        }
    }

    @Override
    public Collection<SegmentDTO> getAllSegmentOfCourse(Integer course_id) {
        return segmentRepository.getAllSegmentOfCourse(course_id)
                .stream()
                .map(SegmentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public int save(Segment segment) {
        return segmentRepository.save(segment);
    }

    @Override
    public int removeById(Integer id) {
        int result = segmentRepository.removeById(id);
        if(result != -1) {
            return result;
        } else {
            throw new ResourceNotFoundException("Segment for the specific id=" + id + " not found.");
        }
    }
}
