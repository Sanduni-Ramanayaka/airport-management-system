package com.airport.checkin_service.service;

import com.airport.checkin_service.entity.Checkin;
import com.airport.checkin_service.repository.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckinService {
    @Autowired
    private CheckinRepository checkinRepository;

    // 1. New member add the database
    public Checkin createCheckin(Checkin checkin) {
        return checkinRepository.save(checkin);
    }

    // 2. get the all Check-in members
    public List<Checkin> getAllCheckins() {
        return checkinRepository.findAll();
    }

    // 3. seach the member details in the ID
    public Optional<Checkin> getCheckinById(Long id) {
        return checkinRepository.findById(id);
    }

    // 4. Delete the member
    public void deleteCheckin(Long id) {
        checkinRepository.deleteById(id);
    }

    // 5. Changing the details of an existing passenger (Update)
    public Checkin updateCheckin(Long id, Checkin updatedDetails) {
        Checkin existingCheckin = checkinRepository.findById(id).get();
        existingCheckin.setPassengerName(updatedDetails.getPassengerName());
        existingCheckin.setFlightNumber(updatedDetails.getFlightNumber());
        existingCheckin.setSeatNumber(updatedDetails.getSeatNumber());
        existingCheckin.setBoarded(updatedDetails.isBoarded());
        return checkinRepository.save(existingCheckin);
    }
}

