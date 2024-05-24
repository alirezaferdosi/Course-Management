package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_id")
    private Long sid;

    @Max(48)
    @Column(name = "Student_name", nullable = false)
    private String sname;

    @Max(48)
    @Column(name = "Student_family", nullable = false)
    private String sfamily;

    @Column(name = "National_code", nullable = false)
    private String ncode;

    @Max(128)
    @Column(name = "Address")
    private String address;

    @ManyToOne(targetEntity = College.class)
    @JoinColumn(name = "College_name", nullable = false)
    private College clg;


    public Student(){}

    public Student(String sname, String sfamily, String ncode, String address, College clgid) {
        this.sname = sname;
        this.sfamily = sfamily;
        this.ncode = ncode;
        this.address = address;
        this.clg = clgid;
    }

    public Student(Long sid, String sname, String sfamily, String ncode, String address, College clgid) {
        this.sid = sid;
        this.sname = sname;
        this.sfamily = sfamily;
        this.ncode = ncode;
        this.address = address;
        this.clg = clgid;
    }
}
