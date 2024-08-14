package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;
    private static final int LOAN_PERIOD_MS = 14 * 24 * 60 * 60 * 1000;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> findBooksByYear(int year) {
        return books.stream().filter(book -> book.getPublicationYear() == year).collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    public Book findBookWithMostPages() {
        return books.stream().max(Comparator.comparingInt(Book::getPages)).orElse(null);
    }

    public List<Book> findBooksWithMoreThanNPages(int pages) {
        return books.stream().filter(book -> book.getPages() > pages).collect(Collectors.toList());
    }

    public List<String> getAllBookTitlesSorted() {
        return books.stream().map(Book::getTitle).sorted().collect(Collectors.toList());
    }

    public List<Book> findBooksByCategory(String category) {
        return books.stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());
    }

    public boolean loanBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isOnLoan()) {
                book.setOnLoan(true);
                user.loanBook(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String title, User user) {
        for (Book book : user.getLoanedBooks()) {
            if (book.getTitle().equals(title)) {
                book.setOnLoan(false);
                user.returnBook(book);
                return true;
            }
        }
        return false;
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void checkForLateFees() {
        long currentTime = System.currentTimeMillis();
        for (User user : users) {
            for (Book book : user.getLoanedBooks()) {
                long loanDuration = currentTime - book.getLoanTimestamp();
                if (loanDuration > LOAN_PERIOD_MS) {
                    user.addLateFee();
                }
            }
        }
    }

    // Example: Using Predicate to find books with a specific condition
    public List<Book> findBooks(Predicate<Book> condition) {
        return books.stream().filter(condition).collect(Collectors.toList());
    }

    // Example: Using Function to transform books to titles
    public List<String> getBookTitles(Function<Book, String> transformer) {
        return books.stream().map(transformer).collect(Collectors.toList());
    }

    // Example: Using Consumer to print details of each book
    public void printBooks(Consumer<Book> action) {
        books.forEach(action);
    }

    // Example: Using Supplier to get a new book instance
    public Book getNewBook(Supplier<Book> supplier) {
        return supplier.get();
    }
}
