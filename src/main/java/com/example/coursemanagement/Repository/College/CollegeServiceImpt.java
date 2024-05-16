package com.example.coursemanagement.Repository.College;

import com.example.coursemanagement.Model.College;

import com.example.coursemanagement.Model.Interface.CollegeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeServiceImpt implements CollegeService{
    @Autowired
    CollegeRepository collegeRepository;


    @Override
    public CollegeInterface AddCollege(College college) {
        if(college.getClgid() != null){
            return null;
        }
        return OutputFrame(collegeRepository.save(college));
    }

    @Override
    public List<CollegeInterface> GetAllCollege() {
        List<CollegeInterface> list = new ArrayList<>();
        for(College clg: collegeRepository.findAll()){
            list.add(OutputFrame(clg));
        }
        return list;
    }

    @Override
    public CollegeInterface GetCollegeById(Long id){
        return OutputFrame(GetCollegeObjectById(id));
    }

    @Override
    public CollegeInterface UpdateCollege(College college) {
        College clg = collegeRepository.findById(college.getClgid()).get();

        if(college.getClgname() != null && !college.getClgname().equals("")){
            clg.setClggename(college.getClgname());
        }
        if(college.getHDepartment() != null && !college.getHDepartment().equals("")){
            clg.setHDepartment(college.getHDepartment());
        }

        return OutputFrame(collegeRepository.save(clg));
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

    @Override
    public College GetCollegeObjectById(Long id){
        return collegeRepository.findById(id).get();
    }

    @Override
    public CollegeInterface OutputFrame(College clg) {
        return new CollegeInterface(
                clg.getClgid(),
                clg.getClgname(),
                clg.getHDepartment().getpid()
        );
    }

}
