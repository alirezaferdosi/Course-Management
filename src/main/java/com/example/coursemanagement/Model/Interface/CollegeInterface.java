package com.example.coursemanagement.Model.Interface;

public class CollegeInterface {
    private Long clgid;

    private String clgname;

    private Long HDepartment;

    public Long getClgid() {
        return clgid;
    }

    public void setClgid(Long clgid) {
        this.clgid = clgid;
    }

    public String getClgname() {
        return clgname;
    }

    public void setClgname(String clgname) {
        this.clgname = clgname;
    }

    public Long getHDepartment() {
        return HDepartment;
    }

    public void setHDepartment(Long HDepartment) {
        this.HDepartment = HDepartment;
    }
}
