package com.example.coursemanagement.Service;

import com.example.coursemanagement.Model.College;

import com.example.coursemanagement.Model.DTO.CollegeDTO;
import com.example.coursemanagement.Repository.College.CollegeRepository;
import com.example.coursemanagement.Repository.College.CollegeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeServiceImpt implements CollegeService {
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
    @Transactional
    public List<College> GetAllCollege() {
        List<College> list = new ArrayList<>();
        for(College clg: collegeRepository.findAll()){
            list.add(clg);
        }
        return list;
    }

    @Override
    @Transactional
    public College GetCollegeById(Long id){
        return GetCollegeObjectById(id);
    }

    @Override
    @Transactional
    public College UpdateCollege(College college) {
        College clg = collegeRepository.findById(college.getClgid()).get();

        if(college.getClgname() != null && !college.getClgname().equals("")){
            clg.setClgname(college.getClgname());
        }
        if(college.getHDepartment() != null && !college.getHDepartment().equals("")){
            clg.setHDepartment(college.getHDepartment());
        }

        return collegeRepository.save(clg);
    }

    @Override
    @Transactional
    public void DeleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean ExistCollege(String name) {
        for(College clg: collegeRepository.findAll()){
            if(clg.getClgname().equals(name)) return true;
        }
        return false;
    }

    @Override
    @Transactional
    public College GetCollegeObjectById(Long id){
        return collegeRepository.findById(id).get();
    }
}
