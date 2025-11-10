package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
    void saveBook(Book book);
    void updateBook(Long id,String title, String genre, double averageRating, Author author);
    Book getBook(Long id);
    void deleteBook(Long id);
}
