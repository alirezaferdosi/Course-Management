package com.example.coursemanagement.Model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO {
    private Long pid;

    private String pname;

    private String pfamily;

    private String ncode;

    private Long clgid;

    public ProfessorDTO(){}

    public ProfessorDTO(Long pid, String pname, String pfamily, String ncode, Long clgid) {
        this.pid = pid;
        this.pname = pname;
        this.pfamily = pfamily;
        this.ncode = ncode;
        this.clgid = clgid;
    }

    public Long getpid() {
        return pid;
    }
}
