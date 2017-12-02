package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.repository.FlightsFileRepository;
import com.kodilla.good.patterns.challenges.flights.searcher.FlightSearchProcessor;
import com.kodilla.good.patterns.challenges.flights.searcher.FlightsSearcher;
import com.kodilla.good.patterns.challenges.flights.searcher.presenter.ConsoleSearchResultsPresenter;

public class FlightSearchRunner {

    public static void main(String[] args) {

        FlightSearchProcessor searchProcessor = new FlightSearchProcessor(new FlightsFileRepository(), new ConsoleSearchResultsPresenter(), new FlightsSearcher());

        searchProcessor.searchFlightsFrom("Warszawa");
        searchProcessor.searchFlightsTo("Kraków");
        searchProcessor.searchFlightsFromTo("Rzeszów", "Wrocław");


    }


}
