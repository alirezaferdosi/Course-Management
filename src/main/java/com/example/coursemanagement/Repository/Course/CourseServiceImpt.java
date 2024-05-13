package com.example.coursemanagement.Repository.Course;

import com.example.coursemanagement.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpt implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course AddCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> GetAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> GetAllBourseByCollegeId(Long id) {
        List<Course> list = new ArrayList();
        for(Course course: courseRepository.findAll()){
            if(course.getClgid().getClgid() == id){
                list.add(course);
            }
        }
        return list;
    }

    @Override
    public Course UpdateCourse(Course course) {
        return null;
    }

    @Override
    public void DeleteCourse(Long id) {

    }
}
