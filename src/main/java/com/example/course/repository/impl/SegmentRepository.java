package repository.impl;

import domain.entity.Course;
import domain.entity.Segment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class SegmentRepository implements repository.SegmentRepository {
    @Autowired
    private EntityManager em;

    @Override
    public Segment getById(Integer id) {
        return em.find(Segment.class,id);
    }

    @Override
    public Collection<Segment> getAllSegmentOfCourse(Integer course_id) {
        Query query = em.createQuery("select c from segment c where c.course_id = :courseId");
        return query.setParameter("courseId", course_id).getResultList();
    }

    @Override
    public int save(Segment segment) {
        Segment s = em.merge(segment);
        return s.getId();
    }

    @Override
    public int removeById(Integer id) {
        Segment s = getById(id);
        if(s == null) {
            return -1;
        }
        em.remove(s);
        return id;
    }
}
