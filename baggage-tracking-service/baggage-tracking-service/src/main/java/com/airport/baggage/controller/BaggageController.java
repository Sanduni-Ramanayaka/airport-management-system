package com.airport.baggage.controller;

import com.airport.baggage.model.Baggage;
import com.airport.baggage.service.BaggageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baggage")
@RequiredArgsConstructor
public class BaggageController {

    private final BaggageService baggageService;

    // POST /api/baggage — Register new baggage
    @PostMapping
    public ResponseEntity<Baggage> registerBaggage(@RequestBody Baggage baggage) {
        Baggage saved = baggageService.registerBaggage(baggage);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // GET /api/baggage — View all baggage records
    @GetMapping
    public ResponseEntity<List<Baggage>> getAllBaggage() {
        return ResponseEntity.ok(baggageService.getAllBaggage());
    }

    // GET /api/baggage/{id} — Track a specific bag
    @GetMapping("/{id}")
    public ResponseEntity<Baggage> getBaggageById(@PathVariable Integer id) {
        return ResponseEntity.ok(baggageService.getBaggageById(id));
    }

    // PUT /api/baggage/{id} — Update baggage location / status
    @PutMapping("/{id}")
    public ResponseEntity<Baggage> updateBaggage(@PathVariable Integer id,
                                                  @RequestBody Baggage baggage) {
        return ResponseEntity.ok(baggageService.updateBaggage(id, baggage));
    }

    // GET /api/baggage/passenger/{passengerId} — Get all bags for a passenger
    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<Baggage>> getBaggageByPassenger(@PathVariable Integer passengerId) {
        return ResponseEntity.ok(baggageService.getBaggageByPassenger(passengerId));
    }
}
