package com.example.coursemanagement.Model.DTO.Converter;

import com.example.coursemanagement.Model.DTO.SectionDTO;
import com.example.coursemanagement.Model.Section;
import com.example.coursemanagement.Repository.Course.CourseService;
import com.example.coursemanagement.Repository.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("SectionConverter")
public class SectionConverter implements ConvertObject<Section, SectionDTO> {
    @Autowired
    @Qualifier("courseServiceImpt")
    private CourseService courseService;

    @Autowired
    @Qualifier("studentServiceImpt")
    private StudentService studentService;

    @Override
    public SectionDTO ConvertEntityToDto(Section section) {
        SectionDTO dto = new SectionDTO();
        dto.setId(section.getId());
        dto.setCourse(section.getCourse().getCid());
        dto.setStudent(section.getStudent().getSid());
        dto.setTerm(section.getTerm());
        dto.setScore(section.getScore());
        return dto;
    }

    @Override
    public Section ConvertDtoToEntity(SectionDTO sectionDTO) {
        return new Section(
                            sectionDTO.getId(),
                            courseService.GetCourseObjectById(sectionDTO.getCourse()),
                            studentService.GetStudentObjectById(sectionDTO.getStudent()),
                            sectionDTO.getTerm(),
                            sectionDTO.getScore()
                            );
    }
}
