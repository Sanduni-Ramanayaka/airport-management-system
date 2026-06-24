package com.airport.flightservice;

import com.airport.flightservice.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface FlightRepository
        extends JpaRepository<Flight, Long> {

    boolean existsByGateNumberAndDepartureTime(
            String gateNumber,
            LocalDateTime departureTime
    );
}