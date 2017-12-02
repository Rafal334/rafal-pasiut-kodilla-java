package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.connection.CombinedConnection;
import com.kodilla.good.patterns.challenges.flights.connection.Connection;

import java.util.ArrayList;

public class SearchResult {

    private final ArrayList<Connection> directConnections;
    private final ArrayList<CombinedConnection> combinedConnections;
    private final Airport departureAirport;
    private final Airport arrivalAirport;

    public SearchResult(ArrayList<Connection> directConnections, ArrayList<CombinedConnection> combinedConnections, Airport departureAirport, Airport arrivalAirport) {
        this.directConnections = directConnections;
        this.combinedConnections = combinedConnections;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public ArrayList<Connection> getDirectConnections() {
        return directConnections;
    }

    public ArrayList<CombinedConnection> getCombinedConnections() {
        return combinedConnections;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }
}
