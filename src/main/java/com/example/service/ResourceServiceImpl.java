package com.example.service;

import com.example.model.Resource;
import com.example.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    ResourceRepository resourceRepository;

    @Override
    public Resource save(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public List<Resource> saveAll(List<Resource> resources) {
        return resourceRepository.saveAll(resources);
    }

    @Override
    public Optional<Resource> findById(Long id) {
        return resourceRepository.findById(id);
    }

    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        resourceRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Resource> resources) {
        resourceRepository.deleteAll();
    }

    @Override
    @Transactional
    public void fixResource(Long id) {
        resourceRepository.fixResource(id);
    }
}
