package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.connection.Connection;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightsTimetable {

    private HashMap<Airport, ArrayList<Connection>> arrivals;
    private HashMap<Airport, ArrayList<Connection>> departures;

    public FlightsTimetable(HashMap<Airport, ArrayList<Connection>> arrivals, HashMap<Airport, ArrayList<Connection>> departures) {
        this.arrivals = arrivals;
        this.departures = departures;
    }

    public FlightsTimetable(ArrayList<Connection> connections) {
        arrivals = new HashMap<>();
        departures = new HashMap<>();
        fillArrivals(connections);
        fillDepartures(connections);
    }

    private void fillArrivals(ArrayList<Connection> connections) {

        for (Connection connection : connections) {
            if (arrivals.containsKey(connection.getArrivalAirport())) {
                arrivals.get(connection.getArrivalAirport()).add(connection);
            } else {
                ArrayList<Connection> newConnectionList = new ArrayList<>();
                newConnectionList.add(connection);
                arrivals.put(connection.getArrivalAirport(),newConnectionList);
            }
        }
    }

    private void fillDepartures(ArrayList<Connection> connections) {

        for (Connection connection : connections) {
            if (departures.containsKey(connection.getDepartureAirport())) {
                departures.get(connection.getDepartureAirport()).add(connection);
            } else {
                ArrayList<Connection> newConnectionList = new ArrayList<>();
                newConnectionList.add(connection);
                departures.put(connection.getDepartureAirport(), newConnectionList);
            }
        }
    }

    public HashMap<Airport, ArrayList<Connection>> getArrivals() {
        return arrivals;
    }

    public HashMap<Airport, ArrayList<Connection>> getDepartures() {
        return departures;
    }
}
