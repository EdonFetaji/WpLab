package mk.ukim.finki.wp.lab.bootstrap;
import  java.util.Random;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init() {
        Random rand = new Random();
        authors.addAll(List.of(
                new Author("Edgar Allan","Poe","England","very cool guy"),
                new Author("Dritero","Agolli","Albania","chill guy"),
                new Author("Frederick","Nietzche","Germany","kinda lost but he got the spirit")
        ));

        books.addAll(List.of(
                new Book("The Silent Patient", "Thriller", 4.3, authors.get(rand.nextInt(authors.size()))),
                new Book("Dune", "Science Fiction", 4.6, authors.get(rand.nextInt(authors.size()))),
                new Book("1984", "Dystopian", 4.5, authors.get(rand.nextInt(authors.size()))),
                new Book("To Kill a Mockingbird", "Classic", 4.8, authors.get(rand.nextInt(authors.size()))),
                new Book("The Name of the Wind", "Fantasy", 4.7, authors.get(rand.nextInt(authors.size()))),
                new Book("Atomic Habits", "Self-Help", 4.9, authors.get(rand.nextInt(authors.size()))),
                new Book("The Alchemist", "Fiction", 4.4, authors.get(rand.nextInt(authors.size()))),
                new Book("Educated", "Memoir", 4.6, authors.get(rand.nextInt(authors.size()))),
                new Book("Becoming", "Biography", 4.8, authors.get(rand.nextInt(authors.size()))),
                new Book("The Martian", "Science Fiction", 4.7, authors.get(rand.nextInt(authors.size())))
        ));

        reservations = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<BookReservation> getReservations() {
        return reservations;
    }

    public void addReservation(BookReservation reservation) {
        reservations.add(reservation);
    }
}
