package com.example.coursemanagement.Repository.Student;

import com.example.coursemanagement.Model.DTO.StudentDTO;
import com.example.coursemanagement.Model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("StudentService")
public interface StudentService {
    Student AddStudent(Student student);

    List<Student> GetAllStudent();

    Student GetStudentObjectById(Long id);

    Student GetStudentById(Long id);

    Student UpdateStudent(Student student);

    void DeleteStudentById(Long id);

    void DeleteStudentByNationalcode(String ncode);

    Boolean ExistStudent(String ncode);
}
