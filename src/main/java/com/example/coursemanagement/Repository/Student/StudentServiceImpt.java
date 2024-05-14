package com.example.coursemanagement.Repository.Student;

import com.example.coursemanagement.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public Student GetStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student UpdateStudent(Student student) {
        Student stud = studentRepository.findById(student.getSid()).get();

        if(Objects.nonNull(student.getSname()) && !student.getSname().equals("")){
            stud.setSname(student.getSname());
        }
        if(Objects.nonNull(student.getSfamily()) && !student.getSfamily().equals("")){
            stud.setSfamily(student.getSfamily());
        }
        if(Objects.nonNull(student.getAddress()) && !student.getAddress().equals("")){
            stud.setAddress(student.getAddress());
        }
        if(Objects.nonNull(student.getNcode()) && !student.getNcode().equals("")){
            stud.setNcode(student.getNcode());
        }

        return studentRepository.save(stud);
    }

    @Override
    public void DeleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void DeleteStudentByNationalcode(String ncode){
        for(Student stud: studentRepository.findAll()){
            if(stud.getNcode().equals(ncode)){
                studentRepository.deleteById(stud.getSid());
                break;
            }
        }
    }

    @Override
    public Boolean ExistStudent(String ncode){
        for(Student stud: studentRepository.findAll()){
            if(stud.getNcode().equals(ncode)) return true;
        }
        return false;
    }
}
