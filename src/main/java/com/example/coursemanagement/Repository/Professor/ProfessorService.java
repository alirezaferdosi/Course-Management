package com.example.coursemanagement.Repository.Professor;

import com.example.coursemanagement.Model.DTO.ProfessorDTO;
import com.example.coursemanagement.Model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ProfessorService")
public interface ProfessorService {
    Professor AddProfessor(Professor professor);

    List<Professor> GetAllProfessor();

    Professor GetProfessorObjectById(Long id);

    Professor GetProfessorbyId(Long id);

    Professor UpdateProfessor(Professor professor);

    void DeleteProfessor(Long id);

    Boolean ExistProfessor(String ncode);
}
