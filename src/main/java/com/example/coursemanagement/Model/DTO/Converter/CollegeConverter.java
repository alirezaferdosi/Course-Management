package com.example.coursemanagement.Model.DTO.Converter;

import com.example.coursemanagement.Model.College;
import com.example.coursemanagement.Model.DTO.CollegeDTO;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Repository.Professor.ProfessorService;
import com.example.coursemanagement.Service.ProfessorServiceImpt;
import org.springframework.stereotype.Component;

@Component("CollegeConverter")
public class CollegeConverter implements ConvertObject<College, CollegeDTO>{
    @Override
    public CollegeDTO ConvertEntityToDto(College college) {
        CollegeDTO dto = new CollegeDTO();
        dto.setClgid(college.getClgid());
        dto.setClgname(college.getClgname());
        dto.setHDepartment(college.getClgid());
        return dto;
    }

    @Override
    public College ConvertDtoToEntity(CollegeDTO collegeDTO) {
        ProfessorService professorService = new ProfessorServiceImpt();
        return new College(
                            collegeDTO.getClgid(),
                            collegeDTO.getClgname(),
                            professorService.GetProfessorObjectById(collegeDTO.getHDepartment())
                            );
    }
}
