package domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @ToString.Exclude
    private Integer course_id;

    @Column
    private Integer segment_num;

    @Column
    private Integer learning_page_id;

    @Column
    private String segment_name;

    @Column
    private Integer num_lesson;

    @Column
    private Integer num_quiz;

    @Column
    private Integer num_project;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Segment segment = (Segment) o;
        return id != null && Objects.equals(id, segment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
