package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Section {

    @EmbeddedId
    private SectionKey id;

    @ManyToOne(targetEntity = Professor.class)
    @MapsId("Professor_id")
    @JoinColumn(name = "Professor_id")
    private Professor pid;

    @ManyToOne(targetEntity = Course.class)
    @MapsId("Course_id")
    @JoinColumn(name = "Course_id")
    private Course course;

    @ManyToOne(targetEntity = College.class)
    @MapsId("College_name")
    @JoinColumn(name = "College_name")
    private College college;

    @ManyToOne(targetEntity = Student.class)
    @MapsId("Student_id")
    @JoinColumn(name = "Student_id")
    private Student student;





}
