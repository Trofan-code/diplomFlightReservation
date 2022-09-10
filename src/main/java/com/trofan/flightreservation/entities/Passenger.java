package com.trofan.flightreservation.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "passenger")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
}
