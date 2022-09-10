package com.trofan.flightreservation.repos;


import com.trofan.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
