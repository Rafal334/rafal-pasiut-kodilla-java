package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.repository.FlightsFileRepository;
import com.kodilla.good.patterns.challenges.flights.repository.FlightsRepository;
import com.kodilla.good.patterns.challenges.flights.searcher.FlightsSearcher;
import com.kodilla.good.patterns.challenges.flights.searcher.FlightsTimetable;
import com.kodilla.good.patterns.challenges.flights.searcher.SearchResult;
import com.kodilla.good.patterns.challenges.flights.searcher.Searcher;
import com.kodilla.good.patterns.challenges.flights.searcher.presenter.ConsoleSearchResultsPresenter;
import com.kodilla.good.patterns.challenges.flights.searcher.presenter.SearchResultsPresenter;

public class FlightSearchRunner {

    public static void main(String[] args) {

        FlightsRepository flightsRepository = new FlightsFileRepository();
        FlightsTimetable timetable = flightsRepository.getFlightsTimetable();

        SearchResultsPresenter presenter;
        SearchResult results;
        Searcher searcher = new FlightsSearcher(timetable);

        results = searcher.searchAllFlightsFrom(new Airport("Warszawa"));
        presenter = new ConsoleSearchResultsPresenter(results);
        presenter.showResults();

        results = searcher.searchAllFlightsTo(new Airport("Kraków"));
        presenter = new ConsoleSearchResultsPresenter(results);
        presenter.showResults();

        results = searcher.searchFlightsFromTo(new Airport("Rzeszów"), new Airport("Wrocław"));
        presenter = new ConsoleSearchResultsPresenter(results);
        presenter.showResults();
    }


}
