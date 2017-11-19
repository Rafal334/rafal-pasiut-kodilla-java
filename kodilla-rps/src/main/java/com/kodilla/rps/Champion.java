package com.kodilla.rps;

import java.util.HashMap;

public abstract class Champion {

    private final String name;
    private final HashMap<String, String> wins;

    public Champion(String name) {
        this.name = name;
        this.wins = new HashMap<>();
    }

    protected void putWins(String champion, String action) {
        wins.put(champion, action);
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getWins() {
        return new HashMap<>(wins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Champion champion = (Champion) o;

        return name.equals(champion.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
