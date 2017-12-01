package com.kodilla.good.patterns.challenges.flights.connection;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.connection.times.Times;

import java.time.LocalTime;

public class Connection {

    private Airport departureAirport;
    private Airport arrivalAirport;
    private Times flightTimes;

    public Connection(Airport departureAirport, Airport arrivalAirport, Times flightTimes) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightTimes = flightTimes;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", flightTimes=" + flightTimes +
                '}';
    }
}
