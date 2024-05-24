package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.DTO.SectionDTO;
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
    public SectionDTO AddSection(@RequestBody SectionDTO section){
        return sectionService.AddSection(new Section(
                                                    courseService.GetCourseObjectById(section.getCourse()),
                                                    studentService.GetStudentObjectById(section.getStudent()),
                                                    section.getTerm(),
                                                    section.getScore()
                                                    ));
    }

    @GetMapping
    public List<SectionDTO> GetAllSection(){
        return  sectionService.GetAllSection();
    }

    @GetMapping("ByCollegeId")
    public List<SectionDTO> GetAllSectionByCollegeId(@RequestBody String id){
        return sectionService.GetAllSectionByCollegeId(id);
    }

    @GetMapping("ByProfessorId")
    public List<SectionDTO> GetAllSectionByProfessorId(@RequestBody String id){
        return sectionService.GetAllSectionByProfessorId(id);
    }

    @GetMapping("ByStudentId")
    public List<SectionDTO> GetAllSectionByStudentId(@RequestBody String id){
        return sectionService.GetAllSectionByStudentId(id);
    }

    @GetMapping("ByTerm")
    public List<SectionDTO> GetAllSectionByTerm(@RequestBody String term){
        return sectionService.GetAllSectionByTerm(Integer.valueOf(term));
    }

    @PutMapping
    public SectionDTO UpdateSection(@RequestBody SectionDTO section){
        return sectionService.UpdateSection(new Section(
                                                        section.getId(),
                                                        courseService.GetCourseObjectById(section.getCourse()),
                                                        studentService.GetStudentObjectById(section.getStudent()),
                                                        section.getTerm(),
                                                        section.getScore()
                                                        ));
    }

    @DeleteMapping
    public void DeleteSection(@RequestBody String id){
        sectionService.DeleteSection(Long.valueOf(id));
    }


}
