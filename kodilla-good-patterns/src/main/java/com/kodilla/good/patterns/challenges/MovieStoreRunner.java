package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;

public class MovieStoreRunner {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> booksTitles = movieStore.getMovies();

        booksTitles.entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .forEach(title -> System.out.print(title + "!"));
    }
}
