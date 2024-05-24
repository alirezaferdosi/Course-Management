package com.example.coursemanagement.Repository.Course;

import com.example.coursemanagement.Model.Course;
import com.example.coursemanagement.Model.DTO.CourseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CourseService")
public interface CourseService {
    CourseDTO AddCourse(Course course);

    List<CourseDTO> GetAllCourse();

    CourseDTO GetCourseById(Long id);

    Course GetCourseObjectById(Long id);


    List<CourseDTO> GetAllCourseByCollegeId(Long id);

    CourseDTO UpdateCourse(Course course);

    void DeleteCourse(Long id);

    Boolean ExistCourse(Long id);

    CourseDTO OutputFrame(Course course);
}
