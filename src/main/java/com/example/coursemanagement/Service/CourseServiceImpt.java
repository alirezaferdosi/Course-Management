package com.example.coursemanagement.Service;

import com.example.coursemanagement.Model.Course;
import com.example.coursemanagement.Model.DTO.CourseDTO;
import com.example.coursemanagement.Repository.Course.CourseRepository;
import com.example.coursemanagement.Repository.Course.CourseService;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Course AddCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public List<Course> GetAllCourse() {
        List<Course> list = new ArrayList<>();
        for(Course crs: courseRepository.findAll()){
            list.add(crs);
        }
        return list;
    }

    @Override
    @Transactional
    public Course GetCourseById(Long id){
        return GetCourseObjectById(id);
    }

    @Override
    @Transactional
    public Course GetCourseObjectById(Long id){
        return courseRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Course> GetAllCourseByCollegeId(Long id) {
        List<Course> list = new ArrayList();
        for(Course course: courseRepository.findAll()){
            if(Objects.equals(course.getClg().getClgid(), id)){
                list.add(course);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Course UpdateCourse(Course course) {
        Course crs = courseRepository.findById(course.getCid()).get();

        if(course.getCname() != null && !course.getCname().equals("")){
            crs.setCname(course.getCname());
        }
        if(course.getUnit() != null && !course.getUnit().equals("")){
            crs.setUnit(course.getUnit());
        }
        if(course.getClg() != null && !course.getClg().equals("")){
            crs.setClg(course.getClg());
        }

        return courseRepository.save(crs);
    }

    @Override
    @Transactional
    public void DeleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean ExistCourse(Long id){
        for(Course crs: courseRepository.findAll()){
            if(crs.getClg().getClgid() == id) return true;
        }
         return false;
    }
}
