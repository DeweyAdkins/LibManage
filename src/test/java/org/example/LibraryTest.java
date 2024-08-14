package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {

    @Test
    public void testAddBook() {

        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1984, 318, "fiction");
        library.addBook(book);

        assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void testRemoveBook() {

        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1984, 318, "fiction");
        library.addBook(book);
        library.removeBookByTitle(book.getTitle());

        assertFalse(library.getBooks().contains(book), "Book was not found after removal, indicating it was successfully added.");

}

    @Test
    public void testGetBooks() {

        Library library = new Library();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1984, 318, "fiction");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1984, 318, "fiction");

        library.addBook(book1);
        library.addBook(book2);

        assertEquals(2, library.getBooks().size());
        assertTrue(library.getBooks().contains(book1));
        assertTrue(library.getBooks().contains(book2));
    }
}
