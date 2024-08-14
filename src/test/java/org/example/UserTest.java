package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserName() {

        User user = new User("John Doe", "1234");
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testUserBorrowBook() {

        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1984, 318, "fiction");
        library.addBook(book);

        User user = new User("Jane Doe", "1235");
        user.loanBook(book);

        assertTrue(library.getBooks().contains(book));
        assertTrue(user.getLoanedBooks().contains(book));
    }

    @Test
    public void testReturnBook() {

        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1984, 318, "fiction");
        library.addBook(book);

        User user = new User("Jane Doe", "1235");
        user.loanBook(book);
        user.returnBook(book);

        assertTrue(library.getBooks().contains(book));
        assertFalse(user.getLoanedBooks().contains(book));
    }
}
