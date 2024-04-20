package com.example.coursemanagement.Repository.College;

import com.example.coursemanagement.Model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface CollegeRepository extends JpaRepository<College, Long> {

}

