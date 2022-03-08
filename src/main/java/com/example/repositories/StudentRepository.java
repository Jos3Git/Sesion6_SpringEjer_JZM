package com.example.repositories;

import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> , JpaSpecificationExecutor<Student> {

    public Student findByFullName(String fullName);

    @Query("SELECT s FROM Student s WHERE s.grant=null")
    List<Student> findAllStudentsWithoutGrant();

    @Query(value = """
            SELECT * FROM students WHERE id NOT IN 
            (SELECT id_student FROM resources GROUP BY id_student)
            """
            ,nativeQuery = true)
    List<Student> findAllStudentsWithoutResources();

    @Query(value = """
            SELECT * FROM students WHERE id NOT IN 
            (SELECT id_student FROM rel_subject_student GROUP BY id_student)
            """
            ,nativeQuery = true)
    List<Student> findAllStudentsWithoutSubjects();
}