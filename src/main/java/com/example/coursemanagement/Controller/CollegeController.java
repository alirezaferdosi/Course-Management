package com.example.coursemanagement.Controller;

import com.example.coursemanagement.Repository.College.CollegeService;
import com.example.coursemanagement.Model.College;

import org.springframework.beans.factory.annotation.Autowired;
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
    private CollegeService collegeService;

    @PostMapping
    public College AddCollege(@Valid @RequestBody College college){
        System.out.println("---------");
        return collegeService.AddCollege(college);
    }
//    @PostMapping
//    public College AddCollege(@Valid @RequestBody College college){
//        System.out.println("Lsofhsodhbalhksobhqlef");
//        System.out.println(college);
//        return collegeService.AddCollege(new College());
//    }

    @GetMapping("/all")
    public List<College> GetAllCollege(){
        return collegeService.GetAllCollege();
    }

    @GetMapping
    public College GetCollegeById(@PathVariable Long id){
        return collegeService.GetCollegeById(id);
    }

    @PutMapping
    public  College UpdateCollege(@Valid @RequestBody College college, Long id){
        return collegeService.UpdateCollege(college,id);
    }

    @DeleteMapping
    public void DeleteCollege(@RequestBody Long id){
        collegeService.DeleteCollege(id);
    }
}
