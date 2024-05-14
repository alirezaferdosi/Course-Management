package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.Interface.SectionInterface;
import com.example.coursemanagement.Model.*;
import com.example.coursemanagement.Repository.Course.CourseService;
import com.example.coursemanagement.Repository.Section.*;

import com.example.coursemanagement.Repository.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Component
@RestController
@RequestMapping("/Section")
public class SectionController {

    @Autowired
    @Qualifier("sectionServiceImpt")
    private SectionService sectionService;

    @Autowired
    @Qualifier("courseServiceImpt")
    private CourseService courseService;

    @Autowired
    @Qualifier("studentServiceImpt")
    private StudentService studentService;


    @PostMapping
    public Section AddSection(@RequestBody SectionInterface section){
        return sectionService.AddSection(new Section(
                                                    courseService.GetCourseById(section.getCourse()),
                                                    studentService.GetStudentById(section.getStudent()),
                                                    section.getTerm(),
                                                    section.getScore()
                                                    ));
    }

    @GetMapping
    public List<Section> GetAllSection(){
        return  sectionService.GetAllSection();
    }
}
