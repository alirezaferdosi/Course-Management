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
    private College clgid;

    @ManyToOne
    @JoinColumn(name = "teacher_name", nullable = false)
    private Professor profid;

    public Course(){}

    public Course(Long cid, String canme, Integer unit, College clgid, Professor profid) {
        this.cid = cid;
        this.cname = canme;
        this.unit = unit;
        this.clgid = clgid;
        this.profid = profid;
    }

    public Course(String canme, Integer unit, College clgid, Professor profid) {
        this.cname = canme;
        this.unit = unit;
        this.clgid = clgid;
        this.profid = profid;
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

    public College getClgid() {
        return clgid;
    }

    public void setClgid(College clgid) {
        this.clgid = clgid;
    }

    public Professor getProfid() {
        return profid;
    }

    public void setProfid(Professor profid) {
        this.profid = profid;
    }
}

