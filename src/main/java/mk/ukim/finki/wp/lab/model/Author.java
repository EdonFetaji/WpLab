package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;
    @OneToMany(mappedBy = "author")
    List<Book> books;

    public Author(String name, String surname, String country, String biography) {
//        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
    }

    public Author() {
//        this.id = (long) (Math.random() * 1000);
        this.name = "";
        this.surname = "";
        this.country = "";
        this.biography = "";
    }
}
