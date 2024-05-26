package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.DTO.Converter.ConvertObject;
import com.example.coursemanagement.Model.DTO.SectionDTO;
import com.example.coursemanagement.Model.*;
import com.example.coursemanagement.Repository.Course.CourseService;
import com.example.coursemanagement.Repository.Section.*;

import com.example.coursemanagement.Repository.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Component
@RestController
@RequestMapping("/Section")
public class SectionController {

    @Autowired
    @Qualifier("sectionServiceImpt")
    private SectionService sectionService;

    @Autowired
    @Qualifier("SectionConverter")
    private ConvertObject<Section,SectionDTO> convertObject;


    @PostMapping
    public SectionDTO AddSection(@RequestBody SectionDTO section){
        return convertObject.ConvertEntityToDto(sectionService.AddSection(convertObject.ConvertDtoToEntity(section)));
    }

    @GetMapping
    public List<SectionDTO> GetAllSection(){
        return  sectionService.GetAllSection()
                .stream()
                .map(item -> convertObject.ConvertEntityToDto(item))
                .toList();
    }

    @GetMapping("ByCollegeId")
    public List<SectionDTO> GetAllSectionByCollegeId(@RequestBody Long id){
        return sectionService.GetAllSectionByCollegeId(id)
                .stream()
                .map(item -> convertObject.ConvertEntityToDto(item))
                .toList();
    }

    @GetMapping("ByProfessorId")
    public List<SectionDTO> GetAllSectionByProfessorId(@RequestBody Long id){
        return sectionService.GetAllSectionByProfessorId(id)
                .stream()
                .map(item -> convertObject.ConvertEntityToDto(item))
                .toList();
    }

    @GetMapping("ByStudentId")
    public List<SectionDTO> GetAllSectionByStudentId(@RequestBody Long id){
        return sectionService.GetAllSectionByStudentId(id)
                .stream()
                .map(item -> convertObject.ConvertEntityToDto(item))
                .toList();
    }

    @GetMapping("ByTerm")
    public List<SectionDTO> GetAllSectionByTerm(@RequestBody Integer term){
        return sectionService.GetAllSectionByTerm(term)
                .stream()
                .map(item -> convertObject.ConvertEntityToDto(item))
                .toList();
    }

    @PutMapping
    public SectionDTO UpdateSection(@RequestBody SectionDTO section){
        return convertObject.ConvertEntityToDto(sectionService.UpdateSection(convertObject.ConvertDtoToEntity(section)));
    }

    @DeleteMapping
    public void DeleteSection(@RequestBody String id){
        sectionService.DeleteSection(Long.valueOf(id));
    }


}
