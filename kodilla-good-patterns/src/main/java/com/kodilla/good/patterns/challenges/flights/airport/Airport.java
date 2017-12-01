package com.kodilla.good.patterns.challenges.flights.airport;

public class Airport {

    private String airportName;

    public Airport(String airportName) {
        this.airportName = airportName;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportName='" + airportName + '\'' +
                '}';
    }
}
