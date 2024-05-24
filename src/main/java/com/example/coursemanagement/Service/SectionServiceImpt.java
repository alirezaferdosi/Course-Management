package com.example.coursemanagement.Service;

import com.example.coursemanagement.Model.DTO.SectionDTO;
import com.example.coursemanagement.Model.Section;
import com.example.coursemanagement.Repository.Course.CourseRepository;
import com.example.coursemanagement.Repository.Section.SectionRepository;
import com.example.coursemanagement.Repository.Section.SectionService;
import com.example.coursemanagement.Repository.Student.StudentRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Section AddSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    @Transactional
    public List<Section> GetAllSection() {
        List<Section> list = new ArrayList<>();
        for (Section sec : sectionRepository.findAll()) {
            list.add(sec);
        }
        return list;
    }

    @Override
    @Transactional
    public List<Section> GetAllSectionByCollegeId(String id) {
        List<Section> list = new ArrayList();
        for (Section sec : sectionRepository.findAll()) {
            if (sec.getCourse().getClg().getClgid().equals(id)) {
                list.add(sec);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public List<Section> GetAllSectionByProfessorId(String id) {

        List<Section> list = new ArrayList();
        for (Section sec : sectionRepository.findAll()) {
            if (sec.getCourse().getProf().getPid().equals(id)) {
                list.add(sec);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public List<Section> GetAllSectionByStudentId(String id) {
        List<Section> list = new ArrayList();
        for (Section sec : sectionRepository.findAll()) {
            if (sec.getStudent().getSid().equals(id)) {
                list.add(sec);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public List<Section> GetAllSectionByTerm(Integer term) {
        List<Section> list = new ArrayList();
        for (Section sec : sectionRepository.findAll()) {
            if (Objects.equals(sec.getTerm(), term)) {
                list.add(sec);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Section UpdateSection(Section section) {
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

        return sectionRepository.save(sec);
    }

    @Override
    @Transactional
    public void DeleteSection(Long id) {
        for(Section sec: sectionRepository.findAll()){
            if(sec.getId() == id) sectionRepository.delete(sec);
        }
    }
}
