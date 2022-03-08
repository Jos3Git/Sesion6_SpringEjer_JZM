package com.example.service;

import com.example.model.Grant;
import com.example.model.Student;

import java.util.List;
import java.util.Optional;

public interface GrantService {
    public Grant save(Grant grant);
    public List<Grant> saveAll(List<Grant> grants);
    public Optional<Grant> findById(Long id);
    public List<Grant> findAll();
    public void deleteById(Long id);
    public void deleteAll(List<Grant> grants);

    public void insertGrant(Double quantity,String type);
    public void updateQuantity(Long id,Double quantity);



}
