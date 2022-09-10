package com.trofan.flightreservation.repos;


import com.trofan.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
