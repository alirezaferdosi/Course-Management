package com.example.coursemanagement.Repository.Section;

import com.example.coursemanagement.Model.Interface.SectionInterface;
import com.example.coursemanagement.Model.Section;
import com.example.coursemanagement.Repository.College.OutputFrame;
import com.example.coursemanagement.Repository.Course.CourseRepository;
import com.example.coursemanagement.Repository.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SectionServiceImpt implements SectionService{

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public SectionInterface AddSection(Section section) {
        return OutputFrame(sectionRepository.save(section));
    }

    @Override
    public List<SectionInterface> GetAllSection() {
        List<SectionInterface> list = new ArrayList<>();
        for(Section sec: sectionRepository.findAll()){
            list.add(OutputFrame(sec));
        }
        return list;
    }

    @Override
    public List<SectionInterface> GetAllSectionByCollegeId(String id) {
        List<SectionInterface> list = new ArrayList();
        for(Section sec: sectionRepository.findAll()){
            if(sec.getCourse().getClg().getClgid().equals(id)){
                list.add(OutputFrame(sec));
            }
        }
        return list;
    }

    @Override
    public List<SectionInterface> GetAllSectionByProfessorId(String id) {

        List<SectionInterface> list = new ArrayList();
        for(Section sec: sectionRepository.findAll()){
            if(sec.getCourse().getProf().getpid().equals(id)){
                list.add(OutputFrame(sec));
            }
        }
        return list;    }

    @Override
    public List<SectionInterface> GetAllSectionByStudentId(String id) {
        List<SectionInterface> list = new ArrayList();
        for(Section sec: sectionRepository.findAll()){
            if(sec.getStudent().getSid().equals(id)){
                list.add(OutputFrame(sec));
            }
        }
        return list;    }

    @Override
    public List<SectionInterface> GetAllSectionByTerm(Integer term) {
        List<SectionInterface> list = new ArrayList();
        for(Section sec: sectionRepository.findAll()){
            if(Objects.equals(sec.getTerm(), term)){
                list.add(OutputFrame(sec));
            }
        }
        return list;    }

    @Override
    public SectionInterface UpdateSection(Section section) {
        Section sec = null;
        for(Section s: sectionRepository.findAll()){
            if(Objects.equals(s.getId(), section.getId())) sec = s;
        }
        if(sec == null) return null;

        if(section.getCourse() != null && !section.getCourse().getCid().equals("")){
            sec.setCourse(section.getCourse());
        }
        if(section.getStudent() != null && !section.getStudent().getSid().equals("")){
            sec.setStudent(section.getStudent());
        }
        if(section.getTerm() != null && !section.getTerm().equals("")){
            sec.setTerm(section.getTerm());
        }
        if(section.getScore() != null){
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
    public SectionInterface OutputFrame(Section section){
        return new SectionInterface(
                                    section.getId(),
                                    section.getCourse().getCid(),
                                    section.getStudent().getSid(),
                                    section.getScore(),
                                    section.getTerm()
                                    );
    }
}
