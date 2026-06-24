package com.airport.baggage.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "baggage")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Baggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baggage_id")
    private Integer baggageId;

    @Column(name = "passenger_id", nullable = false)
    private Integer passengerId;

    @Column(name = "tag_number", nullable = false, unique = true, length = 20)
    private String tagNumber;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "status", length = 50)
    private String status;
}
