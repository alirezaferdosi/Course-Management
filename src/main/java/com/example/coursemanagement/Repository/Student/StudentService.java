package com.example.coursemanagement.Repository.Student;

import com.example.coursemanagement.Model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component("StudentService")
public interface StudentService {
    Student AddStudent(Student student);

    List<Student> GetAllStudent();

    Student GetStudentById(Long id);

    Student UpdateStudent(Student student);

    void DeleteStudentById(Long id);

    void DeleteStudentByNationalcode(String ncode);

    Boolean ExistStudent(String ncode);

}
