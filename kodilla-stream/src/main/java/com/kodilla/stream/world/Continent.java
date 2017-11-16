package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public final class Continent {

    private final Set<Country> countries = new HashSet<>();

    public void addCountry(Country country) {
        if (country != null) {
            countries.add(country);
        }
    }

    public Set<Country> getCountries() {
        return new HashSet<>(countries);
    }
}
