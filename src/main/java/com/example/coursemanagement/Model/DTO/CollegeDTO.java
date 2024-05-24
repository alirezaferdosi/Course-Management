package com.example.coursemanagement.Model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
