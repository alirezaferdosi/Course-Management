package com.example.coursemanagement.Model.DTO;

public class CollegeDTO {
    private Long clgid;

    private String clgname;

    private Long HDepartment;

    public CollegeDTO(){}

    public CollegeDTO(Long clgid, String clgname, Long HDepartment) {
        this.clgid = clgid;
        this.clgname = clgname;
        this.HDepartment = HDepartment;
    }

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
