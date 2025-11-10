package mk.ukim.finki.wp.lab.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Book {
    private Long id;
    String title;
    String genre;
    double averageRating;
    private Author author;

    public Book(String title, String genre, double averageRating,Author author) {
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }

    public Book() {
        this.id = (long) (Math.random() * 1000);
        this.title = "No title";
        this.genre = "No genre";
        this.averageRating = 0.0;
        this.author = null;
    }

}
