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
    private Long pid;

    @ManyToOne(targetEntity = Course.class)
    @MapsId("Course_id")
    @JoinColumn(name = "Course_id")
    private Long course;

    @ManyToOne(targetEntity = College.class)
    @MapsId("College_name")
    @JoinColumn(name = "College_name")
    private Long college;

    @ManyToOne(targetEntity = Student.class)
    @MapsId("Student_id")
    @JoinColumn(name = "Student_id")
    private Long student;





}
