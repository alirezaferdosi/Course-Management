package com.example.coursemanagement.Repository.College;

import com.example.coursemanagement.Model.College;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Objects;

@Service
public class CollegeServiceImpt implements CollegeService{

    @Autowired
    CollegeRepository collegeRepository;

    @Override
    @Transactional
    public College AddCollege(College college) {
        return collegeRepository.save(college);
    }

    @Override
    public List<College> GetAllCollege() {
        return collegeRepository.findAll();
    }

    @Override
    public College GetCollegeById(Long id) {
        return collegeRepository.findById(id).get();
    }

    @Override
    public College UpdateCollege(College college, Long id) {
        College clg = collegeRepository.findById(id).get();

        if(college.getClgname() != null && !college.getClgname().equals("") ){
            clg.setClggename(college.getClgname());
        }
        System.out.println(college.getHDepartment());
        if(college.getHDepartment() != null && !college.getHDepartment().equals("")){
            clg.setHDepartment(college.getHDepartment());
        }

        return collegeRepository.save(clg);
    }

    @Override
    public void DeleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
