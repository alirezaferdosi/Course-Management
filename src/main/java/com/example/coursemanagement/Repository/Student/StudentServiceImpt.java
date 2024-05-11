package com.example.coursemanagement.Repository.Student;

import com.example.coursemanagement.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpt implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpt(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student AddStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> GetAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> GetStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student UpdateSTudent(Student student) {
        return null;
    }

    @Override
    public void DeleteStudent(Long id) {

    }

    @Override
    public Boolean ExistStudent(String ncode){
        for(Student stud: studentRepository.findAll()){
            if(stud.getNcode().equals(ncode)) return true;
        }
        return false;
    }
}
