package com.example.coursemanagement.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class SectionKey implements Serializable {

    @Column(name = "Professor_id")
    private Professor pid;

    @Column(name = "Course_id")
    private Course cid;

    @Column(name = "College_name")
    private College clgid;

    @Column(name = "Student_id")
    private Student sid;


    public Professor getPid() {
        return pid;
    }

    public Course getCid() {
        return cid;
    }

    public void setCid(Course cid) {
        this.cid = cid;
    }

    public College getClgid() {
        return clgid;
    }

    public void setClgid(College clgid) {
        this.clgid = clgid;
    }

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }
}
