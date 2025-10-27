package mk.ukim.finki.wp.lab.service;

import org.springframework.stereotype.Service;
import mk.ukim.finki.wp.lab.model.*;

@Service
public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies);

}
