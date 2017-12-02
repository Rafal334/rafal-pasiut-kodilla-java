package com.kodilla.good.patterns.challenges.flights.connection;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.connection.times.Times;

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
        return departureAirport + "\t\t" + arrivalAirport + "\t\t" + flightTimes;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public Times getFlightTimes() {
        return flightTimes;
    }
}
