package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "College_name", nullable = false)
    private College clgid;


    public Long getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSfamily() {
        return sfamily;
    }

    public void setSfamily(String sfamily) {
        this.sfamily = sfamily;
    }

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public College getClgid() {
        return clgid;
    }

    public void setClgid(College clgid) {
        this.clgid = clgid;
    }
}
