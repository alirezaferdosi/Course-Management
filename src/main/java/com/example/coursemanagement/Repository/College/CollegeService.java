package com.example.coursemanagement.Repository.College;
import com.example.coursemanagement.Model.College;

import java.util.List;

import com.example.coursemanagement.Model.Interface.CollegeInterface;
import org.springframework.stereotype.Component;


@Component("CollegeService")
public interface CollegeService {
    CollegeInterface AddCollege(College college);

    List<CollegeInterface> GetAllCollege();

    College GetCollegeObjectById(Long id);

    CollegeInterface GetCollegeById(Long id);

    CollegeInterface UpdateCollege(College college);

    void DeleteCollege(Long id);

    Boolean ExistCollege(String name);

    CollegeInterface OutputFrame(College clg);
}
