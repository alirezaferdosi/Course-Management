package com.example.coursemanagement.Model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Long sid;

    private String sname;

    private String sfamily;

    private String ncode;

    private String address;

    private Long clgid;

    public StudentDTO(){}

    public StudentDTO(Long sid, String sname, String sfamily, String ncode, String address, Long clgid) {
        this.sid = sid;
        this.sname = sname;
        this.sfamily = sfamily;
        this.ncode = ncode;
        this.address = address;
        this.clgid = clgid;
    }
}
