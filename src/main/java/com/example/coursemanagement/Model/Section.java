package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Section")
public class Section {

    @EmbeddedId
    private SectionKey id;

    @Max(20)
    @Min(0)
    @Column(name = "Score")
    private Short score;


    public Section(Long id, Course course, Student student, Integer term, Short score) {
        this.id = new SectionKey();
        this.id.setId(id);
        this.id.setCourse(course);
        this.id.setStudent(student);
        this.id.setTerm(term);
        this.score = score;
    }

    public Section(Course course, Student student, Integer term, Short score) {
        this.id = new SectionKey();
        this.id.setCourse(course);
        this.id.setStudent(student);
        this.id.setTerm(term);
        this.score = score;
    }

    public Section() {
        this.id = new SectionKey();
    }


    public Long getId(){
        return id.getId();
    }

    public void setId(Long id){ this.id.setId(id);}

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Integer getTerm() {
        return id.getTerm();
    }

    public void setTerm(Integer term) {
        this.id.setTerm(term);
    }

    public Course getCourse() {
        return this.id.getCourse();
    }

    public void setCourse(Course course) {
        this.id.setCourse(course);
    }

    public Student getStudent() {
        return this.id.getStudent();
    }

    public void setStudent(Student student) {
        this.id.setStudent(student);
    }
}
