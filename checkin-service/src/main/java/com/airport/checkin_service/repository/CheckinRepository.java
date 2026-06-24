package com.airport.checkin_service.repository;

import com.airport.checkin_service.entity.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CheckinRepository extends JpaRepository<Checkin, Long>{

}
