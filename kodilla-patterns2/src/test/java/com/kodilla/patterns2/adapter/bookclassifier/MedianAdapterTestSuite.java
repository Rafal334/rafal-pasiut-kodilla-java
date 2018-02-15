package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void testPublicationYearMedian() {
        //Given
        Set<Book> books = new HashSet<>();
        Book book1 = new Book("author1", "title1", 1990, "sig1");
        Book book2 = new Book("author2", "title2", 1965, "sig2");
        Book book3 = new Book("author3", "title3", 2001, "sig3");
        Book book4 = new Book("author4", "title4", 1985, "sig4");
        Book book5 = new Book("author5", "title5", 2010, "sig5");
        Book book6 = new Book("author6", "title6", 1940, "sig6");
        Book book7 = new Book("author7", "title7", 1973, "sig7");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(books);
        //Then
        Assert.assertEquals(1985, median);

    }
}
