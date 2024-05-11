package com.example.coursemanagement.Repository.College;

import com.example.coursemanagement.Model.College;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpt implements CollegeService{

    @Autowired
    CollegeRepository collegeRepository;

    @Override
    @Transactional
    public College AddCollege(College college) {
        if(college.getClgid() != null){
            return null;
        }
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
        if(college.getHDepartment() != null && !college.getHDepartment().equals("")){
            clg.setHDepartment(college.getHDepartment());
        }

        return collegeRepository.save(clg);
    }

    @Override
    public void DeleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }

    @Override
    public Boolean ExistCollege(String name) {
        for(College clg: collegeRepository.findAll()){
            if(clg.getClgname().equals(name)) return true;
        }
        return false;
    }

}
