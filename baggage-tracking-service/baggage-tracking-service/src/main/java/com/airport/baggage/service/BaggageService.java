package com.airport.baggage.service;

import com.airport.baggage.exception.BaggageNotFoundException;
import com.airport.baggage.model.Baggage;
import com.airport.baggage.repository.BaggageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaggageService {

    private final BaggageRepository baggageRepository;

    // Register new baggage
    public Baggage registerBaggage(Baggage baggage) {
        if (baggage.getTagNumber() == null || baggage.getTagNumber().isBlank()) {
            throw new IllegalArgumentException("Tag number must not be empty");
        }
        if (baggageRepository.existsByTagNumber(baggage.getTagNumber())) {
            throw new IllegalArgumentException("Baggage with tag number '"
                    + baggage.getTagNumber() + "' already exists");
        }
        if (baggage.getLocation() == null || baggage.getLocation().isBlank()) {
            baggage.setLocation("Check-in Counter");
        }
        if (baggage.getStatus() == null || baggage.getStatus().isBlank()) {
            baggage.setStatus("Checked In");
        }
        return baggageRepository.save(baggage);
    }

    // Get all baggage records
    public List<Baggage> getAllBaggage() {
        return baggageRepository.findAll();
    }

    // Track a specific bag by ID
    public Baggage getBaggageById(Integer id) {
        return baggageRepository.findById(id)
                .orElseThrow(() -> new BaggageNotFoundException(id));
    }

    // Update baggage location and/or status
    public Baggage updateBaggage(Integer id, Baggage updatedBaggage) {
        Baggage existing = baggageRepository.findById(id)
                .orElseThrow(() -> new BaggageNotFoundException(id));

        if (updatedBaggage.getLocation() != null && !updatedBaggage.getLocation().isBlank()) {
            existing.setLocation(updatedBaggage.getLocation());
        }
        if (updatedBaggage.getStatus() != null && !updatedBaggage.getStatus().isBlank()) {
            existing.setStatus(updatedBaggage.getStatus());
        }
        if (updatedBaggage.getWeight() != null) {
            existing.setWeight(updatedBaggage.getWeight());
        }

        return baggageRepository.save(existing);
    }

    // Get all baggage by passenger
    public List<Baggage> getBaggageByPassenger(Integer passengerId) {
        return baggageRepository.findByPassengerId(passengerId);
    }
}
