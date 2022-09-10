package com.trofan.flightreservation.services;


import com.trofan.flightreservation.dto.ReservationRequest;
import com.trofan.flightreservation.dto.ReservationUpdateRequest;
import com.trofan.flightreservation.entities.Reservation;

public interface ReservationService {
    Reservation bookFlight(ReservationRequest request);
    Reservation findById(Long id);
    Reservation updateReservation(ReservationUpdateRequest request);
}
