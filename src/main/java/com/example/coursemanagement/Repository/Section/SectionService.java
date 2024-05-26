package com.example.coursemanagement.Repository.Section;

import com.example.coursemanagement.Model.DTO.SectionDTO;
import com.example.coursemanagement.Model.Section;

import org.springframework.stereotype.Component;
import java.util.List;

@Component("SectionService")
public interface SectionService {
    Section AddSection(Section section);

    List<Section> GetAllSection();

    List<Section> GetAllSectionByCollegeId(Long id);

    List<Section> GetAllSectionByProfessorId(Long id);

    List<Section> GetAllSectionByStudentId(Long id);

    List<Section> GetAllSectionByTerm(Integer term);

    Section UpdateSection(Section section);

    void DeleteSection(Long id);
}
