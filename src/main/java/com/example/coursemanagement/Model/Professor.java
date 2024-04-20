package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import javax.validation.constraints.Max;

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
    private College clgid;


    public Long getpid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPfamily() {
        return pfamily;
    }

    public void setPfamily(String pfamily) {
        this.pfamily = pfamily;
    }

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;
    }

//    public College getClgid() {
//        return clgid;
//    }
//
//    public void setClgid(College clgid) {
//        this.clgid = clgid;
//    }
}
