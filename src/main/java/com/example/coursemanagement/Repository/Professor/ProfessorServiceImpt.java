package com.example.coursemanagement.Repository.Professor;

import com.example.coursemanagement.Model.Interface.ProfessorInterface;
import com.example.coursemanagement.Model.Professor;
import com.example.coursemanagement.Repository.College.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProfessorServiceImpt implements ProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private CollegeRepository collegeRepository;


    @Override
    public ProfessorInterface AddProfessor(Professor professor) {
        return OutputFrame(professorRepository.save(professor));
    }

    @Override
    public List<ProfessorInterface> GetAllProfessor() {
        List<ProfessorInterface> list = new ArrayList<>();
        for(Professor prof: professorRepository.findAll()){
            list.add(OutputFrame(prof));
        }
        return list;
    }

    @Override
    public ProfessorInterface GetProfessorbyId(Long id){
        return OutputFrame(GetProfessorObjectById(id));
    }

    @Override
    public Professor GetProfessorObjectById(Long id){
         System.out.println(professorRepository.findById(id).get().getNcode());
         return professorRepository.findById(id).get();
    }

    @Override
    public ProfessorInterface UpdateProfessor(Professor professor) {
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

        return OutputFrame(professorRepository.save(prof));
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

    @Override
    public ProfessorInterface OutputFrame(Professor professor){
        return new ProfessorInterface(
                                     professor.getpid(),
                                     professor.getPname(),
                                     professor.getPfamily(),
                                     professor.getNcode(),
                                     professor.getClgid().getClgid()
                                     );
    }
}
