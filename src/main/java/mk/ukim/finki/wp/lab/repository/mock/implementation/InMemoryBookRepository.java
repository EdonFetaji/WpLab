package mk.ukim.finki.wp.lab.repository.mock.implementation;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.lab.repository.mock.BookRepository;

import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {


    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(text.toLowerCase())
                        && b.getAverageRating() >= rating).toList();
    }

    @Override
    public void saveBook(Book book) {
        DataHolder.books.add(book);
    }

    @Override
    public void updateBook(Long id, String title, String genre, double averageRating, Author author) {
        Book book = this.getBook(id);
        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(averageRating);
        book.setAuthor(author);
        this.deleteBook(id);
        this.saveBook(book);
    }

    @Override
    public Book getBook(Long id) {
        return this.findAll().stream().filter(b -> b.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public void deleteBook(Long id) {
        DataHolder.books.removeIf(b -> b.getId().equals(id));
    }
}
