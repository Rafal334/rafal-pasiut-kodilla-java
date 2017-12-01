package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.repository.FlightsFileRepository;
import com.kodilla.good.patterns.challenges.flights.repository.FlightsRepository;

public class FlightSearchRunner {

    public static void main(String[] args) {

        FlightsRepository flightsRepository = new FlightsFileRepository();
        flightsRepository.getFlightsTimetable();
    }


}
