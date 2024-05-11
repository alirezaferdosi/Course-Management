package com.example.coursemanagement.Repository.College;
import com.example.coursemanagement.Model.College;

import java.util.List;
import org.springframework.stereotype.Component;


@Component("CollegeService")
public interface CollegeService {
    College AddCollege(College college);

    List<College> GetAllCollege();

    College GetCollegeById(Long id);

    College UpdateCollege(College college, Long id);

    void DeleteCollege(Long id);

    Boolean ExistCollege(String name);
}
