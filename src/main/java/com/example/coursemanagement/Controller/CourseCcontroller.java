package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.Interface.CourseInterface;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Repository.Course.CourseService;
import com.example.coursemanagement.Model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/Course")
public class CourseCcontroller {

    @Autowired
    @Qualifier("courseServiceImpt")
    private CourseService courseService;

    @Autowired
    @Qualifier("collegeServiceImpt")
    private CollegeService collegeService;


    @PostMapping
    public Course AddCourse(@RequestBody CourseInterface course){
        return courseService.AddCourse(new Course(
                                                 course.getCname(),
                                                 course.getUnit(),
                                                 collegeService.GetCollegeById(course.getClgid())
                                                 ));
    }

    @GetMapping
    public List<Course> GetAllCourse(){
        return  courseService.GetAllCourse();
    }
}
