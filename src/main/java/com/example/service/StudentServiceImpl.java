package com.example.service;

import com.example.model.Student;
import com.example.model.Student_;
import com.example.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> saveAll(List<Student> students) {
        return studentRepository.saveAll(students);

    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAllPageable(Pageable page) {
        return studentRepository.findAll(page);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Student> students) {
        studentRepository.deleteAll(students);
    }

    @Override
    public Student findByFullName(String fullName) {
        return studentRepository.findByFullName(fullName);
    }

    @Override
    public List<Student> findAllStudentsWithoutGrant() {
        return studentRepository.findAllStudentsWithoutGrant();
    }

    @Override
    public List<Student> findAllStudentsWithoutResources() {
        return studentRepository.findAllStudentsWithoutResources();
    }

    @Override
    public List<Student> findAllStudentsWithoutSubjects() {
        return studentRepository.findAllStudentsWithoutSubjects();
    }

    @Override
    public List<Student> findAllWithGrantAndBirthDateConditionSpecs(){
        Specification<Student> spec = (root, query, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.isNotNull(root.get(Student_.GRANT)),
                        criteriaBuilder.greaterThanOrEqualTo(root.get(Student_.BIRTH_DATE), LocalDate.of(2007,1,1))
                );

        return this.studentRepository.findAll(spec);
    }


}
