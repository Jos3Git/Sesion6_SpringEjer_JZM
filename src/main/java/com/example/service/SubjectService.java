package com.example.service;

import com.example.model.Resource;
import com.example.model.Student;
import com.example.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    public Subject save(Subject subject);
    public List<Subject> saveAll(List<Subject> subjects);
    public Optional<Subject> findById(Long id);
    public List<Subject> findAll();
    public void deleteById(Long id);
    public void deleteAll(List<Subject> subjects);

    public Subject findByIdWithStudent(Long id);


}
