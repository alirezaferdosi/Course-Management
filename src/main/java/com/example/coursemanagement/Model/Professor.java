package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

@Getter
@Setter
@Entity
@Table(name = "Professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Professor_Id")
    private Long pid;

    @Max(48)
    @Column(name = "Professor_name", nullable = false)
    private String pname;

    @Column(name = "Professor_family")
    private String pfamily;

    @Column(name = "National_code", nullable = false)
    private String ncode;

    @ManyToOne(targetEntity = College.class)
    @JoinColumn(name = "College_name", nullable = false)
    private College clg;


    public Professor(){}

    public Professor(String pname, String pfamily, String ncode, College clgid) {
        this.pname = pname;
        this.pfamily = pfamily;
        this.ncode = ncode;
        this.clg = clgid;
    }

    public Professor(Long pid, String pname, String pfamily, String ncode, College clgid) {
        this.pid = pid;
        this.pname = pname;
        this.pfamily = pfamily;
        this.ncode = ncode;
        this.clg = clgid;
    }
}
