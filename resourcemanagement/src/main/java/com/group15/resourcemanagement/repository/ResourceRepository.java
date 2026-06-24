package com.group15.resourcemanagement.repository;

import com.group15.resourcemanagement.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}