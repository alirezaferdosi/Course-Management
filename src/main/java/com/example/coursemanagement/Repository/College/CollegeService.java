package com.example.coursemanagement.Repository.College;
import com.example.coursemanagement.Model.College;

import java.util.List;

import com.example.coursemanagement.Model.DTO.CollegeDTO;
import org.springframework.stereotype.Component;


@Component("CollegeService")
public interface CollegeService {
    College AddCollege(College college);

    List<College> GetAllCollege();

    College GetCollegeObjectById(Long id);

    College GetCollegeById(Long id);

    College UpdateCollege(College college);

    void DeleteCollege(Long id);

    Boolean ExistCollege(String name);

//    CollegeDTO OutputFrame(College clg);
}
