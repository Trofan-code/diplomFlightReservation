package com.trofan.flightreservation.controllers;


import com.trofan.flightreservation.entities.Flight;
import com.trofan.flightreservation.repos.FlightRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static java.lang.String.format;

@Slf4j
@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightRepository flightRepository;

    @GetMapping()
    @ApiOperation("Get all flights")
    public List<Flight> findFlights() {
        return flightRepository.findAll();
    }

    @PostMapping("/find")
    @ApiOperation("Find flights filtered by departure date, departure city and arrival city")
    public List<Flight> findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate) {
        log.debug("Inside findFlights() From:" + from + " TO:" + to + "Departure Date: " + departureDate);
        return flightRepository.findAllByArrivalCityAndDepartureCityAndDateOfDeparture(from, to, departureDate);
    }

    @GetMapping("/{flightId}/completed")
    @ApiOperation("Show completed flight")
    public Flight showCompleteReservation(@PathVariable("flightId") Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException(format("Flight with id %s not found", flightId)));
        log.info("Flight is: {}", flight);
        return flight;
    }

}
