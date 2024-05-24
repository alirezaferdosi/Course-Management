package com.example.coursemanagement.Service;

import com.example.coursemanagement.Model.DTO.ProfessorDTO;
import com.example.coursemanagement.Model.Professor;
import com.example.coursemanagement.Repository.College.CollegeRepository;
import com.example.coursemanagement.Repository.Professor.ProfessorRepository;
import com.example.coursemanagement.Repository.Professor.ProfessorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProfessorServiceImpt implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CollegeRepository collegeRepository;


    @Override
    @Transactional
    public Professor AddProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    @Transactional
    public List<Professor> GetAllProfessor() {
        List<Professor> list = new ArrayList<>();
        for(Professor prof: professorRepository.findAll()){
            list.add(prof);
        }
        return list;
    }

    @Override
    @Transactional
    public Professor GetProfessorbyId(Long id){
        return GetProfessorObjectById(id);
    }

    @Override
    @Transactional
    public Professor GetProfessorObjectById(Long id){
         System.out.println(professorRepository.findById(id).get().getNcode());
         return professorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Professor UpdateProfessor(Professor professor) {
        Professor prof = professorRepository.findById(professor.getPid()).get();

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
    @Transactional
    public void DeleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean ExistProfessor(String ncode){
        for(Professor prof: professorRepository.findAll()){
            if(prof.getNcode().equals(ncode)) return true;
        }
        return false;
    }
}
