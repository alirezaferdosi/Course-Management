package com.example.coursemanagement.Model.DTO;

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

    public Long getId(){
        return id;
    }

    public void SetId(Long id){
        this.id = id;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }
}
