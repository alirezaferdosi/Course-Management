package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Model.College;

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
    private Long id;

    @PostMapping
    public College AddCollege(@Valid @RequestBody College college){
        return collegeService.AddCollege(college);
    }

    @GetMapping("/all")
    public List<College> GetAllCollege(){
        return collegeService.GetAllCollege();
    }

    @GetMapping("/{id}")
    public College GetCollegeById(@PathVariable("id") Long id){
        return collegeService.GetCollegeById(id);
    }

    @PutMapping("/{id}")
    public  College UpdateCollege(@Valid @RequestBody College college, @PathVariable("id") Long id){
        this.id = id;
        return collegeService.UpdateCollege(college,id);
    }

    @DeleteMapping
    public void DeleteCollege(@RequestBody Long id){
        collegeService.DeleteCollege(id);
    }
}
