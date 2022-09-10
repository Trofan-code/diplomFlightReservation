package com.trofan.flightreservation.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "reservation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;

}
