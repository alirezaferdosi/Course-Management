package com.example.coursemanagement.Repository.Professor;

import com.example.coursemanagement.Model.College;
import com.example.coursemanagement.Model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorServiceImpt implements ProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor AddProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> GetAllProfessor() {
        return professorRepository.findAll();
    }

    @Override
    public List<Professor> GetAllProfessor(College college) {
        return professorRepository.findAllById((Iterable<Long>) college);
    }

    @Override
    public Professor UpdateProfessor(Professor professor, Long id) {
        Professor prof = professorRepository.findById(id).get();

        if(Objects.nonNull(professor.getPname()) && !professor.getPname().equals("")){
            prof.setPname(professor.getPname());
        }
        if(Objects.nonNull(professor.getPfamily()) && !professor.getPfamily().equals("")){
            prof.setPfamily(professor.getPfamily());
        }
        if(Objects.nonNull(professor.getNcode()) && !professor.getNcode().equals("")){
            prof.setPname(professor.getNcode());
        }

        return professorRepository.save(prof);
    }

    @Override
    public void DeleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}
