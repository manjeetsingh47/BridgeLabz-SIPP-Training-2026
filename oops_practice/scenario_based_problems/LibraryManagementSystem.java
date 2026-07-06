package oops_practice.scenario_based_problems;

import java.util.*;

interface Borrowable {
    void borrowBook();
    void returnBook();
}

interface Reservable {
    void reserveBook();
}

abstract class Book implements Borrowable, Reservable {
    private int id;
    private String title;
    private String author;
    private boolean borrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public void borrowBook() {
        if (!borrowed) {
            borrowed = true;
            System.out.println(title + " borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    @Override
    public void returnBook() {
        borrowed = false;
        System.out.println(title + " returned.");
    }

    @Override
    public void reserveBook() {
        System.out.println(title + " reserved.");
    }

    public abstract void display();
}

class PhysicalBook extends Book {
    private int shelfNo;

    public PhysicalBook(int id, String title, String author, int shelfNo) {
        super(id, title, author);
        this.shelfNo = shelfNo;
    }

    @Override
    public void display() {
        System.out.println("Physical Book -> ID: " + getId() +
                ", Title: " + getTitle() +
                ", Author: " + getAuthor() +
                ", Shelf: " + shelfNo);
    }
}

class EBook extends Book {
    private double fileSize;

    public EBook(int id, String title, String author, double fileSize) {
        super(id, title, author);
        this.fileSize = fileSize;
    }

    @Override
    public void display() {
        System.out.println("EBook -> ID: " + getId() +
                ", Title: " + getTitle() +
                ", Author: " + getAuthor() +
                ", Size: " + fileSize + " MB");
    }
}

class Member {
    protected int memberId;
    protected String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public void display() {
        System.out.println("Member: " + name);
    }
}

class PremiumMember extends Member {

    public PremiumMember(int memberId, String name) {
        super(memberId, name);
    }

    @Override
    public void display() {
        System.out.println("Premium Member: " + name);
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static HashMap<Integer, Book> bookMap = new HashMap<>();

    static void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getId(), book);
    }

    static void searchBook(int id) {
        Book book = bookMap.get(id);

        if (book != null)
            book.display();
        else
            System.out.println("Book not found.");
    }

    static void filterAvailableBooks() {
        System.out.println("\nAvailable Books:");

        for (Book b : books) {
            if (!b.isBorrowed())
                b.display();
        }
    }

    static void sortBooksByTitle() {
        Collections.sort(books, (b1, b2) ->
                b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        System.out.println("\nBooks Sorted By Title:");

        for (Book b : books)
            b.display();
    }

    public static void main(String[] args) {

        addBook(new PhysicalBook(1, "Java Programming", "James", 10));
        addBook(new PhysicalBook(2, "Data Structures", "Mark", 15));
        addBook(new EBook(3, "Python Guide", "David", 5.6));
        addBook(new EBook(4, "Operating System", "William", 8.2));

        Member m1 = new Member(101, "Aman");
        Member m2 = new PremiumMember(102, "Riya");

        m1.display();
        m2.display();

        System.out.println();

        searchBook(3);

        System.out.println();

        books.get(0).borrowBook();
        books.get(2).reserveBook();

        filterAvailableBooks();

        sortBooksByTitle();
    }
}
