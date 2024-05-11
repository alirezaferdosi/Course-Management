package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.Interface.StudentInterface;
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
    public Object AddStudent(@RequestBody StudentInterface student){
        if(studentService.ExistStudent(student.getNcode())) return "Student is Exist";
        return studentService.AddStudent(new Student(
                                                     student.getSname(),
                                                     student.getSfamily(),
                                                     student.getNcode(),
                                                     student.getAddress(),
                                                     collegeService.GetCollegeById(student.getClgid())
                                                     ));

    }

    @GetMapping
    public Object GetAllStudent(){
        return studentService.GetAllStudent();
    }
}
