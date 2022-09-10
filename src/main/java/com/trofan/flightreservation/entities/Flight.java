package com.trofan.flightreservation.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "flight")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;
}
