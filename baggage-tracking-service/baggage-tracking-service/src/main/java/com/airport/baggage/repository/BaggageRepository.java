package com.airport.baggage.repository;

import com.airport.baggage.model.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage, Integer> {

    List<Baggage> findByPassengerId(Integer passengerId);

    List<Baggage> findByStatus(String status);

    boolean existsByTagNumber(String tagNumber);
}
