package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {

    public boolean findFilght(Flight flight) throws RouteNotFoundException {

        if (flight != null) {
            Map<String, Boolean> destinationAirport = new HashMap<>();
            destinationAirport.put("London", true);
            destinationAirport.put("Warszawa", true);
            //destinationAirport.put("New York", false);
            if (destinationAirport.containsKey(flight.arrivalAirport)) {
                return destinationAirport.get(flight.arrivalAirport);
            } else {
                throw new RouteNotFoundException();
            }
        }
        return false;
    }
}
