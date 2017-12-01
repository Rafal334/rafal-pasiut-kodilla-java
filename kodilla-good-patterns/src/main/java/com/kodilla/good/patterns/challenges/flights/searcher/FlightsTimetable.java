package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.connection.Connection;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightsTimetable {

    private HashMap<Airport,ArrayList<Connection>> arrivals;
    private HashMap<Airport,ArrayList<Connection>> departures;

    public FlightsTimetable(HashMap<Airport, ArrayList<Connection>> arrivals, HashMap<Airport, ArrayList<Connection>> departures) {
        this.arrivals = arrivals;
        this.departures = departures;
    }

    public FlightsTimetable(ArrayList<Connection> connections) {
            connections.stream().forEach(System.out::println);
    }


}
