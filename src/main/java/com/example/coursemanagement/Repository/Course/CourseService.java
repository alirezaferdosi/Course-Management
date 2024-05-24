package com.example.coursemanagement.Repository.Course;

import com.example.coursemanagement.Model.Course;
import com.example.coursemanagement.Model.DTO.CourseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CourseService")
public interface CourseService {
    Course AddCourse(Course course);

    List<Course> GetAllCourse();

    Course GetCourseById(Long id);

    Course GetCourseObjectById(Long id);


    List<Course> GetAllCourseByCollegeId(Long id);

    Course UpdateCourse(Course course);

    void DeleteCourse(Long id);

    Boolean ExistCourse(Long id);
}
