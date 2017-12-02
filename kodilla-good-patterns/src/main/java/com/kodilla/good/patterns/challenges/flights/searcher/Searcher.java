package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;

public interface Searcher {

    SearchResult searchAllFlightsFrom(Airport airport) throws NoSuchAirport;

    SearchResult searchAllFlightsTo(Airport airport) throws NoSuchAirport;

    SearchResult searchFlightsFromTo(Airport departureAirport, Airport arrivalAirport) throws NoSuchAirport;

    void loadTimetable(FlightsTimetable timetable);
}
