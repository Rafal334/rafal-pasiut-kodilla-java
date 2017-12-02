package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.repository.FlightsFileRepository;
import com.kodilla.good.patterns.challenges.flights.repository.FlightsRepository;
import com.kodilla.good.patterns.challenges.flights.searcher.FlightSearcher;
import com.kodilla.good.patterns.challenges.flights.searcher.FlightsConsoleSearcher;
import com.kodilla.good.patterns.challenges.flights.searcher.FlightsTimetable;
import com.kodilla.good.patterns.challenges.flights.searcher.SearchResult;
import com.kodilla.good.patterns.challenges.flights.searcher.presenter.ConsoleSearchResultsPresenter;
import com.kodilla.good.patterns.challenges.flights.searcher.presenter.SearchResultsPresenter;

public class FlightSearchRunner {

    public static void main(String[] args) {

        FlightsRepository flightsRepository = new FlightsFileRepository();
        FlightsTimetable timetable = flightsRepository.getFlightsTimetable();

        SearchResultsPresenter presenter;
        SearchResult results;
        FlightSearcher searcher = new FlightsConsoleSearcher(timetable);

        results = searcher.searchAllFlightsFrom(new Airport("Warszawa"));
        presenter = new ConsoleSearchResultsPresenter(results);
        presenter.showResultsAllFrom();

        results = searcher.searchAllFlightsTo(new Airport("Rzeszów"));
        presenter = new ConsoleSearchResultsPresenter(results);
        presenter.showResultsAllTo();
    }


}
