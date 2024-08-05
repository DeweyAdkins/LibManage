package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> loanedBooks;
    private int lateFees;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.loanedBooks = new ArrayList<>();
        this.lateFees = 0;
    }

    public String getName() {
        return name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public int getLateFees() {
        return lateFees;
    }

    public void loanBook(Book book) {
        loanedBooks.add(book);
    }

    public void returnBook(Book book) {
        loanedBooks.remove(book);
    }

    public void addLateFee() {
        lateFees += 5; // Assuming a fixed late fee of $5
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", libraryCardNumber='" + libraryCardNumber + '\'' +
                ", loanedBooks=" + loanedBooks +
                ", lateFees=" + lateFees +
                '}';
    }
}
