package com.example.repositories;

import com.example.model.Resource;
import com.example.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Modifying
    @Query(value = "UPDATE resources SET broken=false WHERE id= :id" ,nativeQuery = true)
    void fixResource(Long id);
}