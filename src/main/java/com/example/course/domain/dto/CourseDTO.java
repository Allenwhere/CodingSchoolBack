package domain.dto;

import domain.entity.Course;

import javax.persistence.Column;

public class CourseDTO {
    private Integer id;

    private String name;

    private String about;

    private String skills;

    private Integer certificated;

    private Integer join;

    private Integer hour;

    private String pre;

    private Integer num_segment;


    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.about = course.getAbout();
        this.skills = course.getSkills();
        this.certificated = course.getCertificated();
        this.join = course.getJoin();
        this.hour = course.getHour();
        this.pre = course.getPre();
        this.num_segment = course.getNum_segment();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public String getSkills() {
        return skills;
    }

    public Integer getCertificated() {
        return certificated;
    }

    public Integer getJoin() {
        return join;
    }

    public Integer getHour() {
        return hour;
    }

    public String getPre() {
        return pre;
    }

    public Integer getNum_segment() {
        return num_segment;
    }
}
