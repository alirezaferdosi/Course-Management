package com.example.coursemanagement.Model.DTO.Converter;

import com.example.coursemanagement.Model.DTO.StudentDTO;
import com.example.coursemanagement.Model.Student;
import com.example.coursemanagement.Repository.College.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("StudentConverter")
public class StudentConverter implements ConvertObject<Student, StudentDTO> {

    @Autowired
    @Qualifier("collegeServiceImpt")
    private CollegeService collegeService;

    @Override
    public StudentDTO ConvertEntityToDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setSid(student.getSid());
        dto.setSname(student.getSname());
        dto.setSfamily(student.getSfamily());
        dto.setNcode(student.getNcode());
        dto.setAddress(student.getAddress());
        dto.setClgid(student.getClg().getClgid());
        return  dto;
    }

    @Override
    public Student ConvertDtoToEntity(StudentDTO studentDTO) {
        return new Student(
                            studentDTO.getSname(),
                            studentDTO.getSfamily(),
                            studentDTO.getNcode(),
                            studentDTO.getAddress(),
                            collegeService.GetCollegeObjectById(studentDTO.getClgid())
                            );
    }
}
