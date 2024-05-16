package com.example.coursemanagement.Repository.Course;

import com.example.coursemanagement.Model.Course;
import com.example.coursemanagement.Model.Interface.CourseInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CourseService")
public interface CourseService {
    CourseInterface AddCourse(Course course);

    List<CourseInterface> GetAllCourse();

    CourseInterface GetCourseById(Long id);

    Course GetCourseObjectById(Long id);


    List<CourseInterface> GetAllCourseByCollegeId(Long id);

    CourseInterface UpdateCourse(Course course);

    void DeleteCourse(Long id);

    Boolean ExistCourse(Long id);

    CourseInterface OutputFrame(Course course);
}
