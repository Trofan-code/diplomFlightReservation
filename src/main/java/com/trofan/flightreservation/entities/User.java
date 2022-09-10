package com.trofan.flightreservation.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String roles;

}
