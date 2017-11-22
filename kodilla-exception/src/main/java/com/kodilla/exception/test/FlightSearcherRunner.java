package com.kodilla.exception.test;

public class FlightSearcherRunner {

    public static void main(String[] args){
        Flight flight = new Flight("Krakow", "New York");

        FlightSearcher searcher = new FlightSearcher();
        try {
            System.out.println(searcher.findFilght(flight));
        } catch (RouteNotFoundException e) {
            System.out.println("Arrival airport not exists");
        }
    }
}
