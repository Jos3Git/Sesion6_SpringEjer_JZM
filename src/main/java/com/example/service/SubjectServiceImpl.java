package com.example.service;

import com.example.model.Student;
import com.example.model.Subject;
import com.example.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> saveAll(List<Subject> subjects) {
        return subjectRepository.saveAll(subjects);
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Subject> subjects) {
        subjectRepository.deleteAll();
    }

    @Override
    public Subject findByIdWithStudent(Long id){
        return subjectRepository.findByIdWithStudent(id);
    }
}
