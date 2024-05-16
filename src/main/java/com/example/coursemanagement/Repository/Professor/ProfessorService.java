package com.example.coursemanagement.Repository.Professor;

import com.example.coursemanagement.Model.Interface.ProfessorInterface;
import com.example.coursemanagement.Model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ProfessorService")
public interface ProfessorService {
    ProfessorInterface AddProfessor(Professor professor);

    List<ProfessorInterface> GetAllProfessor();

    Professor GetProfessorObjectById(Long id);

    ProfessorInterface GetProfessorbyId(Long id);

    ProfessorInterface UpdateProfessor(Professor professor);

    void DeleteProfessor(Long id);

    Boolean ExistProfessor(String ncode);

    ProfessorInterface OutputFrame(Professor professor);
}
