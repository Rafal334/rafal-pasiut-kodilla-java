package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.repository.FlightsRepository;
import com.kodilla.good.patterns.challenges.flights.searcher.presenter.ConsoleSearchResultsPresenter;
import com.kodilla.good.patterns.challenges.flights.searcher.presenter.SearchResultsPresenter;

public class FlightSearchProcessor {

    private FlightsRepository flightsRepository;
    private SearchResultsPresenter presenter;
    private Searcher searcher;

    public FlightSearchProcessor(FlightsRepository flightsRepository, SearchResultsPresenter presenter, Searcher searcher) {
        this.flightsRepository = flightsRepository;
        this.presenter = presenter;
        this.searcher = searcher;
    }

    public void searchFlightsFrom(String airportName) {
        loadTimetable();
        try {
            SearchResult results = searcher.searchAllFlightsFrom(new Airport(airportName));
            presenter = new ConsoleSearchResultsPresenter();
            presenter.showResults(results);
        } catch (NoSuchAirport e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchFlightsTo(String airportName) {
        try {
            SearchResult results = searcher.searchAllFlightsTo(new Airport(airportName));
            presenter = new ConsoleSearchResultsPresenter();
            presenter.showResults(results);
        } catch (NoSuchAirport e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchFlightsFromTo(String departureAirportName, String arrivalAirportName) {
        try {
            SearchResult results = searcher.searchFlightsFromTo(new Airport(departureAirportName), new Airport(arrivalAirportName));
            presenter = new ConsoleSearchResultsPresenter();
            presenter.showResults(results);
        } catch (NoSuchAirport e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadTimetable() {
        FlightsTimetable timetable = flightsRepository.getFlightsTimetable();
        searcher.loadTimetable(timetable);
    }
}
