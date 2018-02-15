package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Arrays;
import java.util.Map;

public class Statistics implements BookStatistics {

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        if (books.size() == 0) {
            return 0;
        } else {
            int sum = 0;
            for (Map.Entry<BookSignature, Book> entry : books.entrySet()) {
                sum += entry.getValue().getYearOfPublication();
            }
            return sum / books.size();
        }
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        if (books.size() == 0) {
            return 0;
        } else {
            int years[] = new int[books.size()];
            int i = 0;
            for (Map.Entry<BookSignature, Book> entry : books.entrySet()) {
                years[i] = entry.getValue().getYearOfPublication();
                i++;
            }
            Arrays.sort(years);
            if (years.length % 2 == 0) {
                return years[(int) (years.length / 2 + 0.5)];
            } else {
                return years[years.length / 2];
            }
        }
    }
}
