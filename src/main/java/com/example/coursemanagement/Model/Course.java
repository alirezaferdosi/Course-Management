package com.example.coursemanagement.Model;

import jakarta.persistence.*;


import javax.validation.constraints.*;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Course_id")
    private Long cid;

    @Max(64)
    @Column(name = "Course_name", nullable = false, unique = true)
    private String cname;

    @Min(1)
    @Max(5)
    @Column(name = "Unit", nullable = false)
    private Integer unit;

    @ManyToOne(targetEntity = College.class)
    @JoinColumn(name = "College_name", nullable = false)
    private College clg;

    @ManyToOne
    @JoinColumn(name = "teacher_name", nullable = false)
    private Professor prof;

    public Course(){}

    public Course(Long cid, String canme, Integer unit, College clgid, Professor profid) {
        this.cid = cid;
        this.cname = canme;
        this.unit = unit;
        this.clg = clgid;
        this.prof = profid;
    }

    public Course(String canme, Integer unit, College clgid, Professor profid) {
        this.cname = canme;
        this.unit = unit;
        this.clg = clgid;
        this.prof = profid;
    }


    public Long getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public College getClg() {
        return clg;
    }

    public void setClg(College clg) {
        this.clg = clg;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }
}

