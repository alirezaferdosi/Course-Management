package com.example.coursemanagement.Model;

import jakarta.persistence.*;


import javax.validation.constraints.*;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Course_id")
    private Long cid;

    @Max(64)
    @Column(name = "Course_name", nullable = false, unique = true)
    private String canme;

    @Min(1)
    @Max(5)
    @Column(name = "Unit", nullable = false)
    private Integer unit;

    @ManyToOne(targetEntity = College.class)
    @JoinColumn(name = "College_name", nullable = false)
    private College clgid;


    public Long getCid() {
        return cid;
    }

    public String getCanme() {
        return canme;
    }

    public void setCanme(String canme) {
        this.canme = canme;
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
}

