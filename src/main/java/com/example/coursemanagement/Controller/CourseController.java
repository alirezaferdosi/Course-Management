package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.DTO.Converter.ConvertObject;
import com.example.coursemanagement.Model.DTO.*;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Repository.Course.CourseService;
import com.example.coursemanagement.Model.*;

import com.example.coursemanagement.Repository.Professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/Course")
public class CourseController {

    @Autowired
    @Qualifier("courseServiceImpt")
    private CourseService courseService;

    @Autowired
    @Qualifier("CourseConverter")
    private ConvertObject<Course,CourseDTO> convertObject;


    @PostMapping
    public CourseDTO AddCourse(@RequestBody CourseDTO course){
        return convertObject.ConvertEntityToDto(courseService.AddCourse(convertObject.ConvertDtoToEntity(course)));
    }

    @GetMapping
    public List<CourseDTO> GetAllCourse(){
        return  courseService.GetAllCourse()
                .stream()
                .map(item -> convertObject.ConvertEntityToDto(item))
                .toList();
    }

    @GetMapping("SC")
    public List<CourseDTO> GetAllCourseByCollegeId(@RequestBody String id){
        return courseService.GetAllCourseByCollegeId(Long.valueOf(id))
                .stream()
                .map(item -> convertObject.ConvertEntityToDto(item))
                .toList();
    }

    @PutMapping
    public CourseDTO UpdateCourse(@RequestBody CourseDTO course){
        return convertObject.ConvertEntityToDto(courseService.UpdateCourse(convertObject.ConvertDtoToEntity(course)));
    }

    @DeleteMapping
    public void DeleteCourse(@RequestBody String id){
        courseService.DeleteCourse(Long.valueOf(id));
    }
}
