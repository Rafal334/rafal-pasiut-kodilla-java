package com.kodilla.good.patterns.challenges.flights.searcher;

import com.kodilla.good.patterns.challenges.flights.connection.CombinedConnection;
import com.kodilla.good.patterns.challenges.flights.connection.Connection;

import java.util.ArrayList;

public class SearchResult {

    private final ArrayList<Connection> directConnections;
    private final ArrayList<CombinedConnection> combinedConnections;

    public SearchResult(ArrayList<Connection> directConnections, ArrayList<CombinedConnection> combinedConnections) {
        this.directConnections = directConnections;
        this.combinedConnections = combinedConnections;
    }

    public ArrayList<Connection> getDirectConnections() {
        return directConnections;
    }

    public ArrayList<CombinedConnection> getCombinedConnections() {
        return combinedConnections;
    }
}
