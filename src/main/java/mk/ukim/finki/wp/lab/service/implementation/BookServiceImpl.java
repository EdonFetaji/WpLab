package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.jpa.BookRepository;
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
        return this.bookRepository.findAllByTitleContainingIgnoreCaseAndAverageRatingGreaterThanEqual(text, rating);
    }

    @Override
    public void saveBook(Book book) {
        this.bookRepository.save(book);
    }


    @Override
    public void updateBook(Long id, String title, String genre, double averageRating, Author author) {
        Book b = this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        b.setTitle(title);
        b.setGenre(genre);
        b.setAverageRating(averageRating);
        b.setAuthor(author);

        this.bookRepository.save(b);
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book getBook(Long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
