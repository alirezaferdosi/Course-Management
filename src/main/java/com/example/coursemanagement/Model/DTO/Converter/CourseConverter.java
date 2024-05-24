package com.example.coursemanagement.Model.DTO.Converter;

import com.example.coursemanagement.Model.Course;
import com.example.coursemanagement.Model.DTO.CourseDTO;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Repository.Course.CourseService;
import com.example.coursemanagement.Repository.Professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("CourseConverter")
public class CourseConverter implements ConvertObject<Course, CourseDTO>{

    @Autowired
    @Qualifier("professorServiceImpt")
    private ProfessorService professorService;

    @Autowired
    @Qualifier("collegeServiceImpt")
    private CollegeService collegeService;

    @Override
    public CourseDTO ConvertEntityToDto(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCid(course.getCid());
        dto.setCname(course.getCname());
        dto.setUnit(course.getUnit());
        dto.setProfid(course.getProf().getPid());
        dto.setClgid(course.getClg().getClgid());
        return dto;
    }

    @Override
    public Course ConvertDtoToEntity(CourseDTO courseDTO) {
        return new Course(
                            courseDTO.getCname(),
                            courseDTO.getUnit(),
                            collegeService.GetCollegeObjectById(courseDTO.getClgid()),
                            professorService.GetProfessorObjectById(courseDTO.getProfid())
                            );
    }
}
