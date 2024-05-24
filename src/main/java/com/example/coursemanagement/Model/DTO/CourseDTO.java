package com.example.coursemanagement.Model.DTO;

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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Long getClgid() {
        return clgid;
    }

    public void setClgid(Long clgid) {
        this.clgid = clgid;
    }

    public Long getProfid() {
        return profid;
    }

    public void setProf(Long profid) {
        this.profid = profid;
    }
}
