package com.example.coursemanagement.Service;

import com.example.coursemanagement.Model.Course;
import com.example.coursemanagement.Model.DTO.CourseDTO;
import com.example.coursemanagement.Repository.Course.CourseRepository;
import com.example.coursemanagement.Repository.Course.CourseService;
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
    public CourseDTO AddCourse(Course course) {
        return OutputFrame(courseRepository.save(course));
    }

    @Override
    public List<CourseDTO> GetAllCourse() {
        List<CourseDTO> list = new ArrayList<>();
        for(Course crs: courseRepository.findAll()){
            list.add(OutputFrame(crs));
        }
        return list;
    }

    @Override
    public CourseDTO GetCourseById(Long id){
        return OutputFrame(GetCourseObjectById(id));
    }

    @Override
    public  Course GetCourseObjectById(Long id){
        return courseRepository.findById(id).get();
    }

    @Override
    public List<CourseDTO> GetAllCourseByCollegeId(Long id) {
        List<CourseDTO> list = new ArrayList();
        for(Course course: courseRepository.findAll()){
            if(Objects.equals(course.getClg().getClgid(), id)){
                list.add(OutputFrame(course));
            }
        }
        return list;
    }

    @Override
    public CourseDTO UpdateCourse(Course course) {
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
    public CourseDTO OutputFrame(Course course){
        return new CourseDTO(
                                    course.getCid(),
                                    course.getCname(),
                                    course.getUnit(),
                                    course.getClg().getClgid(),
                                    course.getProf().getpid()
                                    );
    }
}
