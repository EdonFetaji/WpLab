package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return this.bookRepository.searchBooks(text, rating);
    }

    @Override
    public void saveBook(Book book) {
        this.bookRepository.saveBook(book);
    }


    @Override
    public void updateBook(Long id, String title, String genre, double averageRating, Author author) {
        this.bookRepository.updateBook(id, title,  genre,  averageRating, author);
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteBook(id);
    }

    @Override
    public Book getBook(Long id) {
        return this.bookRepository.getBook(id);
    }
}
