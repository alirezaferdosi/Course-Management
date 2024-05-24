package com.example.coursemanagement.Model.DTO;

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

    public Long getClgid() {
        return clgid;
    }

    public void setClgid(Long clgid) {
        this.clgid = clgid;
    }
}
