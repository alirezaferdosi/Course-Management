package com.example.coursemanagement.Repository.Professor;

import com.example.coursemanagement.Model.DTO.ProfessorDTO;
import com.example.coursemanagement.Model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ProfessorService")
public interface ProfessorService {
    ProfessorDTO AddProfessor(Professor professor);

    List<ProfessorDTO> GetAllProfessor();

    Professor GetProfessorObjectById(Long id);

    ProfessorDTO GetProfessorbyId(Long id);

    ProfessorDTO UpdateProfessor(Professor professor);

    void DeleteProfessor(Long id);

    Boolean ExistProfessor(String ncode);

    ProfessorDTO OutputFrame(Professor professor);
}
