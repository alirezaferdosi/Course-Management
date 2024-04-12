package com.example.coursemanagement.Model;

import jakarta.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Entity
@Table(name = "College")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_id", nullable = false)
    private Long clgid;

    @Max(48)
    @Min(5)
    @Column(name = "college_name", nullable = false, unique = true, length = 48)
    private String clgname;

    @Column(name = "Head_Department", nullable = false)
    private String HDepartment;


    public Long getClgid() {
        return clgid;
    }

    public String getClgname() {
        return clgname;
    }

    public void setClggename(String clggename) {
        this.clgname = clggename;
    }

    public String getHDepartment() {
        return HDepartment;
    }

    public void setHDepartment(String HDepartment) {
        this.HDepartment = HDepartment;
    }
}
