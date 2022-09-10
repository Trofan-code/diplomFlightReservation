package com.trofan.flightreservation.controllers;

import com.trofan.flightreservation.dto.ReservationRequest;
import com.trofan.flightreservation.dto.ReservationUpdateRequest;
import com.trofan.flightreservation.entities.Reservation;
import com.trofan.flightreservation.services.ReservationService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(value = "/complete")
    @ApiOperation("Complete reservation")
    public Reservation completeReservation(ReservationRequest request) {
        log.info("complete reservation {}", request);
        return reservationService.bookFlight(request);
    }

    @GetMapping("/reservations/{id}")
    @ApiOperation("Find reservation by ID")
    public Reservation findReservation(@PathVariable("id") Long id) {
       return reservationService.findById(id);
    }

    @PutMapping()
    @ApiOperation("Update reservation")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        return reservationService.updateReservation(request);
    }

}
