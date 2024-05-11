package com.example.coursemanagement.Repository.Student;

import com.example.coursemanagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}
