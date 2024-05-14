package com.example.coursemanagement.Repository.Course;

import com.example.coursemanagement.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public Course GetCourseById(Long id){
        for(Course crs: courseRepository.findAll()){
            if(crs.getClgid().getClgid() == id) return crs;
        }
        return null;
    }

    @Override
    public List<Course> GetAllCourseByCollegeId(Long id) {
        List<Course> list = new ArrayList();
        for(Course course: courseRepository.findAll()){
            if(Objects.equals(course.getClgid().getClgid(), id)){
                list.add(course);
            }
        }
        return list;
    }

    @Override
    public Course UpdateCourse(Course course) {
        Course crs = courseRepository.findById(course.getCid()).get();

        if(course.getCname() != null && !course.getCname().equals("")){
            crs.setCname(course.getCname());
        }
        if(course.getUnit() != null && !course.getUnit().equals("")){
            crs.setUnit(course.getUnit());
        }
        if(course.getClgid() != null && !course.getClgid().equals("")){
            crs.setClgid(course.getClgid());
        }

        return courseRepository.save(crs);
    }

    @Override
    public void DeleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Boolean ExistCourse(Long id){
        for(Course crs: courseRepository.findAll()){
            if(crs.getClgid().getClgid() == id) return true;
        }
         return false;
    }
}
