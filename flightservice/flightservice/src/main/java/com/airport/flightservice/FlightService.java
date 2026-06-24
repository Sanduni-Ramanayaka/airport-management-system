package com.airport.flightservice;

import com.airport.flightservice.Flight;
import com.airport.flightservice.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository repository;

    public FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Flight getFlight(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Flight saveFlight(Flight flight) {

        boolean conflict =
                repository.existsByGateNumberAndDepartureTime(
                        flight.getGateNumber(),
                        flight.getDepartureTime()
                );

        if (conflict) {
            throw new RuntimeException(
                    "Gate conflict detected"
            );
        }

        return repository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {

        Flight existing =
                repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setFlightNumber(
                    flight.getFlightNumber());

            existing.setDepartureCity(
                    flight.getDepartureCity());

            existing.setArrivalCity(
                    flight.getArrivalCity());

            existing.setDepartureTime(
                    flight.getDepartureTime());

            existing.setArrivalTime(
                    flight.getArrivalTime());

            existing.setGateNumber(
                    flight.getGateNumber());

            existing.setTerminal(
                    flight.getTerminal());

            existing.setAircraftType(
                    flight.getAircraftType());

            existing.setOperationalStatus(
                    flight.getOperationalStatus());

            return repository.save(existing);
        }

        return null;
    }

    public void deleteFlight(Long id) {
        repository.deleteById(id);
    }
}