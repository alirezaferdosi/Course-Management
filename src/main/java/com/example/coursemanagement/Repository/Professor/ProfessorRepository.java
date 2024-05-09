package com.example.coursemanagement.Repository.Professor;

import com.example.coursemanagement.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
}
