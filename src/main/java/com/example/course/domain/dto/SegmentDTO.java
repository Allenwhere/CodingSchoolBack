package domain.dto;

import domain.entity.Segment;
import lombok.ToString;



public class SegmentDTO {
    private Integer id;

    private Integer course_id;

    private Integer segment_num;

    private Integer learning_page_id;

    private String segment_name;

    private Integer num_lesson;

    private Integer num_quiz;

    private Integer num_project;

    public SegmentDTO(Segment segment) {
        this.id = segment.getId();
        this.course_id = segment.getCourse_id();
        this.segment_num = segment.getSegment_num();
        this.learning_page_id = segment.getLearning_page_id();
        this.segment_name = segment.getSegment_name();
        this.num_lesson = segment.getNum_lesson();
        this.num_quiz = segment.getNum_quiz();
        this.num_project = segment.getNum_project();
    }

    public Integer getId() {
        return id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public Integer getSegment_num() {
        return segment_num;
    }

    public Integer getLearning_page_id() {
        return learning_page_id;
    }

    public String getSegment_name() {
        return segment_name;
    }

    public Integer getNum_lesson() {
        return num_lesson;
    }

    public Integer getNum_quiz() {
        return num_quiz;
    }

    public Integer getNum_project() {
        return num_project;
    }
}
