package com.kodilla.good.patterns.challenges.flights.searcher.presenter;

import com.kodilla.good.patterns.challenges.flights.connection.Connection;
import com.kodilla.good.patterns.challenges.flights.searcher.SearchResult;

import java.util.ArrayList;

public class ConsoleSearchResultsPresenter implements SearchResultsPresenter {

    private SearchResult results;

    public ConsoleSearchResultsPresenter(SearchResult results) {
        this.results = results;
    }

    @Override
    public void showResults() {
        System.out.println("\n\n");
        printSeparator();
        printSearchFlightQuery();
        showDirectResults();
        showCombinedResults();
        printSeparator();
        System.out.println("\n\n");
    }

    private void showDirectResults() {
        if (!results.getDirectConnections().isEmpty()) {
            System.out.println("DIRECT FLIGHTS");
            printHeader();
            results.getDirectConnections().forEach(System.out::println);
        } else {
            System.out.println("No direct flights found");
        }
    }

    private void showCombinedResults() {
        if (!results.getCombinedConnections().isEmpty()) {
            System.out.println("COMBINED FLIGHTS");
            results.getCombinedConnections().stream().map(combinedConnection -> combinedConnection.getTransfer()).forEach(this::printCombinedResult);
        }
    }

    private void printCombinedResult(ArrayList<Connection> connections) {
        printFlightSeparator();
        printHeader();
        connections.forEach(System.out::println);
        printFlightSeparator();
    }

    private void printSeparator() {
        System.out.println("***************************************");
    }

    private void printFlightSeparator() {
        System.out.println("----------------------------------------");
    }

    private void printHeader() {
        System.out.println("Departure\t\tArrival\t\tToD\t\tToA");
    }

    private void printSearchFlightQuery() {
        if (results.getArrivalAirport().toString().isEmpty()) {
            System.out.println("ALL FLIGHTS FROM: " + results.getDepartureAirport());
        } else if (results.getDepartureAirport().toString().isEmpty()) {
            System.out.println("ALL FLIGHTS TO: " + results.getArrivalAirport());
        } else {
            System.out.println("ALL FLIGHTS FROM: " + results.getDepartureAirport() + ", TO: " + results.getArrivalAirport());
        }
    }
}
