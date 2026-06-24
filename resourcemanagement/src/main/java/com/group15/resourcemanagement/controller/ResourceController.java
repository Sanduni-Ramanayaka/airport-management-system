package com.group15.resourcemanagement.controller;

import com.group15.resourcemanagement.entity.Resource;
import com.group15.resourcemanagement.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @PostMapping
    public Resource add(@RequestBody Resource resource) {
        return service.save(resource);
    }

    @GetMapping
    public List<Resource> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Resource getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Resource update(@PathVariable Long id,
                           @RequestBody Resource resource) {
        return service.update(id, resource);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}