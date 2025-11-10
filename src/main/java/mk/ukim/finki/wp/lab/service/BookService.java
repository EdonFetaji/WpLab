package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import org.springframework.stereotype.Service;
import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;

@Service
public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    void saveBook(Book book);
    void updateBook(Long id,String title, String genre, double averageRating, Author author);
    void deleteBook(Long id);
    Book getBook(Long id);
}
