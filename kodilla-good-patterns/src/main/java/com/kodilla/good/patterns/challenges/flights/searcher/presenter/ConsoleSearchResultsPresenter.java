package com.kodilla.good.patterns.challenges.flights.searcher.presenter;

import com.kodilla.good.patterns.challenges.flights.searcher.SearchResult;

public class ConsoleSearchResultsPresenter implements SearchResultsPresenter {

    private SearchResult results;

    public ConsoleSearchResultsPresenter(SearchResult results) {
        this.results = results;
    }

    @Override
    public void showResultsAllFrom() {
        printSeparator();
        if(!results.getDirectConnections().isEmpty()) {
            System.out.println("All flights from: " + results.getDirectConnections().get(0).getDepartureAirport());
            System.out.println("Departure\t\tArrival\t\tToD\t\tToA");
            results.getDirectConnections().forEach(System.out::println);
        }else{
            System.out.println("None flights found");
        }
        printSeparator();
    }

    @Override
    public void showResultsAllTo() {
        printSeparator();
        if(!results.getDirectConnections().isEmpty()) {
            System.out.println("All flights to: " + results.getDirectConnections().get(0).getArrivalAirport());
            System.out.println("Departure\t\tArrival\t\tToD\t\tToA");
            results.getDirectConnections().forEach(System.out::println);
        }else{
            System.out.println("None flights found");
        }
        printSeparator();
    }

    @Override
    public void showResultsFromTo() {

    }

    private void printSeparator(){
        System.out.println("-------------------------------------------");
    }
}
