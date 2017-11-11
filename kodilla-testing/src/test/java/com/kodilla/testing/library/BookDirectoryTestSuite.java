package com.kodilla.testing.library;

import org.junit.*;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @InjectMocks
    private BookLibrary bookLibrary;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListBooksWithConditionsReturnList() {

        // Given
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {

        // Given
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FourtyBooks")).thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {

        // Given
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfNoneBooks() {

        //Given
        LibraryUser user = new LibraryUser("Jan","Kowalski","00000000000");
        //Używaj Collections.EMPTY_LIST, bardziej wydajne, new ArrayList<>() tworzy 10 elementowa tablice mimo że jest pusta
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(new ArrayList<>());

        //When
        List<Book> borrowedBooks = bookLibrary.listBooksInHandsOf(user);

        //Than
        assertTrue("List is not empty",borrowedBooks.isEmpty());
    }

    @Test
    public void testListBooksInHandsOfOneBook() {

        //Given
        LibraryUser user = new LibraryUser("Jan","Kowalski","00000000000");
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(generateListOfNBooks(1));

        //When
        List<Book> borrowedBooks = bookLibrary.listBooksInHandsOf(user);

        //Than
        assertEquals(1, borrowedBooks.size());
    }

    @Test
    public void testListBooksInHandsOf5Booksk() {

        //Given
        LibraryUser user = new LibraryUser("Jan","Kowalski","00000000000");
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(generateListOfNBooks(5));

        //When
        List<Book> borrowedBooks = bookLibrary.listBooksInHandsOf(user);

        //Than
        assertEquals(5, borrowedBooks.size());
    }

    @Test
    public void testListBooksInHandsOfNullUser() {

        //Given

        //When
        List<Book> borrowedBooks = bookLibrary.listBooksInHandsOf(null);

        //Than
        assertTrue(borrowedBooks.isEmpty());
        verify(libraryDatabaseMock,never()).listBooksInHandsOf(any());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
