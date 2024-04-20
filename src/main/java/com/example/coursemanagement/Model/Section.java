package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Section")
@IdClass(SectionKey.class)
public class Section {

//    @EmbeddedId
//    private SectionKey id;

    @Id
    @ManyToOne(targetEntity = Professor.class)
//    @MapsId("Professor_id")
    @JoinColumn(name = "Professor_id")
    private Professor professor;

    @Id
    @ManyToOne(targetEntity = Course.class)
//    @MapsId("Course_id")
    @JoinColumn(name = "Course_id")
    private Course course;

    @Id
    @ManyToOne(targetEntity = College.class)
//    @MapsId("College_name")
    @JoinColumn(name = "College_name")
    private College college;

    @Id
    @ManyToOne(targetEntity = Student.class)
//    @MapsId("Student_id")
    @JoinColumn(name = "Student_id")
    private Student student;


//    public SectionKey getId() {
//        return id;
//    }
//
//    public void setId(SectionKey id) {
//        this.id = id;
//    }


    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
