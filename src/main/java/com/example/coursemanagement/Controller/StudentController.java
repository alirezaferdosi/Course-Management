package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.DTO.StudentDTO;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Repository.Student.StudentService;
import com.example.coursemanagement.Model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/Student")
public class StudentController {

    @Qualifier("studentServiceImpt")
    @Autowired
    private StudentService studentService;

    @Autowired
    @Qualifier("collegeServiceImpt")
    private CollegeService collegeService;

    @PostMapping
    public Object AddStudent(@RequestBody StudentDTO student){
        if(studentService.ExistStudent(student.getNcode())) return "Student is Exist";
        return studentService.AddStudent(new Student(
                                                    student.getSname(),
                                                    student.getSfamily(),
                                                    student.getNcode(),
                                                    student.getAddress(),
                                                    collegeService.GetCollegeObjectById(student.getClgid())
                                                    ));
    }

    @GetMapping
    public Object GetAllStudent(){
        return studentService.GetAllStudent();
    }

    @PutMapping()
    public Object UpdateStudent(@RequestBody StudentDTO student){
        if(student.getSid() == null) return "Student Id can not be null";
        return studentService.UpdateStudent(new Student(
                                                student.getSid(),
                                                student.getSname(),
                                                student.getSfamily(),
                                                student.getNcode(),
                                                student.getAddress(),
                                                collegeService.GetCollegeObjectById(student.getClgid())
                                                ));
    }

    @DeleteMapping("/id")
    public void DeleteStudentById(@RequestBody Long id){
        studentService.DeleteStudentById(id);
    }

    @DeleteMapping("/ncode")
    public void DeleteStudentByNationalcode(@RequestBody String ncode){
        studentService.DeleteStudentByNationalcode(ncode);
    }



}
