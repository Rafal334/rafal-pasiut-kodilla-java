package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testLibrary() {
        //Given
        Library library = new Library("Library");
        IntStream.range(0, 10)
                .forEach(number -> library.getBooks().add(new Book("Book" + number, "Author" + number, LocalDate.now().minusYears(number))));

        Book bookToRemove = new Book("Book0", "Author0", LocalDate.now());

        Library shallowCopy = null;
        try {
            shallowCopy = library.shallowCopy();
            shallowCopy.setName("Library shallow copy");
        } catch (CloneNotSupportedException e) {
            System.out.println("Can`t clone library - shallow copy");
        }

        Library deepCopy = null;
        try {
            deepCopy = library.deepCopy();
            deepCopy.setName("Library deep copy");
        } catch (CloneNotSupportedException e) {
            System.out.println("Can`t clone library - deep copy");
        }

        //When
        library.getBooks().remove(bookToRemove);

        //Then
        System.out.println(library);
        System.out.println(shallowCopy);
        System.out.println(deepCopy);

        Assert.assertEquals(9, library.getBooks().size());
        Assert.assertEquals(9, shallowCopy.getBooks().size());
        Assert.assertEquals(10, deepCopy.getBooks().size());
        Assert.assertEquals(library.getBooks(), shallowCopy.getBooks());
        Assert.assertNotEquals(library.getBooks(), deepCopy.getBooks());

    }

}
