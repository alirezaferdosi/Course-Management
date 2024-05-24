package com.example.coursemanagement.Repository.Section;

import com.example.coursemanagement.Model.DTO.SectionDTO;
import com.example.coursemanagement.Model.Section;

import org.springframework.stereotype.Component;
import java.util.List;

@Component("SectionService")
public interface SectionService {
    SectionDTO AddSection(Section section);

    List<SectionDTO> GetAllSection();

    List<SectionDTO> GetAllSectionByCollegeId(String id);

    List<SectionDTO> GetAllSectionByProfessorId(String id);

    List<SectionDTO> GetAllSectionByStudentId(String id);

    List<SectionDTO> GetAllSectionByTerm(Integer term);

    SectionDTO UpdateSection(Section section);

    void DeleteSection(Long id);

    SectionDTO OutputFrame(Section section);
}
