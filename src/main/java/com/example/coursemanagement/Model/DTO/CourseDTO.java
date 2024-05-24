package com.example.coursemanagement.Model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    private Long cid;

    private String cname;

    private Integer unit;

    private Long clgid;

    private Long profid;

    public CourseDTO(){}

    public CourseDTO(Long cid, String cname, Integer unit, Long clgid, Long Profid) {
        this.cid = cid;
        this.cname = cname;
        this.unit = unit;
        this.clgid = clgid;
        this.profid = Profid;
    }
}
