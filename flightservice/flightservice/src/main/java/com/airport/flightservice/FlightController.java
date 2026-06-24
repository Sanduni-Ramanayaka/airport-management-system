package com.airport.flightservice;

import com.airport.flightservice.Flight;
import com.airport.flightservice.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlight(
            @PathVariable Long id) {

        return service.getFlight(id);
    }

    @PostMapping
    public Flight createFlight(
            @RequestBody Flight flight) {

        return service.saveFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(
            @PathVariable Long id,
            @RequestBody Flight flight) {

        return service.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(
            @PathVariable Long id) {

        service.deleteFlight(id);
    }
}