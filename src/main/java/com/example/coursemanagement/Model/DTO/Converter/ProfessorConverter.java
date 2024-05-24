package com.example.coursemanagement.Model.DTO.Converter;

import com.example.coursemanagement.Model.DTO.ProfessorDTO;
import com.example.coursemanagement.Model.Professor;
import com.example.coursemanagement.Repository.College.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ProfessorConverter")
public class ProfessorConverter implements ConvertObject<Professor, ProfessorDTO>{

    @Autowired
    @Qualifier("collegeServiceImpt")
    private CollegeService collegeService;

    @Override
    public ProfessorDTO ConvertEntityToDto(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setPid(professor.getPid());
        dto.setPname(professor.getPname());
        dto.setPfamily(professor.getPfamily());
        dto.setNcode(professor.getNcode());
        dto.setClgid(professor.getClg().getClgid());
        return dto;
    }

    @Override
    public Professor ConvertDtoToEntity(ProfessorDTO professorDTO) {
        return new Professor(
                            professorDTO.getPname(),
                            professorDTO.getPfamily(),
                            professorDTO.getNcode(),
                            collegeService.GetCollegeObjectById(professorDTO.getClgid())
                            );
    }
}
