package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.DTO.CollegeDTO;
import com.example.coursemanagement.Model.DTO.Converter.ConvertObject;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Model.College;
import com.example.coursemanagement.Model.DTO.Converter.CollegeConverter;

import com.example.coursemanagement.Repository.Professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

/**
 *  This class manages all requests related to the university.
 */
@Component
@RestController
@RequestMapping("/College")
public class CollegeController {

    @Autowired
    @Qualifier("collegeServiceImpt")
    private CollegeService collegeService;

    @Autowired
    @Qualifier("professorServiceImpt")
    private ProfessorService professorService;

    @Autowired
    @Qualifier("CollegeConverter")
    private ConvertObject<College,CollegeDTO> convertObject;


    @PostMapping
    public Object AddCollege(@Valid @RequestBody CollegeDTO college){
        if(collegeService.ExistCollege(college.getClgname())) return "College is exist";

        if(college.getHDepartment() != null){
            return collegeService.AddCollege(convertObject.ConvertDtoToEntity(college));
        }else{
            return collegeService.AddCollege(convertObject.ConvertDtoToEntity(college));
        }

    }

    @GetMapping("/all")
    public List<CollegeDTO> GetAllCollege(){
        return collegeService.GetAllCollege()
                                            .stream()
                                            .map(item -> convertObject.ConvertEntityToDto(item)).toList();
    }

    @GetMapping("/{id}")
    public CollegeDTO GetCollegeById(@PathVariable("id") Long id){
        return convertObject.ConvertEntityToDto(collegeService.GetCollegeById(id));
    }

    @PutMapping()
    public Object UpdateCollege(@Valid @RequestBody CollegeDTO college){
        if(collegeService.ExistCollege(college.getClgname())) return "College is exist";

        return collegeService.UpdateCollege(new College(
                                                        college.getClgid(),
                                                        college.getClgname(),
                                                        professorService.GetProfessorObjectById(college.getHDepartment())
                                                        ));
    }

    @DeleteMapping
    public void DeleteCollege(@RequestBody Long id){
        collegeService.DeleteCollege(id);
    }
}
