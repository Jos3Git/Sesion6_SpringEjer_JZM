package com.example.service;

import com.example.model.Grant;
import com.example.repositories.GrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GrantServiceImpl implements GrantService{

    @Autowired
    GrantRepository grantRepository;

    @Override
    public Grant save(Grant grant) {
        return grantRepository.save(grant);
    }

    @Override
    public List<Grant> saveAll(List<Grant> grants) {
        return grantRepository.saveAll(grants);
    }

    @Override
    public Optional<Grant> findById(Long id) {
        return grantRepository.findById(id);
    }

    @Override
    public List<Grant> findAll() {
        return grantRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        grantRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Grant> grants) {
        grantRepository.deleteAll(grants);
    }

    @Override
    @Transactional
    public void insertGrant(Double quantity,String type) {
        grantRepository.insertGrant(quantity,type);
    }

    @Override
    @Transactional
    public void updateQuantity(Long id, Double quantity) {
        grantRepository.updateQuantity(id,quantity);
    }
}
