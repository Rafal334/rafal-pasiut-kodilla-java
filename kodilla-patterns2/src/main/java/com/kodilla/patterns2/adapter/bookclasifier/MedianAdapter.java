package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet) {

        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> books;

        books = bookSet.stream()
                .collect(Collectors.toMap(
                        book -> new BookSignature(book.getSignature()),
                        book -> new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(book.getAuthor(), book.getTitle(), book.getPublicationYear())
                ));
        return medianPublicationYear(books);
    }
}
