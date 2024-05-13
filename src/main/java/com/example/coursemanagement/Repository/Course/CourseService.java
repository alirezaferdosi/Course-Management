package com.example.coursemanagement.Repository.Course;

import com.example.coursemanagement.Model.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CourseService")
public interface CourseService {
    Course AddCourse(Course course);

    List<Course> GetAllCourse();

    List<Course> GetAllBourseByCollegeId(Long id);

    Course UpdateCourse(Course course);

    void DeleteCourse(Long id);
}