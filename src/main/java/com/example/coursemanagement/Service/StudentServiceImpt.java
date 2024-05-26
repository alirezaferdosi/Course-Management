package com.example.coursemanagement.Service;

import com.example.coursemanagement.Model.DTO.StudentDTO;
import com.example.coursemanagement.Model.Student;
import com.example.coursemanagement.Model.Section;
import com.example.coursemanagement.Repository.Section.SectionRepository;
import com.example.coursemanagement.Repository.Student.StudentRepository;
import com.example.coursemanagement.Repository.Student.StudentService;
import com.example.coursemanagement.Repository.Section.SectionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpt implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    @Qualifier("sectionServiceImpt")
    private SectionService sectionService;

    @Autowired
    private SectionRepository sectionRepository;


    @Override
    @Transactional
    public Student AddStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public List<Student> GetAllStudent() {
        List<Student> list = new ArrayList<>();
        for(Student stud: studentRepository.findAll()){
            list.add(stud);
        }
        return list;
    }

    @Override
    @Transactional
    public Student GetStudentObjectById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Student GetStudentById(Long id){
        return GetStudentObjectById(id);
    }

    @Override
    @Transactional
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
    @Transactional
    public void DeleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void DeleteStudentByNationalcode(String ncode){
        for(Student stud: studentRepository.findAll()){
            if(stud.getNcode().equals(ncode)){
                studentRepository.deleteById(stud.getSid());
                break;
            }
        }
    }

    @Override
    @Transactional
    public Boolean ExistStudent(String ncode){
        for(Student stud: studentRepository.findAll()){
            if(stud.getNcode().equals(ncode)) return true;
        }
        return false;
    }

    @Override
    @Transactional
    public float GPA(Long id){
        float score = 0;
        int unit = 0;
        for(Section sec:  sectionRepository.findAll()){
            if(sec.getStudent().getSid() == id && sec.getScore() != null){
                score += sec.getScore() * sec.getCourse().getUnit();
                unit += sec.getCourse().getUnit();
            }
            System.out.println(score + "---" + unit);
        }
        return score / unit;
    }
}
