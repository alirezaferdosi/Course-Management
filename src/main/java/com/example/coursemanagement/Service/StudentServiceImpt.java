package com.example.coursemanagement.Service;

import com.example.coursemanagement.Model.DTO.StudentDTO;
import com.example.coursemanagement.Model.Student;
import com.example.coursemanagement.Repository.Student.StudentRepository;
import com.example.coursemanagement.Repository.Student.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpt implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpt(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentDTO AddStudent(Student student) {
        return OutputFrame(studentRepository.save(student));
    }

    @Override
    public List<StudentDTO> GetAllStudent() {
        List<StudentDTO> list = new ArrayList<>();
        for(Student stud: studentRepository.findAll()){
            list.add(OutputFrame(stud));
        }
        return list;
    }

    @Override
    public Student GetStudentObjectById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public StudentDTO GetStudentById(Long id){
        return OutputFrame(GetStudentObjectById(id));
    }

    @Override
    public StudentDTO UpdateStudent(Student student) {
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

        return OutputFrame(studentRepository.save(stud));
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

    @Override
    public StudentDTO OutputFrame(Student student){
        return new StudentDTO(
                                    student.getSid(),
                                    student.getSname(),
                                    student.getSfamily(),
                                    student.getNcode(),
                                    student.getAddress(),
                                    student.getClg().getClgid()
                                    );
    }
}
