package com.example.coursemanagement.Model.Interface;

import com.example.coursemanagement.Model.College;

public class StudentInterface {
    private Long sid;

    private String sname;

    private String sfamily;

    private String ncode;

    private String address;

    private Long clgid;


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
