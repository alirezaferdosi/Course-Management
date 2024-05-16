package com.example.coursemanagement.Repository.Student;

import com.example.coursemanagement.Model.Interface.StudentInterface;
import com.example.coursemanagement.Model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("StudentService")
public interface StudentService {
    StudentInterface AddStudent(Student student);

    List<StudentInterface> GetAllStudent();

    Student GetStudentObjectById(Long id);

    StudentInterface GetStudentById(Long id);

    StudentInterface UpdateStudent(Student student);

    void DeleteStudentById(Long id);

    void DeleteStudentByNationalcode(String ncode);

    Boolean ExistStudent(String ncode);

    StudentInterface OutputFrame(Student student);

}
