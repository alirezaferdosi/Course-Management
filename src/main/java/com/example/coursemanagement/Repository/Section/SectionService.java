package com.example.coursemanagement.Repository.Section;

import com.example.coursemanagement.Model.Interface.SectionInterface;
import com.example.coursemanagement.Model.Section;

import org.springframework.stereotype.Component;
import java.util.List;

@Component("SectionService")
public interface SectionService {
    SectionInterface AddSection(Section section);

    List<SectionInterface> GetAllSection();

    List<SectionInterface> GetAllSectionByCollegeId(String id);

    List<SectionInterface> GetAllSectionByProfessorId(String id);

    List<SectionInterface> GetAllSectionByStudentId(String id);

    List<SectionInterface> GetAllSectionByTerm(Integer term);

    SectionInterface UpdateSection(Section section);

    void DeleteSection(Long id);

    SectionInterface OutputFrame(Section section);
}
