package com.example.coursemanagement.Service;

import com.example.coursemanagement.Model.DTO.SectionDTO;
import com.example.coursemanagement.Model.Section;
import com.example.coursemanagement.Repository.Course.CourseRepository;
import com.example.coursemanagement.Repository.Section.SectionRepository;
import com.example.coursemanagement.Repository.Section.SectionService;
import com.example.coursemanagement.Repository.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SectionServiceImpt implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public SectionDTO AddSection(Section section) {
        return OutputFrame(sectionRepository.save(section));
    }

    @Override
    public List<SectionDTO> GetAllSection() {
        List<SectionDTO> list = new ArrayList<>();
        for (Section sec : sectionRepository.findAll()) {
            list.add(OutputFrame(sec));
        }
        return list;
    }

    @Override
    public List<SectionDTO> GetAllSectionByCollegeId(String id) {
        List<SectionDTO> list = new ArrayList();
        for (Section sec : sectionRepository.findAll()) {
            if (sec.getCourse().getClg().getClgid().equals(id)) {
                list.add(OutputFrame(sec));
            }
        }
        return list;
    }

    @Override
    public List<SectionDTO> GetAllSectionByProfessorId(String id) {

        List<SectionDTO> list = new ArrayList();
        for (Section sec : sectionRepository.findAll()) {
            if (sec.getCourse().getProf().getpid().equals(id)) {
                list.add(OutputFrame(sec));
            }
        }
        return list;
    }

    @Override
    public List<SectionDTO> GetAllSectionByStudentId(String id) {
        List<SectionDTO> list = new ArrayList();
        for (Section sec : sectionRepository.findAll()) {
            if (sec.getStudent().getSid().equals(id)) {
                list.add(OutputFrame(sec));
            }
        }
        return list;
    }

    @Override
    public List<SectionDTO> GetAllSectionByTerm(Integer term) {
        List<SectionDTO> list = new ArrayList();
        for (Section sec : sectionRepository.findAll()) {
            if (Objects.equals(sec.getTerm(), term)) {
                list.add(OutputFrame(sec));
            }
        }
        return list;
    }

    @Override
    public SectionDTO UpdateSection(Section section) {
        Section sec = null;
        for (Section s : sectionRepository.findAll()) {
            if (s.getId() == section.getId()) sec = s;
        }

        if (sec == null) return null;

        if (section.getCourse() != null && !section.getCourse().getCid().equals("")) {
            sec.setCourse(section.getCourse());
        }
        if (section.getStudent() != null && !section.getStudent().getSid().equals("")) {
            sec.setStudent(section.getStudent());
        }
        if (section.getTerm() != null && !section.getTerm().equals("")) {
            sec.setTerm(section.getTerm());
        }
        if (section.getScore() != null) {
            sec.setScore(section.getScore());
        }

        return OutputFrame(sectionRepository.save(sec));
    }

    @Override
    public void DeleteSection(Long id) {
        for(Section sec: sectionRepository.findAll()){
            if(sec.getId() == id) sectionRepository.delete(sec);
        }
    }

    @Override
    public SectionDTO OutputFrame(Section section){
        return new SectionDTO(
                                    section.getId(),
                                    section.getCourse().getCid(),
                                    section.getStudent().getSid(),
                                    section.getScore(),
                                    section.getTerm()
                                    );
    }
}
