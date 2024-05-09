package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Repository.Professor.ProfessorService;
import com.example.coursemanagement.Model.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/Professor")
public class ProfessorController {

    @Autowired
    @Qualifier("professorServiceImpt")
    private ProfessorService professorService;

    @PostMapping
    public Professor AddProfessor(@RequestBody Professor professor){
        return  professorService.AddProfessor(professor);
    }
}
