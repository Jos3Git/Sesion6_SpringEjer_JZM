package com.example.repositories;

import com.example.model.Student;
import com.example.model.Subject;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @EntityGraph(attributePaths = {"students","grant"})
    @Query("select s from Subject s where s.id = :id")
    Subject findByIdWithStudent(Long id);
}