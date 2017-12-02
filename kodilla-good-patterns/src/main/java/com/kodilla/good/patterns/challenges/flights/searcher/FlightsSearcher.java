package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.connection.CombinedConnection;
import com.kodilla.good.patterns.challenges.flights.connection.Connection;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FlightsSearcher implements Searcher {

    private static final int MINIMUM_TIME_FOR_TRANSFER = 20;
    private FlightsTimetable timetable;

    @Override
    public SearchResult searchAllFlightsFrom(Airport airport) throws NoSuchAirport {
        if (checkIfAirportExists(airport)) {
            return new SearchResult(timetable.getDepartures().get(airport), new ArrayList<>(), airport, new Airport(""));
        } else {
            throw new NoSuchAirport("Airport: " + airport + " not found.");
        }
    }

    @Override
    public SearchResult searchAllFlightsTo(Airport airport) throws NoSuchAirport {
        if (checkIfAirportExists(airport)) {
            return new SearchResult(timetable.getArrivals().get(airport), new ArrayList<>(), new Airport(""), airport);
        } else {
            throw new NoSuchAirport("Airport: " + airport + " not found.");
        }
    }

    @Override
    public SearchResult searchFlightsFromTo(Airport departureAirport, Airport arrivalAirport) throws NoSuchAirport {
        boolean[] checks = {checkIfAirportExists(departureAirport), checkIfAirportExists(arrivalAirport)};
        if (checks[0]&&checks[1]) {
            ArrayList<Connection> directConnection;
            ArrayList<CombinedConnection> combinedConnections;

            directConnection = timetable.getDepartures().get(departureAirport).stream()
                    .filter(connections -> connections.getArrivalAirport().equals(arrivalAirport))
                    .collect(Collectors.toCollection(ArrayList::new));

            combinedConnections = findCombinedConnections(departureAirport, arrivalAirport);

            return new SearchResult(directConnection, combinedConnections, departureAirport, arrivalAirport);
        } else {
            String message ="";
            if(!checks[0]){
                message = message + "Airport: " + departureAirport + " not found.\n";
            }
            if(!checks[1]){
                message = message + "Airport: " + arrivalAirport + " not found.\n";
            }
            throw new NoSuchAirport(message);
        }
    }

    @Override
    public void loadTimetable(FlightsTimetable timetable) {
        this.timetable = timetable;
    }

    private ArrayList<CombinedConnection> findCombinedConnections(Airport departureAirport, Airport arrivalAirport) {

        ArrayList<Connection> connections;
        ArrayList<CombinedConnection> combinedConnections = new ArrayList<>();

        for (Connection connectionFirst : timetable.getDepartures().get(departureAirport)) {
            connections = new ArrayList<>();
            for (Connection connectionSecond : timetable.getDepartures().get(connectionFirst.getArrivalAirport())) {
                if (connectionSecond.getArrivalAirport().equals(arrivalAirport) && isChangePossible(connectionFirst.getFlightTimes().getTimeOfArrival(), connectionSecond.getFlightTimes().getTimeOfDeparture())) {
                    connections.add(connectionFirst);
                    connections.add(connectionSecond);
                    combinedConnections.add(new CombinedConnection(connections));
                    break;
                }
            }
        }
        return combinedConnections;
    }

    private boolean isChangePossible(LocalTime arrivalTime, LocalTime departureTime) {
        LocalTime arrivalTimePlus = arrivalTime.plusMinutes(MINIMUM_TIME_FOR_TRANSFER);
        return departureTime.isAfter(arrivalTimePlus);
    }

    private boolean checkIfAirportExists(Airport airport) {
        return timetable.getDepartures().containsKey(airport) && timetable.getArrivals().containsKey(airport);
    }
}
