package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;
    public static List<BookReservation> reservations = null;

    @PostConstruct
    public void init() {

        books = Arrays.asList(
                new Book("The Silent Patient", "Thriller", 4.3),
                new Book("Dune", "Science Fiction", 4.6),
                new Book("1984", "Dystopian", 4.5),
                new Book("To Kill a Mockingbird", "Classic", 4.8),
                new Book("The Name of the Wind", "Fantasy", 4.7),
                new Book("Atomic Habits", "Self-Help", 4.9),
                new Book("The Alchemist", "Fiction", 4.4),
                new Book("Educated", "Memoir", 4.6),
                new Book("Becoming", "Biography", 4.8),
                new Book("The Martian", "Science Fiction", 4.7)
        );

        reservations = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<BookReservation> getReservations() {
        return reservations;
    }

    public void addReservation(BookReservation reservation) {
        this.reservations.add(reservation);
    }
}
