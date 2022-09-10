package com.trofan.flightreservation.repos;

import com.trofan.flightreservation.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByArrivalCityAndDepartureCityAndDateOfDeparture(@Param("arrivalCity") String to, @Param("departureCity") String from,
                                                                        @Param("dateOfDeparture") Date departureDate);

}
