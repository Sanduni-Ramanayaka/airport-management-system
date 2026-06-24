package com.airport.baggage.exception;

public class BaggageNotFoundException extends RuntimeException {

    public BaggageNotFoundException(Integer id) {
        super("Baggage not found with ID: " + id);
    }

    public BaggageNotFoundException(String message) {
        super(message);
    }
}
