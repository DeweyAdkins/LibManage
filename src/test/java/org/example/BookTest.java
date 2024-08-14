package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookTitle() {

        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1984, 318, "fiction");

        assertEquals("The Great Gatsby", book.getTitle());
    }

    @Test
    public void testBookAuthor() {

        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1984, 318, "fiction");
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
    }
}
