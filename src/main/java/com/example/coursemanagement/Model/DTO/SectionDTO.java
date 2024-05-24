package com.example.coursemanagement.Model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDTO {
    private Long id;

    private Long course;

    private Long student;

    private Short score;

    private Integer term;

    public SectionDTO(){}

    public SectionDTO(Long id, Long course, Long student, Short score, Integer term) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.score = score;
        this.term = term;
    }
}
