package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;
import java.util.UUID;


@Data
public class Book {

    String title;
    String genre;
    double averageRating;

    public Book(String title, String genre, double averageRating) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
    }

    public Book() {
        this.title = "No title";
        this.genre = "No genre";
        this.averageRating = 0.0;
    }
}
