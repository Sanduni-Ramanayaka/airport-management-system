package com.group15.resourcemanagement.service;

import com.group15.resourcemanagement.entity.Resource;
import com.group15.resourcemanagement.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repository;

    public Resource save(Resource resource) {
        return repository.save(resource);
    }

    public List<Resource> getAll() {
        return repository.findAll();
    }

    public Resource getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Resource update(Long id, Resource resource) {
        resource.setResourceId(id);
        return repository.save(resource);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}