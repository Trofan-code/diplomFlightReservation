package com.trofan.flightreservation.services.impl;


import com.trofan.flightreservation.dto.ReservationRequest;
import com.trofan.flightreservation.dto.ReservationUpdateRequest;
import com.trofan.flightreservation.entities.Flight;
import com.trofan.flightreservation.entities.Passenger;
import com.trofan.flightreservation.entities.Reservation;
import com.trofan.flightreservation.repos.FlightRepository;
import com.trofan.flightreservation.repos.PassengerRepository;
import com.trofan.flightreservation.repos.ReservationRepository;
import com.trofan.flightreservation.services.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public Reservation findById(Long id) {
        log.info("Inside findReservation() for id: " + id);
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(format("Reservation with id %s not found", id)));

    }

    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) {
        log.info("Inside bookFlight()");
        Long flightId = request.getFlightId();
        log.info("Fetching  flight for flight id:" + flightId);
        Flight flight = flightRepository.findById(flightId).get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());
        log.info("Saving the passenger:" + passenger);
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        log.info("Saving the reservation:" + reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        log.info("Update reservation with {}", request);
        Reservation reservation = findById(request.getId());
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        log.info("Saving Reservation");
        return reservationRepository.save(reservation);
    }

}
