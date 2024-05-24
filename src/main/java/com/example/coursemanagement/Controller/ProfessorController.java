package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.DTO.Converter.ConvertObject;
import com.example.coursemanagement.Model.DTO.ProfessorDTO;
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
    @Qualifier("ProfessorConverter")
    private ConvertObject<Professor,ProfessorDTO> convertObject;


    @PostMapping
    public Object AddProfessor(@RequestBody ProfessorDTO professor){
        if(professorService.ExistProfessor(professor.getNcode()))
        return "Professor is Exist";
        return convertObject.ConvertEntityToDto(professorService.AddProfessor(convertObject.ConvertDtoToEntity(professor)));
    }

    @GetMapping("/all")
    public Object GetAllProfessor(){
        return professorService.GetAllProfessor()
                .stream()
                .map(item -> convertObject.ConvertEntityToDto(item))
                .toList();
    }

    @PutMapping
    public Object UpdateProfessor(@RequestBody ProfessorDTO professor){
        return  convertObject.ConvertEntityToDto(professorService.UpdateProfessor(convertObject.ConvertDtoToEntity(professor)));
    }

    @DeleteMapping
    public void DeleteProfessor(@RequestBody Long id){
        professorService.DeleteProfessor(id);
    }
}
