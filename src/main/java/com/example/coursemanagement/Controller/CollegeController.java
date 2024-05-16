package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Model.Interface.CollegeInterface;
import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Model.College;

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


    @PostMapping
    public Object AddCollege(@Valid @RequestBody CollegeInterface college){
        if(collegeService.ExistCollege(college.getClgname())) return "College is exist";

        if(college.getHDepartment() != null){
            return collegeService.AddCollege(new College(
                                                        college.getClgname(),
                                                        professorService.GetProfessorObjectById(college.getHDepartment())
                                                        ));
        }else{
            return collegeService.AddCollege(new College(college.getClgname()));
        }

    }

    @GetMapping("/all")
    public List<CollegeInterface> GetAllCollege(){
        return collegeService.GetAllCollege();
    }

    @GetMapping("/{id}")
    public CollegeInterface GetCollegeById(@PathVariable("id") Long id){
        return collegeService.GetCollegeById(id);
    }

    @PutMapping()
    public Object UpdateCollege(@Valid @RequestBody CollegeInterface college){
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
