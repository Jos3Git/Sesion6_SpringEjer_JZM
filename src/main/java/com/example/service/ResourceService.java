package com.example.service;

import com.example.model.Grant;
import com.example.model.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService {

    public Resource save(Resource resource);
    public List<Resource> saveAll(List<Resource> resources);
    public Optional<Resource> findById(Long id);
    public List<Resource> findAll();
    public void deleteById(Long id);
    public void deleteAll(List<Resource> resources);

    public void fixResource(Long id);

}
