package com.example.coursemanagement.Repository.Course;

import com.example.coursemanagement.Model.Course;
import com.example.coursemanagement.Model.Interface.CourseInterface;
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
    public CourseInterface AddCourse(Course course) {
        return OutputFrame(courseRepository.save(course));
    }

    @Override
    public List<CourseInterface> GetAllCourse() {
        List<CourseInterface> list = new ArrayList<>();
        for(Course crs: courseRepository.findAll()){
            list.add(OutputFrame(crs));
        }
        return list;
    }

    @Override
    public CourseInterface GetCourseById(Long id){
        return OutputFrame(GetCourseObjectById(id));
    }

    @Override
    public  Course GetCourseObjectById(Long id){
        return courseRepository.findById(id).get();
    }

    @Override
    public List<CourseInterface> GetAllCourseByCollegeId(Long id) {
        List<CourseInterface> list = new ArrayList();
        for(Course course: courseRepository.findAll()){
            if(Objects.equals(course.getClg().getClgid(), id)){
                list.add(OutputFrame(course));
            }
        }
        return list;
    }

    @Override
    public CourseInterface UpdateCourse(Course course) {
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

        return OutputFrame(courseRepository.save(crs));
    }

    @Override
    public void DeleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Boolean ExistCourse(Long id){
        for(Course crs: courseRepository.findAll()){
            if(crs.getClg().getClgid() == id) return true;
        }
         return false;
    }

    @Override
    public CourseInterface OutputFrame(Course course){
        return new CourseInterface(
                                    course.getCid(),
                                    course.getCname(),
                                    course.getUnit(),
                                    course.getClg().getClgid(),
                                    course.getProf().getpid()
                                    );
    }
}
