package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.Interface.ProfessorInterface;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Repository.Professor.ProfessorService;
import com.example.coursemanagement.Model.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/Professor")
public class ProfessorController {

    @Autowired
    @Qualifier("professorServiceImpt")
    private ProfessorService professorService;

    @Autowired
    @Qualifier("collegeServiceImpt")
    private CollegeService collegeService;

    @PostMapping
    public Object AddProfessor(@RequestBody ProfessorInterface professor){
        if(professorService.ExistProfessor(professor.getNcode())) return "Professor is Exist";

        Professor prof = new Professor(professor.getPname(),
                                       professor.getPfamily(),
                                       professor.getNcode(),
                                       collegeService.GetCollegeObjectById(professor.getClgid()));

        return professorService.AddProfessor(prof);
    }

    @GetMapping("/all")
    public Object GetAllProfessor(){
        return professorService.GetAllProfessor();
    }

    @PutMapping
    public Object UpdateProfessor(@RequestBody ProfessorInterface professor){
        return professorService.UpdateProfessor(new Professor(
                                                       professor.getpid(),
                                                       professor.getPname(),
                                                       professor.getPfamily(),
                                                       professor.getNcode(),
                                                       collegeService.GetCollegeObjectById(professor.getClgid())
                                                       ));
    }

    @DeleteMapping
    public void DeleteProfessor(@RequestBody Long id){
        professorService.DeleteProfessor(id);
    }
}
