package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SectionKey implements Serializable {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "Student_id")
    private Student student;

    @Column(name = "term", nullable = false)
    private Integer term;
}
