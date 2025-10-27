package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }


    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        BookReservation br = new BookReservation(bookTitle, readerName, readerAddress, (long) numberOfCopies);
        return bookReservationRepository.save(br);
    }
}
