package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")

public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Book> books = bookService.listAll();
        model.addAttribute("bookList", books);
        return "listBooks";
    }

    @PostMapping
    public String searchBooks(@RequestParam String textContent, @RequestParam Double rating, @RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Book> books = bookService.searchBooks(textContent, rating);
        model.addAttribute("searchResults", books);
        return "listBooks";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {

        Author author = this.authorService.findAuthor(authorId);
        this.bookService.saveBook(new Book(title, genre, averageRating, author));
        return "redirect:/books";
    }

    @PostMapping("/edit/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        Author author = this.authorService.findAuthor(authorId);

        this.bookService.updateBook(bookId, title, genre, averageRating, author);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);

        return "redirect:/books";
    }

    @GetMapping("/book-form/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("book", this.bookService.getBook(id));
        } catch (Exception e) {
//            model.addAttribute("error", "BookNotFound");
            return "redirect:/books?error=BookNotFound";
        }
        model.addAttribute("authors", this.authorService.findAll());

        return "book-form";

    }

    @GetMapping("/book-form")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAddBookPage(Model model) {
        model.addAttribute("authors", this.authorService.findAll());
        return "book-form";
    }
}
