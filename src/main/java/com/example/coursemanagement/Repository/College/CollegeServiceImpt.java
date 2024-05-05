package com.example.coursemanagement.Repository.College;

import com.example.coursemanagement.Model.College;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
//@Component
public class CollegeServiceImpt implements CollegeService{

    @Autowired
    CollegeRepository collegeRepository;

    @Override
    @Transactional
    public College AddCollege(College college) {
        return collegeRepository.save(college);
//        collegeRepository.flush();
//        return object;
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

        if(Objects.nonNull(college.getClgname()) && !college.getClgname().equals("")){
            clg.setClggename(college.getClgname());
        }

        if(Objects.nonNull(college.getHDepartment()) && !college.getHDepartment().equals("")){
            clg.setHDepartment(clg.getHDepartment());
        }

        return collegeRepository.save(clg);
    }

    @Override
    public void DeleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
