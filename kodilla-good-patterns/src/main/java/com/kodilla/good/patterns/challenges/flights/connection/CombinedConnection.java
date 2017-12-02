package com.kodilla.good.patterns.challenges.flights.connection;

import java.util.ArrayList;

public class CombinedConnection {

    private ArrayList<Connection> transfer;

    public CombinedConnection(ArrayList<Connection> transfer) {
        this.transfer = transfer;
    }

    public ArrayList<Connection> getTransfer() {
        return transfer;
    }
}
