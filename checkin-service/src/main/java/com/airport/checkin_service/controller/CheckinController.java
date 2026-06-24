package com.airport.checkin_service.controller;

import com.airport.checkin_service.entity.Checkin;
import com.airport.checkin_service.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkin")
public class CheckinController {
    @Autowired
    private CheckinService checkinService;

    // 1. Entre the new pasenger  (POST Request)
    @PostMapping
    public Checkin createCheckin(@RequestBody Checkin checkin) {
        return checkinService.createCheckin(checkin);
    }

    // 2. all detalis view (GET Request)
    @GetMapping
    public List<Checkin> getAllCheckins() {
        return checkinService.getAllCheckins();
    }

    // 3. ID Getting details of only one passenger through the number (GET Request by ID)
    @GetMapping("/{id}")
    public org.springframework.http.ResponseEntity<Checkin> getCheckinById(@PathVariable Long id) {
        java.util.Optional<Checkin> checkin = checkinService.getCheckinById(id);
        if (checkin.isPresent()) {
            return org.springframework.http.ResponseEntity.ok(checkin.get());
        } else {
            return org.springframework.http.ResponseEntity.notFound().build();
        }
    }

    // 4. Deleting a passenger's details via ID number (DELETE Request)
    @DeleteMapping("/{id}")
    public String deleteCheckin(@PathVariable Long id) {
        checkinService.deleteCheckin(id);
        return "Check-in record deleted successfully!";
    }

    // 5. Changing a passenger's details via ID number (PUT Request)
    @PutMapping("/{id}")
    public Checkin updateCheckin(@PathVariable Long id, @RequestBody Checkin checkin) {
        return checkinService.updateCheckin(id, checkin);
    }
}

