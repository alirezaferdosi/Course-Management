package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.Interface.CourseInterface;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Repository.Course.CourseService;
import com.example.coursemanagement.Model.Course;

import com.example.coursemanagement.Repository.Professor.ProfessorService;
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

    @Autowired
    @Qualifier("professorServiceImpt")
    private ProfessorService professorService;


    @PostMapping
    public CourseInterface AddCourse(@RequestBody CourseInterface course){
        return courseService.AddCourse(new Course(
                                                 course.getCname(),
                                                 course.getUnit(),
                                                 collegeService.GetCollegeObjectById(course.getClgid()),
                                                 professorService.GetProfessorObjectById(course.getProfid())
                                                 ));
    }

    @GetMapping
    public List<CourseInterface> GetAllCourse(){
        return  courseService.GetAllCourse();
    }

    @GetMapping("SC")
    public List<CourseInterface> GetAllCourseByCollegeId(@RequestBody String id){
        return courseService.GetAllCourseByCollegeId(Long.valueOf(id));
    }

    @PutMapping
    public CourseInterface UpdateCourse(@RequestBody CourseInterface course){
        return courseService.UpdateCourse(new Course(
                                                    course.getCid(),
                                                    course.getCname(),
                                                    course.getUnit(),
                                                    collegeService.GetCollegeObjectById(course.getClgid()),
                                                    professorService.GetProfessorObjectById(course.getProfid())
                                                    ));
    }

    @DeleteMapping
    public void DeleteCourse(@RequestBody String id){
        courseService.DeleteCourse(Long.valueOf(id));
    }
}
