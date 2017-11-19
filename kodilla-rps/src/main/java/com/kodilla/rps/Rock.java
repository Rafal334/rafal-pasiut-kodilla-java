package com.kodilla.rps;

public final class Rock extends Champion {

    public Rock() {
        super("Rock");
        super.putWins("Lizard", "smashes");
        super.putWins("Scissors", "crushes");
    }
}
