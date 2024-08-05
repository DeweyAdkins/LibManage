package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();


        library.addBook(new Book("1984", "George Orwell", 1949, 328, "Fiction"));
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, 256, "Science"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180, "Fiction"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281, "Fiction"));
        library.addBook(new Book("The Art of Computer Programming", "Donald Knuth", 1968, 672, "Science"));


        System.out.println("All book titles sorted alphabetically:");
        List<String> sortedTitles = library.getAllBookTitlesSorted();
        sortedTitles.forEach(System.out::println);


        User user1 = new User("Alice", "1001");
        User user2 = new User("Bob", "1002");
        library.registerUser(user1);
        library.registerUser(user2);


        library.loanBook("1984", user1);
        library.loanBook("The Great Gatsby", user1);
        library.loanBook("A Brief History of Time", user2);


        boolean loanResult = library.loanBook("1984", user2);
        System.out.println("Attempt to loan '1984' to Bob: " + (loanResult ? "Success" : "Failure"));


        library.returnBook("1984", user1);


        library.loanBook("1984", user2);

        System.out.println("\nBooks by George Orwell:");
        List<Book> orwellBooks = library.findBooksByAuthor("George Orwell");
        orwellBooks.forEach(System.out::println);


        System.out.println("\nBooks with more than 300 pages:");
        List<Book> thickBooks = library.findBooksWithMoreThanNPages(300);
        thickBooks.forEach(System.out::println);


        System.out.println("\nBooks in the 'Science' category:");
        List<Book> scienceBooks = library.findBooksByCategory("Science");
        scienceBooks.forEach(System.out::println);

        user1.getLoanedBooks().forEach(book -> book.setOnLoan(true));
        user1.getLoanedBooks().forEach(book -> book.loanTimestamp -= 15 * 24 * 60 * 60 * 1000);
        library.checkForLateFees();

        System.out.println("\nUser details after checking for late fees:");
        System.out.println(user1);
        System.out.println(user2);


        List<Book> recentBooks = library.findBooks(book -> book.getPublicationYear() > 1950);
        System.out.println("\nBooks published after 1950:");
        recentBooks.forEach(System.out::println);


        List<String> titles = library.getBookTitles(Book::getTitle);
        System.out.println("\nBook titles:");
        titles.forEach(System.out::println);


        System.out.println("\nBook details:");
        library.printBooks(book -> System.out.println("Book details: " + book));


        Book newBook = library.getNewBook(() -> new Book("New Book Title", "New Author", 2021, 300, "New Category"));
        library.addBook(newBook);
        System.out.println("\nAdded new book: " + newBook);
    }
}
