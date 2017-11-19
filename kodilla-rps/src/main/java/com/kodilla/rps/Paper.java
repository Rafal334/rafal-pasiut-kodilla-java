package com.kodilla.rps;

public final class Paper extends Champion {

    public Paper() {
        super("Paper");
        super.putWins("Rock", "covers");
        super.putWins("Spock", "disproves");
    }
}
