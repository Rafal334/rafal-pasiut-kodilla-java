package com.kodilla.good.patterns.challenges.flights.repository;

import com.kodilla.good.patterns.challenges.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.flights.connection.Connection;
import com.kodilla.good.patterns.challenges.flights.connection.times.Times;
import com.kodilla.good.patterns.challenges.flights.searcher.FlightsTimetable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightsFileRepository implements FlightsRepository {

    private static final String DELIM = ";";
    private static final String TIMES_DELIMITER = ",";

    @Override
    public FlightsTimetable getFlightsTimetable() {
        try {
            Stream<String> lines = openFile();
            ArrayList<Connection> connections = lines
                    .map(this::createConnections)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toCollection(ArrayList::new));
            return new FlightsTimetable(connections);
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return null;
    }

    private Stream<String> openFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("flights/FlightsTimetable.txt").getFile());

        return Files.lines(Paths.get(file.getPath()));
    }

    private ArrayList<Connection> createConnections(String rawConnectionString) {

        ArrayList<Connection> connections = new ArrayList<>();
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(rawConnectionString, DELIM);

        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        if(tokens.size()>2) {
            tokenizer = new StringTokenizer(tokens.get(2), TIMES_DELIMITER);
            while (tokenizer.hasMoreTokens()) {
                connections.add(new Connection(new Airport(tokens.get(0)), new Airport(tokens.get(1)), getTimes(tokenizer.nextToken())));
            }
        }
        return connections;
    }

    private Times getTimes(String rawTime) {        //TODO errors in formating text file

        rawTime = rawTime.substring(1, rawTime.length() - 1);
        String[] times = rawTime.split("-");

        return new Times(LocalTime.parse(times[0]), LocalTime.parse(times[1]));

    }
}
