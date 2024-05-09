package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Section")
@IdClass(SectionKey.class)
public class Section {
    @Id
    @ManyToOne(targetEntity = Professor.class)
    @JoinColumn(name = "Professor_id")
    private Professor professor;

    @Id
    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "Course_id")
    private Course course;

    @Id
    @ManyToOne(targetEntity = College.class)
    @JoinColumn(name = "College_name")
    private College college;

    @Id
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "Student_id")
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
