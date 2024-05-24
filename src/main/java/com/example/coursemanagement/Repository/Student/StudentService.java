package com.example.coursemanagement.Repository.Student;

import com.example.coursemanagement.Model.DTO.StudentDTO;
import com.example.coursemanagement.Model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("StudentService")
public interface StudentService {
    StudentDTO AddStudent(Student student);

    List<StudentDTO> GetAllStudent();

    Student GetStudentObjectById(Long id);

    StudentDTO GetStudentById(Long id);

    StudentDTO UpdateStudent(Student student);

    void DeleteStudentById(Long id);

    void DeleteStudentByNationalcode(String ncode);

    Boolean ExistStudent(String ncode);

    StudentDTO OutputFrame(Student student);

}
