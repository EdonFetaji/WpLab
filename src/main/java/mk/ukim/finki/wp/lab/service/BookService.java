package mk.ukim.finki.wp.lab.service;

import org.springframework.stereotype.Service;
import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;

@Service
public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);

}
