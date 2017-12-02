package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;

public interface FlightSearcher {

    SearchResult searchAllFlightsFrom(Airport airport);
    SearchResult searchAllFlightsTo(Airport airport);
    SearchResult searchFlightsFromTo(Airport departureAirport, Airport arrivalAirport);
}
