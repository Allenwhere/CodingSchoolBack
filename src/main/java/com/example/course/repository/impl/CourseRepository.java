package repository.impl;

import domain.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class CourseRepository implements repository.CourseRepository {
    @Autowired
    private EntityManager em;

    @Override
    public Course getById(Integer id) {
        return em.find(Course.class,id);
    }

    @Override
    public Collection<Course> getAll() {
        Query query = em.createQuery("select c from course c");
        return query.getResultList();
    }

    @Override
    public int save(Course course) {
        Course c = em.merge(course);
        return c.getId();
    }

    @Override
    public int removeById(Integer id) {
        Course c = getById(id);
        if(c == null) {
            return -1;
        }
        em.remove(c);
        return id;
    }
}
