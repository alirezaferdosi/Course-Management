package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Optional;

@Entity
@Table(name = "Section")
@IdClass(SectionKey.class)
public class Section {
//    @Id
//    @ManyToOne(targetEntity = Professor.class)
//    @JoinColumn(name = "Professor_id")
//    private Professor professor;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Id
    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "Course_id")
    private Course course;

//    @Id
//    @ManyToOne(targetEntity = College.class)
//    @JoinColumn(name = "College_name")
//    private College college;

    @Id
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "Student_id")
    private Student student;

    @Id
    @Column(name = "term", nullable = false)
    private Integer term;

    @Max(20)
    @Min(0)
    @Column(name = "Score")
    private Short score;


    public Section(Optional<Student> student, Course course, Integer term, Short score){}

    public Section(Long id, Course course, Student student, Integer term, Short score) {
//        this.id = id;
        this.course = course;
        this.student = student;
        this.term = term;
        this.score = score;
    }

    public Section(Course course, Student student, Integer term, Short score) {
        this.course = course;
        this.student = student;
        this.term = term;
        this.score = score;
    }

//    public Long getId(){
//        return id;
//    }

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

//    public Professor getProfessor() {
//        return professor;
//    }
//
//    public void setProfessor(Professor professor) {
//        this.professor = professor;
//    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

//    public College getCollege() {
//        return college;
//    }
//
//    public void setCollege(College college) {
//        this.college = college;
//    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
