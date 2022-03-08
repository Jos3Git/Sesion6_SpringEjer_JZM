package com.example.repositories;

import com.example.model.Grant;
import com.example.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrantRepository extends JpaRepository<Grant, Long> {

    @Modifying
    @Query(value ="INSERT INTO grants (quantity,type) VALUES(:quantity,:type)" ,nativeQuery = true)
    void insertGrant(Double quantity,String type);

    @Query(value ="UPDATE grants SET quantity= :quantity WHERE id= :id" ,nativeQuery = true)
    @Modifying
    void updateQuantity(Long id, Double quantity);
}