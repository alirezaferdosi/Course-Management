package com.example.coursemanagement.Repository.Professor;

import com.example.coursemanagement.Model.College;
import com.example.coursemanagement.Model.Professor;
import com.example.coursemanagement.Repository.College.CollegeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorServiceImpt implements ProfessorService{

    private final ProfessorRepository professorRepository;

    private final CollegeRepository collegeRepository;

    public ProfessorServiceImpt(ProfessorRepository professorRepository, CollegeRepository collegeRepository) {
        this.professorRepository = professorRepository;
        this.collegeRepository = collegeRepository;
    }

    @Override
    public Professor AddProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> GetAllProfessor() {
        return professorRepository.findAll();
    }

    @Override
    public Professor UpdateProfessor(Professor professor) {
        Professor prof = professorRepository.findById(professor.getpid()).get();

        if(Objects.nonNull(professor.getPname()) && !professor.getPname().equals("")){
            prof.setPname(professor.getPname());
        }
        if(Objects.nonNull(professor.getPfamily()) && !professor.getPfamily().equals("")){
            prof.setPfamily(professor.getPfamily());
        }
        if(Objects.nonNull(professor.getNcode()) && !professor.getNcode().equals("")){
            prof.setNcode(professor.getNcode());
        }

        return professorRepository.save(prof);
    }

    @Override
    public void DeleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public Boolean ExistProfessor(String ncode){
        for(Professor prof: professorRepository.findAll()){
            if(prof.getNcode().equals(ncode)) return true;
        }
        return false;
    }
}
