package com.example.coursemanagement.Repository.Section;

import com.example.coursemanagement.Model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpt implements SectionService{

    @Autowired
    private SectionRepository sectionRepository;


    @Override
    public Section AddSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> GetAllSection() {
        return sectionRepository.findAll();
    }

    @Override
    public List<Section> GetAllSectionByCollegeID(Long id) {
        List<Section> list = new ArrayList();
        for(Section sec: sectionRepository.findAll()){
            if(sec.getCourse().getClgid().getClgid() == id){
                list.add(sec);
            }
        }
        return list;
    }

    @Override
    public List<Section> GetAllSectionByProfessorId(Long id) {
        List<Section> list = new ArrayList();
        for(Section sec: sectionRepository.findAll()){
            if(sec.getCourse().getProfid().getpid() == id){
                list.add(sec);
            }
        }
        return list;    }

    @Override
    public List<Section> GetAllSectionByStudentId(Long id) {
        List<Section> list = new ArrayList();
        for(Section sec: sectionRepository.findAll()){
            if(sec.getStudent().getSid() == id){
                list.add(sec);
            }
        }
        return list;    }

    @Override
    public List<Section> GetAllSectionByTerm(Integer term) {
        List<Section> list = new ArrayList();
        for(Section sec: sectionRepository.findAll()){
            if(sec.getTerm()== term){
                list.add(sec);
            }
        }
        return list;    }

    @Override
    public Section UpdateSection(Section section) {
        return null;
    }

    @Override
    public void DeleteSection(Long id) {

    }
}
