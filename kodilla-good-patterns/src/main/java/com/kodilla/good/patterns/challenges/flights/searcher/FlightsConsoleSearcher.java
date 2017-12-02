package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.connection.Connection;

import java.util.ArrayList;

public class FlightsConsoleSearcher implements FlightSearcher {

    private FlightsTimetable timetable;

    public FlightsConsoleSearcher(FlightsTimetable timetable) {
        this.timetable = timetable;
    }

    @Override
    public SearchResult searchAllFlightsFrom(Airport airport) {
        return new SearchResult(timetable.getDepartures().get(airport), new ArrayList<>());
    }

    @Override
    public SearchResult searchAllFlightsTo(Airport airport) {
        return new SearchResult(timetable.getArrivals().get(airport), new ArrayList<>());
    }

    @Override
    public SearchResult searchFlightsFromTo(Airport departureAirport, Airport arrivalAirport) {
        return null;
    }
}
