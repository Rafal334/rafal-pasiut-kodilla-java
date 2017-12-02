package com.kodilla.good.patterns.challenges.flights.connection.times;

import java.time.LocalTime;

public class Times {

    private LocalTime timeOfDeparture;
    private LocalTime timeOfArrival;

    public Times(LocalTime timeOfDeparture, LocalTime timeOfArrival) {
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfArrival = timeOfArrival;
    }

    @Override
    public String toString() {
        return timeOfDeparture + "\t\t" + timeOfArrival;
    }

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public LocalTime getTimeOfArrival() {
        return timeOfArrival;
    }
}
