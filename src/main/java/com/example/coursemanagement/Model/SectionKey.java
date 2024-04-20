package com.example.coursemanagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

//@Entity
public class SectionKey implements Serializable {

//    @Column(name = "Professor_id")
    private Professor professor;

//    @Column(name = "Course_id")
        private Course course;

//    @Column(name = "College_name")
    private College college;

//    @Column(name = "Student_id")
    private Student student;


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
