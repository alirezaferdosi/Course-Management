package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Entity
@Table(name = "College")
@Component
//@NamedQuery(name = "add college" , query = "INSERT INTO College(clgname,HDepartment)  String VALUES(:clgname,:HDepartment)")
public class College{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_id", nullable = false)
    private Long clgid;

    @Max(48)
    @Min(5)
    @Column(name = "college_name", nullable = false, unique = true)
    private String clgname;

    @OneToOne(targetEntity = Professor.class)
    @JoinColumn(name = "Head_Department")
    private Professor HDepartment;


    public Long getClgid() {
        return clgid;
    }

    public String getClgname() {
        return clgname;
    }

    public void setClggename(String clggename) {
        this.clgname = clggename;
    }

    public Professor getHDepartment() {
        return HDepartment;
    }

    public void setHDepartment(Professor HDepartment) {
        this.HDepartment = HDepartment;
    }
}
