package com.example.coursemanagement.Repository.Professor;

import com.example.coursemanagement.Model.College;
import com.example.coursemanagement.Model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ProfessorService")
public interface ProfessorService {
    Professor AddProfessor(Professor professor);

    List<Professor> GetAllProfessor();

    List<Professor> GetAllProfessor(College college);

    Professor UpdateProfessor(Professor professor, Long id);

    void DeleteProfessor(Long id);
}
