package com.example.coursemanagement.Model.Interface;

public class ProfessorInterface {
    private Long pid;

    private String pname;

    private String pfamily;

    private String ncode;

    private Long clgid;


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

    public Long getClgid() {
        return clgid;
    }

    public void setClgid(Long clgid) {
        this.clgid = clgid;
    }
}