package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookReservations")
public class BookReservationController {

    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @PostMapping("/add")
    public String addBookReservation(@RequestParam String bookTitle,
                                     @RequestParam String readerName,
                                     @RequestParam String readerAddress,
                                     @RequestParam int numberOfCopies,
                                     HttpServletRequest request,
                                     Model model) {
        String clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.isEmpty()) {
            clientIp = request.getRemoteAddr();
        }

        BookReservation reservation = bookReservationService.placeReservation(
                bookTitle, readerName, readerAddress, numberOfCopies
        );

        model.addAttribute("reservation", reservation);
        model.addAttribute("clientIp", clientIp);

        return "reservationConfirmation";
    }
}
