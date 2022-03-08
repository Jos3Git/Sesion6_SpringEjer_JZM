package com.example.service;

import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student save(Student student);
    public List<Student> saveAll(List<Student> students);
    public Optional<Student> findById(Long id);
    public List<Student> findAll();
    public Page<Student> findAllPageable(Pageable page);
    public void deleteById(Long id);
    public void deleteAll(List<Student> students);

    public Student findByFullName(String fullName);

    public List<Student> findAllStudentsWithoutGrant();
    public List<Student> findAllStudentsWithoutResources();
    public List<Student> findAllStudentsWithoutSubjects();

    public List<Student> findAllWithGrantAndBirthDateConditionSpecs();
}
